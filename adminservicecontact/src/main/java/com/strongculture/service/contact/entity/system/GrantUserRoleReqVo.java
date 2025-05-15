package com.strongculture.service.contact.entity.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class GrantUserRoleReqVo {
    @Schema(description = "用户id")
    private Long userId;
    @Schema(description = "角色id")
    private List<Long> roleIds;
}
