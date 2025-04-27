package com.strongculture.service.dao.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "system_operation_log")
public class SystemOperationLogPO {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String userAccount;
    private String userName;
    private String operaAction;
    private String operaName;
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date operaTime;
    private Integer operaStatus;
    private String operaContent;

    public static SystemOperationLogPO getSystemOperationLogPO(String userAccount, String userName, String operaAction, String operaName, String operaContent){
        SystemOperationLogPO systemOperationLogPO=new SystemOperationLogPO();
        systemOperationLogPO.setUserAccount(userAccount);
        systemOperationLogPO.setUserName(userName);
        systemOperationLogPO.setOperaAction(operaAction);
        systemOperationLogPO.setOperaName(operaName);
        systemOperationLogPO.setOperaTime(new Date());
        systemOperationLogPO.setOperaStatus(1);
        systemOperationLogPO.setOperaContent(operaContent);
        return systemOperationLogPO;
    }
}
