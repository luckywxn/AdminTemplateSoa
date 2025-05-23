package com.strongculture.service.controller;

import com.strongculture.service.contact.entity.BaseResponse;
import com.strongculture.service.common.constant.ServiceConstants;
import com.strongculture.service.common.utils.RedisUtil;
import com.strongculture.service.entity.GetRedisValueResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Redis服务")
@RestController
@RequestMapping("/redis")
public class RedisContoller {

    @Autowired
    private RedisUtil redisUtil;

    @Operation(tags = "设置redis值")
    @PostMapping(value = "/setRedisValue")
    public BaseResponse setRedisValue(@RequestParam(value = "key") String key,@RequestParam(value = "value") String value){
        BaseResponse response = new BaseResponse();
        try {
            redisUtil.set(key,value);
            response.SUCCESS();;
        } catch (Exception e) {
            log.error("setRedisValue err",e);
            response.FAIL();
        }
        return response;
    }


     @Operation(tags = "获取redis值")
    @PostMapping(value = "/getRedisValue")
    public GetRedisValueResponse getRedisValue(@RequestParam(value = "key") String key){
        GetRedisValueResponse response = new GetRedisValueResponse();
        try {
            String value =String.valueOf(redisUtil.get(key));
            if(ServiceConstants.NULL.equals(value)){
                redisUtil.set(key,1000);
                value = "1000";
            }
            response.setValue(value);
            response.SUCCESS();;
        } catch (Exception e) {
            log.error("setRedisValue err",e);
            response.FAIL();
        }
        return response;
    }


}
