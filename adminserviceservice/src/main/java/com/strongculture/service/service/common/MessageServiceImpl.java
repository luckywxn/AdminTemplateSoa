package com.strongculture.service.service.common;

import com.strongculture.service.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String sendSms(String templateCode, String phoneNumber, Map<String, String> params) {
        return null;
    }

    @Override
    public void sendMail(String to, String subject, String content) {

    }

    @Override
    public void setKeyValue(String key, String value, Integer seconds) {
        redisUtil.set(key,value,seconds);
    }

    @Override
    public String getValue(String key) {
        return redisUtil.get(key).toString();
    }
}
