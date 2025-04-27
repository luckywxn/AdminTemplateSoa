package com.strongculture.service.dao.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 默认带常用字段基础PO类
 */
@Data
public class BasePO {
    private Integer status;
    private Boolean okDel;
    private Integer version;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createdAt;
    private Date updatedAt;
}
