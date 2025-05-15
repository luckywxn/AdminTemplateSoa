package com.strongculture.service.contact.entity.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class GrantPermissionReqVo {
    @Schema(description = "角色id")
    private Long roleId;
    @Schema(description = "权限id")
    private List<Long> permissionIds;
}
