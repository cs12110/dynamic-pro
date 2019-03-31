/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 127.0.0.1:3306
 Source Schema         : 4fun_db

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 31/03/2019 16:30:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_t
-- ----------------------------
DROP TABLE IF EXISTS `my_t`;
CREATE TABLE `my_t` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `code` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_t
-- ----------------------------
BEGIN;
INSERT INTO `my_t` VALUES (1, 'haiyan', 'haiyan');
INSERT INTO `my_t` VALUES (2, '3306', '3306');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
