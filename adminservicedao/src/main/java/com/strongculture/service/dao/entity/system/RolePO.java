package com.strongculture.service.dao.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName(value = "system_role")
public class RolePO extends BasePO {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String roleName;
    private String roleRemark;

    @TableField(exist = false)
    private Boolean hasRole;
}
