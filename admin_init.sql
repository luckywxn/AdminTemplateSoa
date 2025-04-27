/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50736 (5.7.36)
 Source Host           : 106.15.56.58:3306
 Source Schema         : admin_init

 Target Server Type    : MySQL
 Target Server Version : 50736 (5.7.36)
 File Encoding         : 65001

 Date: 27/04/2025 17:21:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_group
-- ----------------------------
DROP TABLE IF EXISTS `system_group`;
CREATE TABLE `system_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `group_name` varchar(50) NOT NULL COMMENT '组名',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '所属上级组sysno，无上线为0',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：1正常2停用',
  `ok_del` bit(1) NOT NULL COMMENT '逻辑删除：1是0否',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统-部门组表';

-- ----------------------------
-- Records of system_group
-- ----------------------------
BEGIN;
INSERT INTO `system_group` (`id`, `group_name`, `parent_id`, `status`, `ok_del`, `version`, `created_at`, `updated_at`) VALUES (1, '管理组', 0, 1, b'0', 1, '2018-07-10 11:44:28', '2018-07-11 15:06:14');
COMMIT;

-- ----------------------------
-- Table structure for system_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `system_operation_log`;
CREATE TABLE `system_operation_log` (
  `id` bigint(32) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_account` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '操作人帐号',
  `user_name` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作人名称',
  `opera_action` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作action',
  `opera_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作名称',
  `opera_time` datetime DEFAULT NULL COMMENT '操作时间',
  `opera_status` tinyint(1) NOT NULL COMMENT '操作状态：1成功2失败',
  `opera_content` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=COMPACT COMMENT='系统操作日志';

-- ----------------------------
-- Records of system_operation_log
-- ----------------------------
BEGIN;
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (1, 'admin', '超级管理员', '/system/user/list', '管理员查询', '2025-04-18 18:11:00', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (2, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:11:28', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (3, 'admin', '超级管理员', '/system/user/list', '管理员查询', '2025-04-18 18:12:47', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (4, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:12:53', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (5, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:15:03', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (6, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:16:46', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (7, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:19:32', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (8, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:26:38', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (9, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:29:02', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (10, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:34:02', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (11, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:38:13', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (12, 'admin', '超级管理员', '/system/user/list', '管理员查询', '2025-04-18 18:39:07', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (13, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:40:50', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (14, 'admin', '超级管理员', '/system/user/list', '管理员查询', '2025-04-18 18:41:41', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (15, 'admin', '超级管理员', '/system/role/list', '角色查询', '2025-04-18 18:42:00', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (16, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-22 13:38:59', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (17, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-22 13:40:04', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (18, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-22 13:40:08', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (19, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-22 14:01:36', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (20, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-22 14:01:42', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (21, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-22 14:01:43', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (22, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:07:42', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (23, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-23 13:07:48', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (24, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:08:05', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (25, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:10:44', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (26, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:11:12', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (27, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:12:24', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (28, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:12:43', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (29, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:12:59', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (30, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:13:05', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (31, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:14:02', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (32, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:14:22', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (33, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:14:34', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (34, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:14:47', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (35, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:15:26', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (36, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:25:21', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (37, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:25:40', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (38, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:25:45', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (39, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:25:51', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (40, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:26:37', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (41, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:27:51', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (42, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:28:56', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (43, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:30:18', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (44, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:35:10', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (45, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:35:13', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (46, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:35:28', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (47, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-23 13:37:26', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (48, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 09:13:47', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (49, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 09:14:12', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (50, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 09:14:30', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (51, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 09:19:48', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (52, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-24 09:19:53', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (53, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 09:59:30', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (54, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 13:05:18', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (55, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 13:09:03', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (56, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 13:12:47', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (57, 'admin', '超级管理员', '/api/system/role/grantRolePermission', '角色分配权限', '2025-04-24 13:12:51', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (58, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 13:20:15', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (59, 'admin', '超级管理员', '/api/system/role/grantRolePermission', '角色分配权限', '2025-04-24 13:20:19', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (60, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 13:21:39', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (61, 'admin', '超级管理员', '/api/system/role/grantRolePermission', '角色分配权限', '2025-04-24 13:21:45', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (62, 'admin', '超级管理员', '/api/system/role/grantRolePermission', '角色分配权限', '2025-04-24 13:23:08', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (63, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 13:23:11', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (64, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 13:24:09', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (65, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 13:24:55', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (66, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-24 13:25:08', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (67, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:42:18', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (68, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:43:39', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (69, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:43:48', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (70, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:45:29', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (71, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:48:43', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (72, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-25 09:53:18', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (73, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-25 09:54:19', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (74, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:54:26', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (75, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-25 09:54:30', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (76, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:54:58', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (77, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:55:04', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (78, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-25 09:55:10', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (79, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:57:53', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (80, 'admin', '超级管理员', '/api/system/role/created', '角色添加', '2025-04-25 09:58:02', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (81, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 09:59:52', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (82, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 10:00:59', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (83, 'admin', '超级管理员', '/api/system/role/modify', '角色编辑', '2025-04-25 10:01:08', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (84, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 10:01:08', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (85, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 12:36:37', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (86, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-25 13:23:52', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (87, 'admin', '超级管理员', '/api/system/user/modify', '管理员编辑', '2025-04-25 13:26:56', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (88, 'admin', '超级管理员', '/api/system/user/modify', '管理员编辑', '2025-04-25 13:28:14', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (89, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:21:07', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (90, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:30:03', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (91, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:30:22', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (92, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:32:23', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (93, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:32:28', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (94, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:34:41', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (95, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:34:47', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (96, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:35:40', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (97, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:36:20', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (98, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:37:52', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (99, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:39:20', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (100, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:44:25', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (101, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:44:38', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (102, 'admin', '超级管理员', '/api/system/role/list', '角色查询', '2025-04-27 09:54:52', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (103, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 11:18:53', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (104, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 11:20:22', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (105, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 11:20:59', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (106, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 11:21:17', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (107, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 11:21:57', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (108, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 11:22:23', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (109, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:06:44', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (110, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:06:47', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (111, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:10:32', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (112, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:10:35', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (113, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:16:22', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (114, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:16:46', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (115, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:18:24', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (116, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:19:01', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (117, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:19:11', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (118, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:19:51', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (119, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:21:06', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (120, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:22:06', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (121, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:22:16', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (122, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:23:04', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (123, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:24:57', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (124, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:25:13', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (125, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:25:23', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (126, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:25:30', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (127, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:25:43', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (128, 'admin', '超级管理员', '/api/system/user/getUserRoleByUserId', '获取用户角色', '2025-04-27 13:27:24', 1, NULL);
INSERT INTO `system_operation_log` (`id`, `user_account`, `user_name`, `opera_action`, `opera_name`, `opera_time`, `opera_status`, `opera_content`) VALUES (129, 'admin', '超级管理员', '/api/system/user/grantUserRole', '用户分配角色', '2025-04-27 13:27:27', 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for system_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `parent_id` bigint(20) NOT NULL COMMENT '所属上级sysno，无为0',
  `permission_code` varchar(20) NOT NULL COMMENT '权限代码',
  `permission_name` varchar(50) NOT NULL COMMENT '权限名称',
  `permission_remark` varchar(100) DEFAULT NULL COMMENT '权限备注',
  `permission_type` tinyint(1) NOT NULL COMMENT '权限类型：1菜单2显示3功能',
  `resource_url` varchar(255) DEFAULT NULL COMMENT '权限资源网址',
  `resource_controller` varchar(50) DEFAULT NULL COMMENT '权限资源mvc controller',
  `resource_action` varchar(50) DEFAULT NULL COMMENT '权限资源mvc action',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：1正常2停用',
  `ok_del` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除：1是0否',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `menu_icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `menu_sortnum` int(11) NOT NULL DEFAULT '0' COMMENT '排序号，倒序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统-权限表';

