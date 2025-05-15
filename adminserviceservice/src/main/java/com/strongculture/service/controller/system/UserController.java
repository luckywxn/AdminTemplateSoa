package com.strongculture.service.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.strongculture.service.common.utils.RequestUtil;
import com.strongculture.service.contact.entity.system.GrantUserRoleReqVo;
import com.strongculture.service.dao.entity.system.RolePO;
import com.strongculture.service.dao.entity.system.UserPO;
import com.strongculture.service.contact.entity.BaseResponse;
import com.strongculture.service.contact.entity.system.UpdatePasswordDTO;
import com.strongculture.service.contact.entity.system.UserLoginDTO;
import com.strongculture.service.common.LoginPassport;
import com.strongculture.service.common.utils.ValidateCodeUtil;
import com.strongculture.service.dao.request.UserListReqVo;
import com.strongculture.service.repository.SessionRepository;
import com.strongculture.service.service.common.IdService;
import com.strongculture.service.service.common.MessageService;
import com.strongculture.service.service.common.SessionService;
import com.strongculture.service.service.system.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Slf4j
@Tag(name="管理员服务")
@RestController
@RequestMapping("/system")
public class UserController {

    @Autowired
    private IdService idService;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @Operation(tags = "发送图片验证码")
    @RequestMapping(value = "/user/login/validateCode",method = RequestMethod.GET)
    public BaseResponse<String> getCodeImage(@RequestParam(value = "userName")String userName){
        BaseResponse<String> result = new BaseResponse<String>();
        if(Strings.isBlank(userName)){
            return result.FAIL(501,"请先输入登录账号");
        }

        ValidateCodeUtil.Validate randomCode = ValidateCodeUtil.getRandomCode();
        result.setData(randomCode.getBase64Str());
        log.info("验证码："+randomCode.getValue());
        messageService.setKeyValue(userName,randomCode.getValue().toUpperCase(),120);
        result.SUCCESS();
        return result;
    }

    @Operation(tags = "用户登录")
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public BaseResponse login(@RequestBody UserLoginDTO userLoginDTO, HttpServletResponse response) {
        BaseResponse result = new BaseResponse();
        userLoginDTO.setPassword(idService.encodeMd5(userLoginDTO.getPassword()));
        //用户登录
        UserPO userPO = userService.getByLoginAccount(userLoginDTO.getUsername());
        if(userPO == null){
            return result.FAIL(503,"该管理员不存在");
        }
        if (!userPO.getLoginPassword().equals(userLoginDTO.getPassword())){
            return result.FAIL(504,"密码错误");
        }

        String token = sessionService.createdSession(userPO.getLoginAccount(),userPO.getUserName(),30);
        List<String> permissionResource = userService.getPermissionsByUserId(userPO.getId());
        String jsonStr = JSONObject.toJSONString(permissionResource);
        sessionService.setValue(token,"adminUserPermission",jsonStr);
        response.addHeader("authorization",token);
        result.SUCCESS();
        return result;
    }

    @LoginPassport
    @Operation(tags = "用户退出登录")
    @RequestMapping(value = "/user/loginOut",method = RequestMethod.POST)
    public BaseResponse loginOut(HttpServletRequest request) {
        String token = request.getHeader("authorization");
        sessionRepository.removeSession(token);
        return new BaseResponse();
    }

    @LoginPassport
    @Operation(tags = "用户信息")
    @PostMapping(value = "/user/info")
    public BaseResponse<UserPO> getUserInfo() {
        BaseResponse result = new BaseResponse();
        UserPO userPO = RequestUtil.getCurrentUser();
        userPO.setMemus(userService.getMenuByUserId(userPO.getId()));
        result.SUCCESS(userPO);
        return result;
    }

    @Operation(tags = "添加管理员")
    @RequestMapping(value = "/user/created",method = RequestMethod.POST)
    @Transactional
    @LoginPassport
    public BaseResponse createdUser(@RequestBody UserPO userPO)  {
        BaseResponse result = new BaseResponse();
        //验证登录账户是否重复
        UserPO queryUser = userService.getByLoginAccount(userPO.getLoginAccount());
        if(queryUser != null){
            result.FAIL(501,"登录账户已存在");
            return result;
        }
        userPO.setLoginPassword(idService.encodeMd5(userPO.getLoginPassword()));
        userService.save(userPO);
        result.SUCCESS();

        return result;
    }

