package com.strongculture.service.dao.mapper.system;

import com.strongculture.service.dao.common.LambdaQueryWrapperX;
import com.strongculture.service.dao.entity.system.RolePermissionPo;
import com.strongculture.service.dao.mapper.BaseMapperX;

import java.util.List;

public interface RolePermissionMapper extends BaseMapperX<RolePermissionPo> {

    default Integer deleteByRoleId(Long roleId){
        return delete(new LambdaQueryWrapperX<RolePermissionPo>()
                .eq(RolePermissionPo::getRoleId, roleId));
    }

    default List<RolePermissionPo> getByRoleId(Long roleId){
        return selectList(new LambdaQueryWrapperX<RolePermissionPo>()
                .eqIfPresent(RolePermissionPo::getRoleId, roleId));
    }

    default List<RolePermissionPo> getByRoleIdIn(List<Long> roleIds){
        return selectList(new LambdaQueryWrapperX<RolePermissionPo>()
                .inIfPresent(RolePermissionPo::getRoleId, roleIds));
    }
}
