package com.strongculture.service.contact.entity.system;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GrantPermissionReqVo {
    @ApiModelProperty(value = "角色id")
    private Long roleId;
    @ApiModelProperty(value = "权限id")
    private List<Long> permissionIds;
}
