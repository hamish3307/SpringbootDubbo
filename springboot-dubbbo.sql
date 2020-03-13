/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 127.0.0.1:3306
 Source Schema         : springboot-dubbbo

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 13/03/2020 17:46:58
*/

-- ----------------------------
-- Database for user
-- ----------------------------
/*
DROP DATABASE IF EXISTS `springboot-dubbbo`;
CREATE DATABASE `springboot-dubbbo`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
*/


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '卫庄', 29, '男', '123456789');
INSERT INTO `user` VALUES (2, '莉丝', 27, '女', '15026484660');
INSERT INTO `user` VALUES (3, '盖聂', 30, '男', '15679420900');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