    @Operation(tags = "编辑管理员")
    @RequestMapping(value = "/user/modify",method = RequestMethod.POST)
    @LoginPassport
    @Transactional
    public BaseResponse modifyUser(@RequestBody UserPO userPO){
        if(userPO.getLoginPassword()!=null&&!userPO.getLoginPassword().equals("")){
            userPO.setLoginPassword(idService.encodeMd5(userPO.getLoginPassword()));
        }
        try {
            userService.updateById(userPO);
            return new BaseResponse();
        }catch (Exception e){
            return new BaseResponse(500,"修改失败");
        }
    }

    @Operation(tags = "获取管理员角色")
    @GetMapping(value = "/user/getUserRoleByUserId")
    @LoginPassport
    public BaseResponse<List<RolePO>> getUserRoleByUserId(@RequestParam(value = "userId") Long userId)  {
        return BaseResponse.ok(userService.getUserRoleByUserId(userId));
    }

    @Operation(tags = "给用户分配角色")
    @RequestMapping(value = "/user/grantUserRole",method = RequestMethod.POST)
    @LoginPassport
    public BaseResponse grantUserRole(@RequestBody GrantUserRoleReqVo reqVo){
        try {
            userService.grantUserRole(reqVo);
            return new BaseResponse<>();
        }catch (Exception e){
            log.error("grantUserRole error ",e);
            return new BaseResponse<>(500,"角色分配失败");
        }
    }

    @Operation(tags = "删除管理员")
    @RequestMapping(value = "/user/remove",method = RequestMethod.GET)
    @Transactional
    @LoginPassport
    public BaseResponse removeUser(@RequestParam(value = "id",required = true) Long id){
        BaseResponse result = new BaseResponse();
        userService.removeUser(id);
        result.SUCCESS();
        return result;
    }

    @Operation(tags = "修改密码")
    @RequestMapping(value = "/user/updatePassword",method = RequestMethod.POST)
    @LoginPassport(validPermission = false)
    @Transactional
    public BaseResponse updatePassword(@RequestBody UpdatePasswordDTO updatePasswordDTO){
        updatePasswordDTO.setOldPassword(idService.encodeMd5(updatePasswordDTO.getOldPassword()));
        UserPO userPO = userService.getByLoginAccount(updatePasswordDTO.getLoginAccount());
        if (userPO==null){
            return new BaseResponse(504,"帐号不存在");
        }else if(!userPO.getLoginPassword().equals(updatePasswordDTO.getOldPassword())){
            return new BaseResponse(505,"旧密码不正确");
        }

        userPO.setLoginPassword(idService.encodeMd5(updatePasswordDTO.getNewPassword()));
        userPO.setUpdatedAt(new Date());
        try {
            userService.updateById(userPO);
            return new BaseResponse();
        }catch (Exception err){
            log.info(err.toString());
            return new BaseResponse(506,"修改密码失败");
        }
    }

    @Operation(tags = "通过管理员id查询管理员信息")
    @RequestMapping(value = "/user/getById",method = RequestMethod.GET)
    @LoginPassport(validPermission = false)
    public BaseResponse<UserPO> getUserById(@RequestParam(value = "id",required = true) Long id){
        BaseResponse<UserPO> result = new BaseResponse<UserPO>();
        result.setData(userService.getById(id));
        result.SUCCESS();
        return result;
    }

    @Operation(tags = "查询管理员列表")
    @PostMapping(value = "/user/list")
    @LoginPassport(validPermission = false)
    public BaseResponse<List<UserPO>> listUser(@RequestBody UserListReqVo reqVo){
        BaseResponse<List<UserPO>> result = new BaseResponse<>();
        PageHelper.startPage(reqVo.getCurrent(),reqVo.getPageSize());
        PageInfo<UserPO> pageInfo = new PageInfo<UserPO>(userService.listUser(reqVo));
        result.setTotal(pageInfo.getTotal());
        result.setData(pageInfo.getList());
        result.SUCCESS();

        return result;
    }

}
