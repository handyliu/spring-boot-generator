/*
Navicat MySQL Data Transfer

Source Server         : 192.168.2.150
Source Server Version : 50711
Source Host           : 192.168.2.150:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-02-02 14:03:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(255) NOT NULL DEFAULT '' COMMENT '账户密码',
  `nick_name` varchar(255) DEFAULT '' COMMENT '昵称',
  `sex` int(1) DEFAULT '1' COMMENT '0.女 1.男',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

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
