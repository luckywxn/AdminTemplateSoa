package com.strongculture.service.dao.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.strongculture.service.contact.entity.BasePageRequest;
import lombok.Data;

import java.util.Date;

@Data
public class OperationLogListReqVo extends BasePageRequest {
    @JsonFormat(pattern ="yyyy-MM-dd", timezone = "GMT+08:00")
    private Date createdAtStart;
    @JsonFormat(pattern ="yyyy-MM-dd", timezone = "GMT+08:00")
    private Date createdAtEnd;

    private String userAccount;
    private String userName;
    private String operaAction;
    private String operaName;
    private Integer operaStatus;
}
