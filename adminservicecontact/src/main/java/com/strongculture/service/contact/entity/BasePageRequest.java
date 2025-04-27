package com.strongculture.service.contact.entity;

import lombok.Data;

@Data
public class BasePageRequest extends BaseRequest{
    private Integer current = 1;
    private Integer pageSize = 10;
}
