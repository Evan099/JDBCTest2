/*
 Navicat Premium Data Transfer

 Source Server         : hello
 Source Server Type    : MySQL
 Source Server Version : 50096
 Source Host           : localhost:3306
 Source Schema         : jdbctest

 Target Server Type    : MySQL
 Target Server Version : 50096
 File Encoding         : 65001

 Date: 26/06/2019 17:46:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`uid`)
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 'lijinxia', '123', '???');
INSERT INTO `user` VALUES (3, 'lisuai', '123', '??');
INSERT INTO `user` VALUES (4, 'zhagnsan', '97988', 'zs');
INSERT INTO `user` VALUES (12, 'zhagnsan', '97988', 'zs');

SET FOREIGN_KEY_CHECKS = 1;
