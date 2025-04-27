package com.strongculture.service.service.common;

import org.springframework.web.bind.annotation.*;

/**
 * session 服务
 */
public interface SessionService {

    /**
     * 创建 session
     * @param userId 用户id
     * @param username 用户帐号
     * @param expirationMinute 过期时间，单位分钟
     * @return token
     */
    String createdSession(String userId,String username,Integer expirationMinute);

    /**
     * 验证 session
     * @param token token
     * @return result
     */
    String validateSession(String token) ;

    /**
     * 设置值
     * @param token token
     * @param key key
     * @param value value
     * @return result
     */
    Boolean setValue(String token,String key,String value);

    /**
     * 获取值
     * @param token token
     * @param key key
     * @return result
     */
    String getValue(String token,String key);
}
