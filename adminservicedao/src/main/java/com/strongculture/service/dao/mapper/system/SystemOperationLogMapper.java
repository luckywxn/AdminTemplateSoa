package com.strongculture.service.dao.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.strongculture.service.dao.common.LambdaQueryWrapperX;
import com.strongculture.service.dao.entity.system.SystemOperationLogPO;
import com.strongculture.service.dao.request.OperationLogListReqVo;

import java.util.List;

public interface SystemOperationLogMapper extends BaseMapper<SystemOperationLogPO> {
    default List<SystemOperationLogPO> selectList(OperationLogListReqVo reqVo){
        return selectList(new LambdaQueryWrapperX<SystemOperationLogPO>()
                .likeIfPresent(SystemOperationLogPO::getUserAccount,reqVo.getUserAccount())
                .likeIfPresent(SystemOperationLogPO::getUserName,reqVo.getUserName())
                .likeIfPresent(SystemOperationLogPO::getOperaAction,reqVo.getOperaAction())
                .likeIfPresent(SystemOperationLogPO::getOperaName,reqVo.getOperaName())
                .eqIfPresent(SystemOperationLogPO::getOperaStatus,reqVo.getOperaStatus())
                .geIfPresent(SystemOperationLogPO::getOperaTime,reqVo.getCreatedAtStart())
                .leIfPresent(SystemOperationLogPO::getOperaTime,reqVo.getCreatedAtEnd())
        );
    }
}
