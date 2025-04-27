package com.strongculture.service.common;

import org.apache.logging.log4j.util.Strings;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getHeader("Accept-Language");
        Locale locale = Locale.getDefault();
        if(Strings.isNotEmpty(language)){
            String[] s = language.split("_");
            if(s.length == 2){
                locale=new Locale(s[0],s[1]);
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
