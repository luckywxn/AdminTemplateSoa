package com.strongculture.service.common.utils;

import com.strongculture.service.contact.entity.TokenSession;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Java Token工具类
 */
@Component
public class JwtUtil {

    @Value("${session.jwt.secret}")
    private String secret;

    /**
     * 创建token 带过期时间
     * @param claims claims
     * @param expirationTime 过期时间
     * @return token
     */
    public String createdToken(Map<String,Object> claims,Date expirationTime){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS256,this.secret)
                .compact();
    }

    /**
     * 创建token 使用自定义过期时间
     * @param session  session
     * @param isExpiration 定义过期时间
     * @return token
     */
    public String createdToken(TokenSession session,Boolean isExpiration){
        Map<String,Object> claims=new HashMap<String, Object>();
        claims.put("sessionId",session.getSessionId());
        claims.put("userId",session.getUserId());
        claims.put("username",session.getUsername());
        return this.createdToken(claims,session.getExpirationTime());
    }

    /**
     * 验证token
     * @param token token
     * @return 有效true,无效false
     */
    public Boolean validateToken(String token){
        return !this.isTokenExpired(token);
    }

    public void removeSession(String token) {

    }

    /**
     * 从token中获取session
     * @param token token
     * @return session
     */
    public TokenSession getSessionFromToken(String token){
        TokenSession session;
        try{
            final Claims claims = this.getClaimsFromToken(token);
            session = new TokenSession();
            session.setSessionId(claims.get("sessionId")==null?"":claims.get("sessionId").toString());
            session.setUserId(claims.get("userId")==null?"":claims.get("userId").toString());
            session.setUsername(claims.get("username")==null?"":claims.get("username").toString());
            session.setToken(token);
        }catch (Exception err){
            session = null;
        }
        return session;
    }

    /**
     * 从Token中获取Claims
     * @param token token
     * @return Claims
     */
    public Claims getClaimsFromToken(String token){
        Claims claims;
        try{
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception err){
            claims=null;
        }
        return claims;
    }

    /**
     * 获取过Token过期时间
     * @param token token
     * @return 过期时间
     */
    public Date getExpirationDateFromToken(String token){
        Date expiration;
        try{
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        }catch (Exception err){
            expiration = null;
        }
        return expiration;
    }
    /**
     * 验证token是否过期
     * @param token token
     * @return 过期：true,未过期：false
     */
    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        if(expiration == null){
            return true;
        }
        return expiration.before(new Date());
    }

}
