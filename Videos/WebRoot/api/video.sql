/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : video

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2017-02-18 14:13:29
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for v_classes
-- ----------------------------
DROP TABLE IF EXISTS `v_classes`;
CREATE TABLE `v_classes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `name` varchar(255) NOT NULL COMMENT '课程名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_classes
-- ----------------------------
INSERT INTO `v_classes` VALUES (null, '课程名字');


-- ----------------------------
-- Table structure for v_teacher
-- ----------------------------
DROP TABLE IF EXISTS `v_teacher`;
CREATE TABLE `v_teacher` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '教师编号',
  `name` varchar(255) NOT NULL COMMENT '教师名字',
  `avatar` varchar(255) NOT NULL COMMENT '教师头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_teacher
-- ----------------------------
INSERT INTO `v_teacher` VALUES ('1', '张三', '头像');


-- ----------------------------
-- Table structure for v_chapter
-- ----------------------------
DROP TABLE IF EXISTS `v_chapter`;
CREATE TABLE `v_chapter` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '章次编号',
  `cl_id` int(11) NOT NULL COMMENT '课程编号',
  `name` varchar(255) NOT NULL COMMENT '课程名称',
  `abstract` varchar(255) NOT NULL COMMENT '章次介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_chapter
-- ----------------------------
INSERT INTO `v_chapter` VALUES (null, '课程编号', '课程名称', '章次介绍');


-- ----------------------------
-- Table structure for v_section
-- ----------------------------
DROP TABLE IF EXISTS `v_section`;
CREATE TABLE `v_section` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `ch_id` int(10) unsigned NOT NULL COMMENT '章次编号',
  `image` varchar(255) NOT NULL COMMENT '缩略图',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `hits` int(11) NOT NULL COMMENT '点播次数',
  `seconds` int(11) NOT NULL COMMENT '时长',
  `te_id` int(10) unsigned NOT NULL COMMENT '教师编号',
  `url` varchar(255) NOT NULL COMMENT '视频地址',
  `abstract` varchar(255) NOT NULL COMMENT '视频简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_section
-- ----------------------------
INSERT INTO `v_section` VALUES ('1', '1', 'html1-1', 'html1-1', '199', '3600', '1', 'html1-1', 'html1-1');


