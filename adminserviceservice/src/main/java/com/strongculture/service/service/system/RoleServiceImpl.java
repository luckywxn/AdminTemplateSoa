package com.strongculture.service.service.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.strongculture.service.contact.entity.system.GrantPermissionReqVo;
import com.strongculture.service.dao.entity.system.PermissionPo;
import com.strongculture.service.dao.entity.system.RolePO;
import com.strongculture.service.dao.entity.system.RolePermissionPo;
import com.strongculture.service.dao.mapper.system.PermissionsMapper;
import com.strongculture.service.dao.mapper.system.RoleMapper;
import com.strongculture.service.dao.mapper.system.RolePermissionMapper;
import com.strongculture.service.dao.request.RoleListReqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,RolePO> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private PermissionsMapper permissionsMapper;

    public Boolean removeRole(Long sysno) {
        if (roleMapper.deleteById(sysno) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<RolePO> listRole(RoleListReqVo reqVo) {
        return roleMapper.selectList(reqVo);
    }

    @Override
    public List<PermissionPo> getPermissionByRoleId(Long roleId) {
        LambdaQueryWrapper queryWrapper = new LambdaQueryWrapper<>();
        List<PermissionPo> allPermission = permissionsMapper.selectList(queryWrapper);
        List<RolePermissionPo> rolePermissionPoList = rolePermissionMapper.getByRoleId(roleId);
        if (!CollectionUtils.isEmpty(rolePermissionPoList)){
            List<Long> permissionIds = rolePermissionPoList.stream().map(RolePermissionPo::getPermissionId).distinct().collect(Collectors.toList());
            allPermission = allPermission.stream().map(x->{
                if (permissionIds.contains(x.getId())){
                    x.setHasPermission(true);
                }
                return x;
            }).collect(Collectors.toList());
        }
        return PermissionPo.buildTree(allPermission);
    }

    @Override
    @Transactional
    public void grantRolePermission(GrantPermissionReqVo reqVo) {
        rolePermissionMapper.deleteByRoleId(reqVo.getRoleId());
        if (CollectionUtils.isEmpty(reqVo.getPermissionIds())){
            return;
        }
        List<RolePermissionPo> rolePermissionPoList = reqVo.getPermissionIds().stream().map(item -> {
            RolePermissionPo rolePermissionPo = new RolePermissionPo();
            rolePermissionPo.setRoleId(reqVo.getRoleId());
            rolePermissionPo.setPermissionId(item);
            return rolePermissionPo;
        }).collect(Collectors.toList());
        rolePermissionMapper.insertBatch(rolePermissionPoList);
    }

}
