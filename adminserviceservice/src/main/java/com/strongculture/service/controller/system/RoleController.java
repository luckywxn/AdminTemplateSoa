package com.strongculture.service.controller.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.strongculture.service.contact.entity.system.GrantPermissionReqVo;
import com.strongculture.service.dao.entity.system.PermissionPo;
import com.strongculture.service.dao.entity.system.RolePO;
import com.strongculture.service.contact.entity.BaseResponse;
import com.strongculture.service.common.LoginPassport;
import com.strongculture.service.dao.request.RoleListReqVo;
import com.strongculture.service.service.system.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags={"角色服务"})
@RestController
@RequestMapping("/system")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "添加角色",notes = "添加角色")
    @RequestMapping(value = "/role/created",method = RequestMethod.POST)
    @Transactional
    @LoginPassport
    public BaseResponse createdRole(@RequestBody RolePO rolePO){
        BaseResponse result = new BaseResponse();
        rolePO.setVersion(1);
        rolePO.setCreatedAt(new Date());
        rolePO.setOkDel(false);
        roleService.save(rolePO);
        result.SUCCESS();
        return result;
    }

    @ApiOperation(value = "修改角色",notes = "修改角色")
    @RequestMapping(value = "/role/modify",method = RequestMethod.POST)
    @LoginPassport
    @Transactional
    public BaseResponse modifyRole(@RequestBody RolePO rolePO){
        BaseResponse result = new BaseResponse();
        roleService.updateById(rolePO);
        result.SUCCESS();
        return result;
    }

    @LoginPassport
    @ApiOperation(value = "根据角色获权限")
    @RequestMapping(value = "/role/getPermissionByRoleId", method = RequestMethod.GET)
    public BaseResponse<List<PermissionPo>> getPermissionByRoleId(@RequestParam(value = "roleId",required = false)Long roleId){
        return BaseResponse.ok(roleService.getPermissionByRoleId(roleId));
    }

    @ApiOperation(value = "给角色分配权限",notes = "给角色分配权限")
    @RequestMapping(value = "/role/grantRolePermission",method = RequestMethod.POST)
    @LoginPassport
    public BaseResponse grantRolePermission(@RequestBody GrantPermissionReqVo reqVo){
        try {
            roleService.grantRolePermission(reqVo);
            return new BaseResponse<>();
        }catch (Exception e){
            log.error("grantRolePermission error ",e);
            return new BaseResponse<>(500,"权限分配失败");
        }
    }

    @ApiOperation(value = "删除角色",notes = "删除角色")
    @RequestMapping(value = "/role/remove",method = RequestMethod.GET)
    @LoginPassport
    @Transactional
    public BaseResponse removeRole(@RequestParam(value = "id") Long id){
        BaseResponse result = new BaseResponse();
        roleService.removeRole(id);
        result.SUCCESS();
        return result;
    }

    @ApiOperation(value = "角色列表",notes = "角色列表")
    @PostMapping(value = "/role/list")
    @LoginPassport(validPermission = false)
    public BaseResponse<List<RolePO>> listRole(@RequestBody RoleListReqVo reqVo){
        BaseResponse<List<RolePO>> result = new BaseResponse<>();
        PageHelper.startPage(reqVo.getCurrent(),reqVo.getPageSize());
        PageInfo<RolePO> pageInfo = new PageInfo<RolePO>(roleService.listRole(reqVo));
        result.setTotal(pageInfo.getTotal());
        result.setData(pageInfo.getList());
        result.SUCCESS();
        return result;
    }


}
