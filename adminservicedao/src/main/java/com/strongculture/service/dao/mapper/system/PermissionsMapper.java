package com.strongculture.service.dao.mapper.system;

import com.strongculture.service.dao.common.LambdaQueryWrapperX;
import com.strongculture.service.dao.entity.system.PermissionPo;
import com.strongculture.service.dao.mapper.BaseMapperX;

import java.util.List;

public interface PermissionsMapper extends BaseMapperX<PermissionPo> {

    default PermissionPo getByResourceUrl(String resourseUrl){
        return selectOne(new LambdaQueryWrapperX<PermissionPo>()
                .eqIfPresent(PermissionPo::getResourceUrl,resourseUrl));
    }

    default List<PermissionPo> getByPermissionType(Integer permissionType){
        return selectList(new LambdaQueryWrapperX<PermissionPo>()
                .eqIfPresent(PermissionPo::getPermissionType,permissionType));
    }

}
