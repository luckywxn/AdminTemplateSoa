package com.strongculture.service.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.strongculture.service.dao.entity.system.PermissionPo;

public interface PermissionsService extends IService<PermissionPo> {
    PermissionPo getByResourceUrl(String resourseUrl);
}
