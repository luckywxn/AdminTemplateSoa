package com.strongculture.service.dao.mapper.system;

import com.strongculture.service.dao.common.LambdaQueryWrapperX;
import com.strongculture.service.dao.entity.system.UserRolePo;
import com.strongculture.service.dao.mapper.BaseMapperX;

import java.util.List;

public interface UserRoleMapper extends BaseMapperX<UserRolePo> {

    default Integer deleteByUserId(Long userId){
        return delete(new LambdaQueryWrapperX<UserRolePo>()
                .eq(UserRolePo::getUserId, userId));
    }
    default List<UserRolePo> getByUserId(Long userId){
        return selectList(new LambdaQueryWrapperX<UserRolePo>()
                .eqIfPresent(UserRolePo::getUserId,userId)
        );
    }
}
