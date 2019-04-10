/*
 Navicat Premium Data Transfer

 Source Server         : cpms
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : cpms

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 10/04/2019 16:25:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for building_info
-- ----------------------------
DROP TABLE IF EXISTS `building_info`;
CREATE TABLE `building_info`  (
  `building_id` int(11) NOT NULL COMMENT '楼宇ID',
  `building_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '楼宇名称',
  `building_level` double(255, 0) NULL DEFAULT NULL COMMENT '楼宇层数',
  `building_height` double NULL DEFAULT NULL COMMENT '楼宇高度',
  `building_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '楼宇类型',
  `building_status` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '楼宇状态',
  PRIMARY KEY (`building_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of building_info
-- ----------------------------
INSERT INTO `building_info` VALUES (1, '天河A1', 6, 16.8, 'commercial', 'using');
INSERT INTO `building_info` VALUES (2, 'jludormitory1', 6, 16.8, 'residential', 'using');
INSERT INTO `building_info` VALUES (3, '天河A2', 6, 16.8, 'commercial', 'constructing');
INSERT INTO `building_info` VALUES (4, 'jludomitory2', 6, 16.8, 'residential', 'constructing');
INSERT INTO `building_info` VALUES (5, 'jludomitory3', 6, 16.8, 'residential', 'using');

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info`  (
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES (1, 'showUserMessage');
INSERT INTO `menu_info` VALUES (2, 'ownerMessageManage');
INSERT INTO `menu_info` VALUES (3, 'buildingMessageManage');
INSERT INTO `menu_info` VALUES (4, 'roomMessageManage');
INSERT INTO `menu_info` VALUES (5, 'userMessageManage');
INSERT INTO `menu_info` VALUES (6, 'systemManage');

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, 'admin');
INSERT INTO `role_info` VALUES (2, 'manager');
INSERT INTO `role_info` VALUES (3, 'owner');

-- ----------------------------
-- Table structure for role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_relation`;
CREATE TABLE `role_menu_relation`  (
  `role_menu_id` int(11) NOT NULL COMMENT '角色菜单唯一标识',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_menu_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `menu_id`(`menu_id`) USING BTREE,
  CONSTRAINT `role_menu_relation_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_menu_relation_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu_info` (`menu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu_relation
-- ----------------------------
INSERT INTO `role_menu_relation` VALUES (1, 1, 1);
INSERT INTO `role_menu_relation` VALUES (2, 1, 2);
INSERT INTO `role_menu_relation` VALUES (3, 1, 3);
INSERT INTO `role_menu_relation` VALUES (4, 1, 4);
INSERT INTO `role_menu_relation` VALUES (5, 1, 5);
INSERT INTO `role_menu_relation` VALUES (6, 1, 6);
INSERT INTO `role_menu_relation` VALUES (7, 2, 1);
INSERT INTO `role_menu_relation` VALUES (8, 2, 2);
INSERT INTO `role_menu_relation` VALUES (9, 2, 3);
INSERT INTO `role_menu_relation` VALUES (10, 2, 4);
INSERT INTO `role_menu_relation` VALUES (11, 3, 1);

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `room_id` int(11) NOT NULL COMMENT '房屋ID',
  `building_id` int(255) NOT NULL COMMENT '房屋所在楼宇ID',
  `area` double(255, 0) NULL DEFAULT NULL COMMENT '房屋面积',
  `owner_id` int(11) NULL DEFAULT NULL COMMENT '业主ID',
  PRIMARY KEY (`room_id`, `building_id`) USING BTREE,
  INDEX `building_id`(`building_id`) USING BTREE,
  INDEX `owner_id`(`owner_id`) USING BTREE,
  CONSTRAINT `building_id` FOREIGN KEY (`building_id`) REFERENCES `building_info` (`building_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `room_info_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `user_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES (201, 1, 100, 4);
INSERT INTO `room_info` VALUES (201, 2, 100, 5);
INSERT INTO `room_info` VALUES (301, 1, 100, 6);
INSERT INTO `room_info` VALUES (301, 2, 100, 7);
INSERT INTO `room_info` VALUES (401, 1, 100, NULL);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户账号',
  `user_idnumber` bigint(50) NOT NULL COMMENT '用户身份证号',
  `user_phonenumber` bigint(11) NULL DEFAULT NULL COMMENT '用户电话号码',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'kim', 'q', 'q', 293049199605292288, 18812341234);
INSERT INTO `user_info` VALUES (2, 'jim', 'w', 'w', 234234199508244219, NULL);
INSERT INTO `user_info` VALUES (3, 'william', 'e', 'e', 201234199811222610, NULL);
INSERT INTO `user_info` VALUES (4, 'zhangjie1', 'a', 'a', 12312319970920221, NULL);
INSERT INTO `user_info` VALUES (5, 'zhangjie2', 'b', 'b', 234234199709232224, NULL);
INSERT INTO `user_info` VALUES (6, 'zhangjie3', 'c', 'c', 345345199709202233, NULL);
INSERT INTO `user_info` VALUES (7, 'zhangjie5', 'd', 'd', 567567199709201135, NULL);

-- ----------------------------
-- Table structure for user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation`  (
  `user_role_id` int(11) NOT NULL COMMENT '用户-角色唯一标识ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_role_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_relation_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_relation
-- ----------------------------
INSERT INTO `user_role_relation` VALUES (1, 1, 1);
INSERT INTO `user_role_relation` VALUES (2, 2, 2);
INSERT INTO `user_role_relation` VALUES (3, 3, 3);
INSERT INTO `user_role_relation` VALUES (4, 4, 3);
INSERT INTO `user_role_relation` VALUES (5, 5, 3);
INSERT INTO `user_role_relation` VALUES (6, 6, 3);
INSERT INTO `user_role_relation` VALUES (7, 7, 3);

SET FOREIGN_KEY_CHECKS = 1;
