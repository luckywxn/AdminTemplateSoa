package com.strongculture.service.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
public class LanguageInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {
        if (handler instanceof HandlerMethod) {
            String language = request.getHeader("Accept-Language");
            log.info("语言为{}",language);
            if ("en_US".equals(language)) {
                LocaleContextHolder.setLocale(Locale.US);
            }else {
                LocaleContextHolder.setLocale(Locale.CHINA);
            }
        }
        return true;
    }

}
