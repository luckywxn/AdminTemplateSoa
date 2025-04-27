package com.strongculture.service.entity;

import com.strongculture.service.contact.entity.BaseResponse;
import lombok.Data;

@Data
public class GetRedisValueResponse extends BaseResponse {
    private String value;
}
