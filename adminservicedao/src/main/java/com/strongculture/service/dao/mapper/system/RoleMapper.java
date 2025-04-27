package com.strongculture.service.dao.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.strongculture.service.dao.common.LambdaQueryWrapperX;
import com.strongculture.service.dao.entity.system.RolePO;
import com.strongculture.service.dao.request.RoleListReqVo;

import java.util.List;

public interface RoleMapper extends BaseMapper<RolePO> {
    default List<RolePO> selectList(RoleListReqVo reqVo){
        return selectList(new LambdaQueryWrapperX<RolePO>()
                .likeIfPresent(RolePO::getRoleName,reqVo.getRoleName())
                .eqIfPresent(RolePO::getStatus,reqVo.getStatus()));
    };
}
