/*
Navicat MySQL Data Transfer

Source Server         : allen
Source Server Version : 50644
Source Host           : 192.168.3.34:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-12-12 20:48:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2019-12-09 16:14:50', '1203951123950489601', 'Archer', '18', 'test6@baomidou.com');
INSERT INTO `user` VALUES ('2019-12-09 16:20:58', '1203952663415259138', 'Archie', '23', 'test1@baomidou.com');
INSERT INTO `user` VALUES ('2019-12-09 16:24:12', '1203953478754381826', 'Allen', '26', 'test2@baomidou.com');
INSERT INTO `user` VALUES ('2019-12-09 16:24:35', '1203953577425391617', 'Alice', '24', 'test2@baomidou.com');
INSERT INTO `user` VALUES ('2019-12-09 16:27:03', '1203954194470469634', 'Mike', '42', 'test3@baomidou.com');
INSERT INTO `user` VALUES ('2019-12-09 16:27:51', '1203954398418563073', 'Drapho', '44', 'test4@baomidou.com');
INSERT INTO `user` VALUES ('2019-12-09 16:29:25', '1203954790606950401', 'Alikser', '18', 'test5@baomidou.com');
INSERT INTO `user` VALUES ('2019-12-09 16:28:50', '1203957370250608641', 'Ferniser', '27', 'test7@baomidou.com');
INSERT INTO `user` VALUES ('2019-12-09 16:28:58', '1203957552497344513', 'Kakalote', '25', 'test8@baomidou.com');
INSERT INTO `user` VALUES ('2019-12-12 19:34:15', '1205088468527603714', 'Kakalote', '25', 'test5@baomidou.com');
