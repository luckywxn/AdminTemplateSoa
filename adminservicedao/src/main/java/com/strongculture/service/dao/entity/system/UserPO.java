package com.strongculture.service.dao.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统用户PO对象
 */
@Data
@TableName(value = "system_user")
public class UserPO {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String loginAccount;
    private String loginPassword;
    private String userName;
    private String email;
    private String contactTel;
    private Integer status;
    private Boolean okDel;
    private Integer version;
    private Date createdAt;
    private Date updatedAt;

    @TableField(exist = false)
    private Integer[] role;
    @TableField(exist = false)
    private Map<String,Boolean> memus;
}
