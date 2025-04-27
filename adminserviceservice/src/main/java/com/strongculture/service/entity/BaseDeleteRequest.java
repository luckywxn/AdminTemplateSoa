package com.strongculture.service.entity;

import com.strongculture.service.contact.entity.BaseRequest;
import lombok.Data;

@Data
public class BaseDeleteRequest extends BaseRequest {
    private Long id;
}
