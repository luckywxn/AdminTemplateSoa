package com.strongculture.service.common;

import java.lang.annotation.*;

/**
 * 登录验证注解
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginPassport {
    boolean validPermission() default true;
}
