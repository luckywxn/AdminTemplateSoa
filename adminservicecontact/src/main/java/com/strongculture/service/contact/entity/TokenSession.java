package com.strongculture.service.contact.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Data
public class TokenSession implements Serializable {

    private String sessionId; // session id
    private String userId; // 用户 id
    private String username; // 用户帐号
    private String token; // token
    private Date expirationTime; // 过期时间
    private Date createdTime; //创建时间
    private Map<String,String> keyValue; // keyvalue 存储
}
