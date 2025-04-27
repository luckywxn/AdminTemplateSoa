package com.strongculture.service.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.strongculture.service.dao.entity.system.PermissionPo;
import com.strongculture.service.dao.mapper.system.PermissionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, PermissionPo> implements PermissionsService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public PermissionPo getByResourceUrl(String resourseUrl) {
        return permissionsMapper.getByResourceUrl(resourseUrl);
    }
}
