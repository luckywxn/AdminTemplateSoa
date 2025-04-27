package com.strongculture.service.common.config;

import com.strongculture.service.common.LoginInterceptor;
import com.strongculture.service.common.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 增加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //增加多语言拦截器
//        registry.addInterceptor(new LanguageInterceptor());
        //增加登录验证拦截器
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }
}
