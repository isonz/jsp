/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-08-05 10:55:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jsp_message
-- ----------------------------
DROP TABLE IF EXISTS `jsp_message`;
CREATE TABLE `jsp_message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `msg` text,
  `create_at` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jsp_message
-- ----------------------------
INSERT INTO `jsp_message` VALUES ('1', '张珅', '恭喜恭喜恭喜恭喜', '1470277423');
INSERT INTO `jsp_message` VALUES ('14', '杭州起码科技有限公司', '\'as=\'asdf or and \'asd=asdf', '1470294119');
INSERT INTO `jsp_message` VALUES ('19', '杭州起码科技有限公司杭州起码科技有限公司', '<%\r\nMessageDo msgd = new MessageDo();\r\nArrayList<Message> msglist = msgd.msgList();\r\nMessage msg = new Message();\r\nFunc func = new Func();\r\nint k=1;\r\nfor(int i=0; i<msglist.size(); i++){\r\n	msg = msglist.get(i);\r\n\r\n\r\nif(k>1){\r\n	k=1;\r\n}else{\r\n	k++;\r\n}\r\n\r\n}\r\n%>\r\n\r\n\'adfas\'dfas\'df\'asd\'fa\'sdf\'a\'sd\'fa\'sdfasDF\"ASD\"FASD\"fAS\"DF\'aS\r\nd\'fSA\"D\"fAS\'dF\'SAD\"f', '1470297049');
INSERT INTO `jsp_message` VALUES ('20', '杭州起码科技有限公司', 'asdfsadfffffffffffffffff', '1470363073');
