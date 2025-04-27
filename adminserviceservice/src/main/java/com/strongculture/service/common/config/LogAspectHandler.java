package com.strongculture.service.common.config;

import com.alibaba.fastjson.JSON;
import com.strongculture.service.common.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LogAspectHandler {

    /**
     * 切入点
     */
    @Pointcut("execution( * com.strongculture.service.controller.*.*.*(..))")
    public void aopPointCut() {
    }

    @Around("aopPointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Long startTime =System.currentTimeMillis();
        // 测试通过AOP设置多语言
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        String language = request.getHeader("Accept-Language");
//        log.info("语言为{}",language);
//        if("en_US".equals(language)){
//            LocaleContextHolder.setLocale(Locale.US);
//        }

        // 新增：检查是否是流操作接口
        boolean isStreamResponse = Arrays.stream(joinPoint.getArgs())
                .anyMatch(arg -> arg instanceof HttpServletResponse);
        List<Object> filteredArgs = Arrays.stream(joinPoint.getArgs())
                .filter(arg -> !(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse))
                .collect(Collectors.toList());
        try {
            if (!isStreamResponse) {
                log.info(methodName + " request = {}", JSON.toJSONString(filteredArgs));
            }
            Object object = joinPoint.proceed();
            RequestUtil.removeCurrentUser();
            // 新增：跳过流响应接口的日志记录
            if (!isStreamResponse && !(object instanceof HttpServletResponse)) {
                log.info(methodName + " response={}", JSON.toJSONString(object));
                long endTime = System.currentTimeMillis() - startTime;
                log.info("执行 " + methodName + " 耗时为：" + endTime + "ms");
            }
            return object;
        } catch (Throwable e) {
            log.error("执行 {}异常，异常信息为 {}",methodName,e);
        }
        return null;
    }
}
