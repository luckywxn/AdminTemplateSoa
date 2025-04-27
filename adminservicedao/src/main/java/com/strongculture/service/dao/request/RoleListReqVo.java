package com.strongculture.service.dao.request;

import com.strongculture.service.contact.entity.BasePageRequest;
import lombok.Data;

/**
 * @Author lucky_wxn
 * @Date 14/11/2023 上午9:19
 * @Content
 */
@Data
public class RoleListReqVo extends BasePageRequest {
    private String roleName;
    private Integer status;
}
