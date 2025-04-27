package com.strongculture.service.contact.entity.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GrantUserRoleReqVo {
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "角色id")
    private List<Long> roleIds;
}
