package com.strongculture.service.dao.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统权限PO对象
 */
@Data
@TableName(value = "system_permission")
public class PermissionPo extends BasePO {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long parentId;
    private Integer permissionType;
    private String permissionCode;
    private String permissionName;
    private String resourceUrl;
    private String menuIcon;
    private Integer menuSortnum;
    private String permissionRemark;

    @TableField(exist = false)
    private Boolean hasPermission;
    @TableField(exist = false)
    private List<PermissionPo> children;

    public static List<PermissionPo> buildTree(List<PermissionPo> list) {
        // 1. 获取所有根节点（假设根节点的parentId=0）
        List<PermissionPo> roots = list.stream()
                .filter(p -> p.getParentId() == 0)
                .sorted(Comparator.comparingInt(PermissionPo::getMenuSortnum))
                .collect(Collectors.toList());

        // 2. 递归设置子节点
        roots.forEach(root -> findChildren(root, list));
        return roots;
    }

    private static  void findChildren(PermissionPo parent, List<PermissionPo> list) {
        List<PermissionPo> children = list.stream()
                .filter(p -> p.getParentId().equals(parent.getId()))
                .sorted(Comparator.comparingInt(PermissionPo::getMenuSortnum))
                .collect(Collectors.toList());

        parent.setChildren(children);
        children.forEach(child -> findChildren(child, list));
    }
}
