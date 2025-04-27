package com.strongculture.service.service.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.strongculture.service.contact.entity.system.GrantUserRoleReqVo;
import com.strongculture.service.contact.enums.StatusEnum;
import com.strongculture.service.dao.entity.system.*;
import com.strongculture.service.dao.mapper.system.*;
import com.strongculture.service.dao.request.RoleListReqVo;
import com.strongculture.service.dao.request.UserListReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserPO> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionsMapper permissionsMapper;

    public Boolean removeUser(Long id) {
        if (userMapper.deleteById(id) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public UserPO getByLoginAccount(String loginAccount) {
        return userMapper.getByLoginAccount(loginAccount);
    }

    public List<UserPO> listUser(UserListReqVo reqVo) {
        return userMapper.selectList(reqVo);
    }

    @Override
    public Map<String,Boolean> getMenuByUserId(Long userId) {
        List<PermissionPo> memuPerssionList = permissionsMapper.getByPermissionType(2);
        List<Long> permissionIds = new ArrayList<>();
        List<UserRolePo> userRolePos = userRoleMapper.getByUserId(userId);
        if (!CollectionUtils.isEmpty(userRolePos)){
            List<Long> roleIds = userRolePos.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
            List<RolePermissionPo> rolePermissionPoList = rolePermissionMapper.getByRoleIdIn(roleIds);
            if (!CollectionUtils.isEmpty(rolePermissionPoList)){
                permissionIds = rolePermissionPoList.stream().map(RolePermissionPo::getPermissionId).distinct().collect(Collectors.toList());
            }
        }
        List<Long> finalPermissionIds = permissionIds;
        return memuPerssionList.stream().collect(Collectors.toMap(PermissionPo::getResourceUrl, x-> finalPermissionIds.contains(x.getId()),(k1, k2)->k1));
    }

    @Override
    public List<String> getPermissionsByUserId(Long userId) {
        List<UserRolePo> userRolePos = userRoleMapper.getByUserId(userId);
        if(CollectionUtils.isEmpty(userRolePos)){
            return Collections.emptyList();
        }
        List<Long> roleIds = userRolePos.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
        List<RolePermissionPo> rolePermissionPoList = rolePermissionMapper.getByRoleIdIn(roleIds);
        if (CollectionUtils.isEmpty(rolePermissionPoList)){
            return Collections.emptyList();
        }
        List<Long> permissionIds = rolePermissionPoList.stream().map(RolePermissionPo::getPermissionId).distinct().collect(Collectors.toList());
        List<PermissionPo> permissionPos = permissionsMapper.selectBatchIds(permissionIds);
        return permissionPos.stream().filter(x->x.getPermissionType() ==3).map(x->x.getResourceUrl()).collect(Collectors.toList());
    }

    @Override
    public List<RolePO> getUserRoleByUserId(Long userId) {
        RoleListReqVo reqVo = new RoleListReqVo();
        reqVo.setStatus(StatusEnum.NORMAL.getCode());
        List<RolePO> rolePOList = roleMapper.selectList(reqVo);
        if(CollectionUtils.isEmpty(rolePOList)){
            return Collections.emptyList();
        }
        List<UserRolePo> userRolePos = userRoleMapper.getByUserId(userId);
        if(!CollectionUtils.isEmpty(userRolePos)){
            List<Long> roleIds = userRolePos.stream().map(UserRolePo::getRoleId).collect(Collectors.toList());
            rolePOList.stream().map(x->{
                if (roleIds.contains(x.getId())){
                    x.setHasRole(true);
                }
                return x;
            }).collect(Collectors.toList());
        }
        return rolePOList;
    }

    @Override
    public void grantUserRole(GrantUserRoleReqVo reqVo) {
        userRoleMapper.deleteByUserId(reqVo.getUserId());
        if (CollectionUtils.isEmpty(reqVo.getRoleIds())){
            return;
        }
        List<UserRolePo> rolePoList = reqVo.getRoleIds().stream().map(item -> {
            UserRolePo userRolePo = new UserRolePo();
            userRolePo.setUserId(reqVo.getUserId());
            userRolePo.setRoleId(item);
            return userRolePo;
        }).collect(Collectors.toList());
        userRoleMapper.insertBatch(rolePoList);
    }

}
