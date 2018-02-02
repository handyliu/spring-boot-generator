/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-02-02 14:25:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `register_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1023544696@qq.com', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙', '1', '2018-02-02 10:57:29');
INSERT INTO `user` VALUES ('2', '18305113589', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙-2', '1', '2018-02-02 10:57:29');
INSERT INTO `user` VALUES ('3', '3@qq.com', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙-3', '1', '2018-02-02 10:57:29');
INSERT INTO `user` VALUES ('4', '4@qq.com', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙-4', '1', '2018-02-02 10:57:29');
INSERT INTO `user` VALUES ('5', '5@qq.com', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙-5', '1', '2018-02-02 10:57:29');
INSERT INTO `user` VALUES ('6', '6@qq.com', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙-6', '1', '2018-02-02 10:57:29');
INSERT INTO `user` VALUES ('7', '7@qq.com', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙-7', '1', '2018-02-02 10:57:29');
INSERT INTO `user` VALUES ('8', '8@qq.com', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙-8', '1', '2018-02-02 10:57:29');
INSERT INTO `user` VALUES ('9', '9@qq.com', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙-9', '1', '2018-02-02 10:57:29');
INSERT INTO `user` VALUES ('10', '10@qq.com', 'F8E3380591F005652E85CB7F5D84B17C', '徐新龙-10', '1', '2018-02-02 10:57:29');
SET FOREIGN_KEY_CHECKS=1;
