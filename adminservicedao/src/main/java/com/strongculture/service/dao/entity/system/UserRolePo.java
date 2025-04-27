package com.strongculture.service.dao.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "system_user_role")
public class UserRolePo {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long roleId;

    @TableField(exist = false)
    private RolePO role;
}
