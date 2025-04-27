package com.strongculture.service.service.common;

import com.strongculture.service.contact.entity.TokenSession;
import com.strongculture.service.common.utils.JwtUtil;
import com.strongculture.service.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SessionServiceImpl implements SessionService{

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public String createdSession(String userId, String username, Integer expirationMinute) {
        // 计算过期时间
        Date expirtationDate = new Date(new Date().getTime()+expirationMinute*60*1000);
        // 创建session对象
        TokenSession session = new TokenSession();
        session.setSessionId(java.util.UUID.randomUUID().toString().replace("-",""));
        session.setUserId(userId);
        session.setUsername(username);
        session.setCreatedTime(new Date());
        session.setExpirationTime(expirtationDate);
        // 创建token
        String token = jwtUtil.createdToken(session,true);
        session.setToken(token);
        // 创建在线session
        sessionRepository.saveSession(session);

        return token;
    }

    @Override
    public String validateSession(String token) {
        Integer trueFlag = 0;
        TokenSession session = null;
        if(jwtUtil.validateToken(token)){
            // 验证token是否有效
            session = jwtUtil.getSessionFromToken(token);
            trueFlag++;
        }
        if(session!=null){
            session = sessionRepository.getSession(token);
        }

        if(session != null && !session.getExpirationTime().before(new Date()) && session.getToken().equals(token)){
            // 验证session是否在线并未过期
            trueFlag ++;
        }
        if(trueFlag == 2){
            return session.getUserId();
        }else{
            return null;
        }
    }

    @Override
    public Boolean setValue(String token, String key, String value) {
        TokenSession session = jwtUtil.getSessionFromToken(token);
        session.setToken(token);
        return sessionRepository.setValue(session,key,value);
    }

    @Override
    public String getValue(String token, String key) {
        TokenSession session = jwtUtil.getSessionFromToken(token);
        return sessionRepository.getValue(session, key);
    }
}
