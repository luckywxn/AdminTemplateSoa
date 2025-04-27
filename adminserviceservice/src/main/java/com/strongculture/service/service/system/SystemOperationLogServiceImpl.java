package com.strongculture.service.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.strongculture.service.dao.entity.system.SystemOperationLogPO;
import com.strongculture.service.dao.mapper.system.SystemOperationLogMapper;
import com.strongculture.service.dao.request.OperationLogListReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemOperationLogServiceImpl extends ServiceImpl<SystemOperationLogMapper, SystemOperationLogPO> implements SystemOperationLogService {

    @Autowired
    private SystemOperationLogMapper systemOperationLogMapper;

    @Override
    public List<SystemOperationLogPO> selectList(OperationLogListReqVo reqVo) {
        return systemOperationLogMapper.selectList(reqVo);
    }
}
