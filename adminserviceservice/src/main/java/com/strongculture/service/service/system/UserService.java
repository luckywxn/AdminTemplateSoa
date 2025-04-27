package com.strongculture.service.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.strongculture.service.contact.entity.system.GrantUserRoleReqVo;
import com.strongculture.service.dao.entity.system.RolePO;
import com.strongculture.service.dao.entity.system.UserPO;
import com.strongculture.service.dao.request.UserListReqVo;

import java.util.List;
import java.util.Map;

public interface UserService extends IService<UserPO> {
    Boolean removeUser(Long id);
    UserPO getByLoginAccount(String loginAccount);
    List<UserPO> listUser(UserListReqVo reqVo);
    Map<String,Boolean> getMenuByUserId(Long userId);
    List<String> getPermissionsByUserId(Long userId);
    List<RolePO> getUserRoleByUserId(Long userId);
    void grantUserRole(GrantUserRoleReqVo reqVo);
}
