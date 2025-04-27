package com.strongculture.service.repository;

import com.alibaba.fastjson.JSONObject;
import com.strongculture.service.contact.entity.TokenSession;
import com.strongculture.service.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RedisSessionRepository implements SessionRepository {

    @Autowired
    private RedisUtil redisUtil;

    public Boolean saveSession(TokenSession session) {
        String jsonStr=JSONObject.toJSONString(session);
        Long millSec=session.getExpirationTime().getTime()-session.getCreatedTime().getTime();
        int sec=Integer.parseInt(millSec.toString())/1000;
        redisUtil.set(session.getToken(),jsonStr,sec);
        return true;
    }

    public TokenSession getSession(String token) {
        TokenSession session=null;
        String jsonStr = redisUtil.get(token).toString();
        if(jsonStr!=null && !jsonStr.equals("")){
            try {
                session = JSONObject.parseObject(jsonStr, TokenSession.class);
            }catch (Exception err){
                err.printStackTrace();
            }
        }
        return session;
    }

    public Boolean setValue(TokenSession session, String key, String value) {
        TokenSession currencySession=null;
        String jsonStr = redisUtil.get(session.getToken()).toString();
        if(jsonStr!=null && !jsonStr.equals("")){
            try {
                currencySession = JSONObject.parseObject(jsonStr, TokenSession.class);
            }catch (Exception err){
                err.printStackTrace();
            }
        }
        if(currencySession!=null){
            Map<String,String> keyValue=currencySession.getKeyValue();
            if(keyValue==null){
                keyValue=new HashMap<String, String>();
            }
            keyValue.put(key,value);
            currencySession.setKeyValue(keyValue);
            this.saveSession(currencySession);
            return true;
        }

        return false;
    }

    public String getValue(TokenSession session, String key) {
        TokenSession currencySession=null;
        String jsonStr = redisUtil.get(session.getToken()).toString();

        if(jsonStr!=null && !jsonStr.equals("")){
            try {
                currencySession = JSONObject.parseObject(jsonStr, TokenSession.class);
            }catch (Exception err){
                err.printStackTrace();
            }
        }
        if(currencySession!=null && currencySession.getKeyValue()!=null){
            return currencySession.getKeyValue().get(key).toString();
        }
        return null;
    }

    @Override
    public void removeSession(String token) {
        redisUtil.del(token);
    }
}
