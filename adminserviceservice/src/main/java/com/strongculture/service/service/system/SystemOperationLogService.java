package com.strongculture.service.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.strongculture.service.dao.entity.system.SystemOperationLogPO;
import com.strongculture.service.dao.request.OperationLogListReqVo;

import java.util.List;

public interface SystemOperationLogService extends IService<SystemOperationLogPO> {

    /**
     * 查询系统操作日志集合
     * @param operationLogPM
     * @return
     */
    List<SystemOperationLogPO> selectList(OperationLogListReqVo operationLogPM);
}
