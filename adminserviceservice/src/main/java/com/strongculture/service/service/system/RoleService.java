package com.strongculture.service.service.system;

import com.strongculture.service.contact.entity.system.GrantPermissionReqVo;
import com.strongculture.service.dao.entity.system.PermissionPo;
import com.strongculture.service.dao.entity.system.RolePO;
import com.strongculture.service.dao.request.RoleListReqVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface RoleService extends IService<RolePO>{
    Boolean removeRole(Long sysno);
    List<RolePO> listRole(RoleListReqVo reqVo);
    List<PermissionPo> getPermissionByRoleId(Long roleId);
    void grantRolePermission(GrantPermissionReqVo reqVo);
}
