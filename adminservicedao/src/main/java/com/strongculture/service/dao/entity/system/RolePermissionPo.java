package com.strongculture.service.dao.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "system_role_permissions")
public class RolePermissionPo {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long roleId;
    private Long permissionId;

    @TableField(exist = false)
    private PermissionPo permission;

}
