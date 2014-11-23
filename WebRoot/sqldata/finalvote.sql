/*
Navicat MySQL Data Transfer

Source Server         : blog.iamsee.com
Source Server Version : 50173
Source Host           : blog.iamsee.com:3306
Source Database       : finalvote

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2014-11-22 05:38:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', 'root', 'root');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `pwd` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '123', 'aaa');
INSERT INTO `tb_user` VALUES ('2', '123', '123');
INSERT INTO `tb_user` VALUES ('3', '123', 'aaa');
INSERT INTO `tb_user` VALUES ('4', '123', 'aaa');
INSERT INTO `tb_user` VALUES ('5', '123', 'aaa');
INSERT INTO `tb_user` VALUES ('8', '123', '123');
INSERT INTO `tb_user` VALUES ('10', '333', '333');
INSERT INTO `tb_user` VALUES ('11', '222', '222');
INSERT INTO `tb_user` VALUES ('12', '333', '333');
INSERT INTO `tb_user` VALUES ('13', '333', '333');
INSERT INTO `tb_user` VALUES ('1013', '321', '321');
INSERT INTO `tb_user` VALUES ('1014', '3214', '3124');
INSERT INTO `tb_user` VALUES ('1015', '421r423', '213421');
INSERT INTO `tb_user` VALUES ('1016', '421312', '4213');
INSERT INTO `tb_user` VALUES ('1017', '', '');
INSERT INTO `tb_user` VALUES ('1018', '', '');
INSERT INTO `tb_user` VALUES ('1019', '123', '123');
INSERT INTO `tb_user` VALUES ('1020', '232', '232');
INSERT INTO `tb_user` VALUES ('6', '123', 'aaa');
INSERT INTO `tb_user` VALUES ('7', '123', 'aaa');
INSERT INTO `tb_user` VALUES ('9', '123', '123');
INSERT INTO `tb_user` VALUES ('1021', 'iamsee', 'iamsee');
INSERT INTO `tb_user` VALUES ('1022', 'e21421', '3214');
INSERT INTO `tb_user` VALUES ('1023', '', '');
INSERT INTO `tb_user` VALUES ('1024', '', '');
INSERT INTO `tb_user` VALUES ('1025', '123321', '123321');
INSERT INTO `tb_user` VALUES ('1026', '3434343', '343434');

-- ----------------------------
-- Table structure for tb_vote
-- ----------------------------
DROP TABLE IF EXISTS `tb_vote`;
CREATE TABLE `tb_vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beselected` varchar(50) NOT NULL,
  `votenum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_vote
-- ----------------------------
INSERT INTO `tb_vote` VALUES ('1', '张三', '5707');
INSERT INTO `tb_vote` VALUES ('2', '李四', '2805');
INSERT INTO `tb_vote` VALUES ('3', '王五', '4000');
INSERT INTO `tb_vote` VALUES ('4', '周六', '10466');
INSERT INTO `tb_vote` VALUES ('5', '李琦', '7005');
INSERT INTO `tb_vote` VALUES ('6', '赵吧', '3871');
INSERT INTO `tb_vote` VALUES ('7', 'aa', '0');
INSERT INTO `tb_vote` VALUES ('8', 'cc', '0');
INSERT INTO `tb_vote` VALUES ('9', 'dd', '0');
INSERT INTO `tb_vote` VALUES ('10', 'bb', '1');
INSERT INTO `tb_vote` VALUES ('11', 'ee', '0');