-- ----------------------------
-- Records of system_permission
-- ----------------------------
BEGIN;
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (3, 0, '102', '系统管理', NULL, 1, NULL, NULL, NULL, 1, b'0', 1, '2018-12-21 12:47:51', NULL, 'el-icon-goods', 99);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (5, 3, '107-102', '角色管理', NULL, 2, '/role', NULL, NULL, 1, b'0', 1, '2018-07-12 19:13:18', '2018-07-18 14:09:51', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (7, 3, '107-104', '管理员管理', NULL, 2, '/user', NULL, NULL, 1, b'0', 1, '2018-07-12 19:13:54', '2018-07-18 14:13:05', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (8, 3, '107-105', '操作日志', '', 2, '/operationLog', '', '', 1, b'0', 1, '2019-04-01 17:36:49', NULL, NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (13, 5, '107-102-101', '角色添加', '', 3, '/api/system/role/created', '', '', 1, b'0', 1, '2018-07-18 14:10:08', '2018-07-31 12:00:22', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (14, 5, '107-102-102', '角色编辑', '', 3, '/api/system/role/modify', '', '', 1, b'0', 1, '2018-07-18 14:10:22', '2018-07-31 12:00:34', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (15, 5, '107-102-103', '角色删除', '', 3, '/system/role/remove', '', '', 1, b'0', 1, '2018-07-18 14:10:38', '2018-07-31 12:00:46', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (16, 5, '107-102-104', '角色查询', '', 3, '/api/system/role/list', '', '', 1, b'0', 1, '2018-07-18 14:11:17', '2018-07-31 12:00:00', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (17, 5, '107-102-105', '获取角色权限', '', 3, '/api/system/role/getPermissionByRoleId', '', '', 1, b'0', 1, '2018-07-18 14:11:17', '2018-07-31 12:00:00', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (18, 5, '107-102-105', '角色分配权限', '', 3, '/api/system/role/grantRolePermission', '', '', 1, b'0', 1, '2018-07-18 14:11:17', '2018-07-31 12:00:00', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (19, 5, '107-102-105', '获取用户角色', '', 3, '/api/system/user/getUserRoleByUserId', '', '', 1, b'0', 1, '2018-07-18 14:11:17', '2018-07-31 12:00:00', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (20, 5, '107-102-105', '用户分配角色', '', 3, '/api/system/user/grantUserRole', '', '', 1, b'0', 1, '2018-07-18 14:11:17', '2018-07-31 12:00:00', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (21, 7, '107-104-101', '管理员添加', '', 3, '/api/system/user/created', '', '', 1, b'0', 1, '2018-07-18 14:13:21', '2018-07-31 12:04:23', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (22, 7, '107-104-102', '管理员编辑', '', 3, '/api/system/user/modify', '', '', 1, b'0', 1, '2018-07-18 14:13:35', '2018-07-31 12:04:49', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (23, 7, '107-104-103', '管理员删除', '', 3, '/system/user/remove', '', '', 1, b'0', 1, '2018-07-18 14:13:54', '2018-07-31 12:05:02', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (24, 7, '107-104-104', '管理员查询', '', 3, '/system/user/list', '', '', 1, b'0', 1, '2018-07-18 14:14:09', '2018-07-31 12:03:11', NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (25, 7, '107-104-105', '重置密码', '', 3, '/system/user/resetPassword', '', '', 1, b'0', 1, '2018-12-29 18:57:20', NULL, NULL, 0);
INSERT INTO `system_permission` (`id`, `parent_id`, `permission_code`, `permission_name`, `permission_remark`, `permission_type`, `resource_url`, `resource_controller`, `resource_action`, `status`, `ok_del`, `version`, `created_at`, `updated_at`, `menu_icon`, `menu_sortnum`) VALUES (26, 8, '107-105-101', '操作日志记录', '', 3, '/system/operation/log/selectList', '', '', 1, b'0', 1, '2019-04-01 17:37:48', NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_remark` varchar(255) DEFAULT NULL COMMENT '角色说明',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：1正常2停用',
  `ok_del` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除：1是0否',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统-角色信息表';

-- ----------------------------
-- Records of system_role
-- ----------------------------
BEGIN;
INSERT INTO `system_role` (`id`, `role_name`, `role_remark`, `status`, `ok_del`, `version`, `created_at`, `updated_at`) VALUES (1, '超级管理员', '超级管理员', 1, b'0', 1, '2025-04-23 13:06:29', '2025-04-23 13:06:29');
INSERT INTO `system_role` (`id`, `role_name`, `role_remark`, `status`, `ok_del`, `version`, `created_at`, `updated_at`) VALUES (2, 'aaa', 'bbb', 1, b'0', 1, '2025-04-23 13:07:48', '2025-04-25 10:01:07');
COMMIT;

-- ----------------------------
-- Table structure for system_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `system_role_permissions`;
CREATE TABLE `system_role_permissions` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `permission_id` bigint(20) NOT NULL COMMENT '权限表sysno',
  `role_id` bigint(20) NOT NULL COMMENT '角色表sysno',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统-角色与权限多对多关系表';

-- ----------------------------
-- Records of system_role_permissions
-- ----------------------------
BEGIN;
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (3, 3, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (4, 4, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (5, 5, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (6, 6, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (7, 7, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (8, 8, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (9, 9, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (10, 10, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (11, 11, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (12, 12, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (13, 13, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (14, 14, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (15, 15, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (16, 16, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (17, 17, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (18, 18, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (19, 19, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (20, 20, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (21, 21, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (22, 22, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (23, 23, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (24, 24, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (25, 25, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (26, 26, 1);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (66, 13, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (67, 14, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (68, 15, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (69, 16, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (70, 17, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (71, 21, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (72, 22, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (73, 23, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (74, 24, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (75, 25, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (76, 5, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (77, 7, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (78, 3, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (79, 8, 2);
INSERT INTO `system_role_permissions` (`id`, `permission_id`, `role_id`) VALUES (80, 26, 2);
COMMIT;

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `login_account` varchar(20) NOT NULL COMMENT '登录帐号',
  `login_password` varchar(60) NOT NULL COMMENT '登录密码',
  `user_name` varchar(20) NOT NULL COMMENT '用户姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `contact_tel` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：1正常2停用',
  `ok_del` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除：1是0否',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本号',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统-用户表';

-- ----------------------------
-- Records of system_user
-- ----------------------------
BEGIN;
INSERT INTO `system_user` (`id`, `login_account`, `login_password`, `user_name`, `email`, `contact_tel`, `status`, `ok_del`, `version`, `created_at`, `updated_at`) VALUES (1, 'admin', '23f4bf66eae13a0bebbe58ef7b5551a3', '超级管理员', 'admin@gmail.com', '18888888888', 1, b'0', 1, '2018-12-21 08:00:02', '2018-08-01 15:52:10');
INSERT INTO `system_user` (`id`, `login_account`, `login_password`, `user_name`, `email`, `contact_tel`, `status`, `ok_del`, `version`, `created_at`, `updated_at`) VALUES (2, 'peter', '23f4bf66eae13a0bebbe58ef7b5551a3', '小伍', 'bb', 'aa', 1, b'0', 1, '2022-07-04 21:17:33', '2025-04-27 11:33:28');
COMMIT;

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户表sysno',
  `role_id` bigint(20) NOT NULL COMMENT '角色表sysno',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统用户角色表';

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
BEGIN;
INSERT INTO `system_user_role` (`id`, `user_id`, `role_id`) VALUES (3, 1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
