package com.strongculture.service.common;

import com.alibaba.fastjson.JSONObject;
import com.strongculture.service.common.utils.RequestUtil;
import com.strongculture.service.dao.entity.system.PermissionPo;
import com.strongculture.service.dao.entity.system.SystemOperationLogPO;
import com.strongculture.service.dao.entity.system.UserPO;
import com.strongculture.service.service.common.SessionService;
import com.strongculture.service.service.system.PermissionsService;
import com.strongculture.service.service.system.SystemOperationLogService;
import com.strongculture.service.service.system.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

/**
 * 登录验证器
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private SystemOperationLogService systemOperationLogService;
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionsService permissionsService;

    String [] apiUrl = {"/api/system/user/info","/api/system/user/loginOut"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否为方法
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            //判断是否标注了登录验证注解
            LoginPassport loginPassport = ((HandlerMethod)handler).getMethodAnnotation(LoginPassport.class);
            if(loginPassport == null){
                //如果未加登录验证，则跳过并返回
                return true;
            }
            //取得HTTP头中的Authorization中保存的token
            String token = request.getHeader("Authorization");
            if(token == null || token.equals("")){
                //如果token为空，返回400未登录
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.write("{\"code\":403,\"message\":\"未登录\"}");
                out.close();
                return false;
            }
            //如果token不为空，则验证token
            //解决非拦截器不注入service问题，手动注入
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            sessionService = factory.getBean(SessionService.class);

            token = token.replace("\"",""); // 去除多余字符
            String memberId = sessionService.validateSession(token);
            if(memberId == null || memberId.equals("")){
                //token 验证无效，返回登录失效
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out=response.getWriter();
                out.write("{\"code\":401,\"message\":\"登录失效\"}");
                out.close();
                return false;
            }

            userService = factory.getBean(UserService.class);
            permissionsService = factory.getBean(PermissionsService.class);
            systemOperationLogService = factory.getBean(SystemOperationLogService.class);
            UserPO userPO = userService.getByLoginAccount(memberId);
            if(userPO == null){
                PrintWriter out=response.getWriter();
                out.write("{\"code\":508,\"message\":\"用户不存在\"}");
                out.close();
                return false;
            }
            RequestUtil.setCurrentUser(userPO);
            String userAccount = userPO.getLoginAccount();
            String userName = userPO.getUserName();
            String operaAction = request.getRequestURI();
            PermissionPo permissionPo = permissionsService.getByResourceUrl(operaAction);
            if (permissionPo != null){
                systemOperationLogService.save(getSystemOperationLogPO(userAccount,userName,operaAction,permissionPo.getPermissionName()));
            }

            Boolean flag = false;
            if(!loginPassport.validPermission()){
                flag = true;
            } else if(Arrays.asList(apiUrl).contains(operaAction)){
                flag = true;
            }else{
                String userPermissionJsonStr = sessionService.getValue(token,"adminUserPermission");
                List<String> permissionResource = JSONObject.parseArray(userPermissionJsonStr,String.class);
                if (permissionResource.contains(request.getRequestURI())){
                    return true;
                }
            }

            if(!flag){
                //无权限
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.write("{\"code\":403,\"message\":\"无权限\"}");
                out.close();
                return false;
            }
            return true;

        }else{
            return true;
        }
    }

    public SystemOperationLogPO getSystemOperationLogPO(String userAccount, String userName, String operaAction, String operaName){
        SystemOperationLogPO systemOperationLogPO=new SystemOperationLogPO();
        systemOperationLogPO.setUserAccount(userAccount);
        systemOperationLogPO.setUserName(userName);
        systemOperationLogPO.setOperaAction(operaAction);
        systemOperationLogPO.setOperaName(operaName);
        systemOperationLogPO.setOperaTime(new Date());
        systemOperationLogPO.setOperaStatus(1);
        return systemOperationLogPO;
    }
}
