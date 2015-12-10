/*
MySQL Data Transfer
Source Host: localhost
Source Database: sxt_manager
Target Host: localhost
Target Database: sxt_manager
Date: 2012-8-23 10:48:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for employee
-- ----------------------------
CREATE TABLE `employee` (
  `id` int(10) NOT NULL auto_increment,
  `ename` varchar(50) default NULL,
  `sex` varchar(10) default NULL,
  `birthday` varchar(50) default NULL,
  `cardid` varchar(50) default NULL,
  `address` varchar(100) default NULL,
  `orgid` int(10) default NULL,
  `jobids` varchar(50) default NULL,
  `basesalary` int(50) default NULL,
  `phonecomm` int(50) default NULL,
  `buscomm` int(50) default NULL,
  `baoxiancomm` int(50) default NULL,
  `ruzhitime` varchar(50) default NULL,
  `cizhitime` varchar(50) default NULL,
  `lizhitime` varchar(50) default NULL,
  `cizhireason` varchar(200) default NULL,
  `state` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for employeejob
-- ----------------------------
CREATE TABLE `employeejob` (
  `id` int(10) NOT NULL auto_increment,
  `empid` int(10) default NULL,
  `jobid` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for job
-- ----------------------------
CREATE TABLE `job` (
  `id` int(10) NOT NULL auto_increment,
  `jname` varchar(50) default NULL,
  `pid` int(10) default NULL,
  `descript` varchar(100) default NULL,
  `leaf` int(10) default NULL,
  `orgid` int(10) default NULL,
  `employeeids` varchar(1000) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for message
-- ----------------------------
CREATE TABLE `message` (
  `id` int(10) NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `content` text,
  `createTime` varchar(50) default NULL,
  `sendTime` varchar(50) default NULL,
  `senderId` int(10) default NULL,
  `sendboxState` varchar(10) default NULL,
  `UUID` varchar(200) default NULL,
  `realDelete` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for messagereceiver
-- ----------------------------
CREATE TABLE `messagereceiver` (
  `id` int(10) NOT NULL auto_increment,
  `messageId` int(10) default NULL,
  `receiverId` int(10) default NULL,
  `readState` varchar(50) default NULL,
  `receiverboxState` varchar(50) default NULL,
  `realDelete` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for org
-- ----------------------------
CREATE TABLE `org` (
  `id` int(10) NOT NULL auto_increment,
  `oname` varchar(50) default NULL,
  `pid` int(10) default NULL,
  `descript` varchar(200) default NULL,
  `leaf` int(10) default NULL,
  `principal` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
CREATE TABLE `student` (
  `id` int(10) NOT NULL auto_increment,
  `sname` varchar(50) default NULL,
  `qq` varchar(50) default NULL,
  `phone` varchar(50) default NULL,
  `university` varchar(50) default NULL,
  `department` varchar(50) default NULL,
  `grade` varchar(50) default NULL,
  `xueli` varchar(50) default NULL,
  `zaidu` varchar(50) default NULL,
  `wantPeixunTime` varchar(50) default NULL,
  `xuefeiType` varchar(50) default NULL,
  `howKnow` varchar(50) default NULL,
  `banjiType` varchar(50) default NULL,
  `descrpt` varchar(500) default NULL,
  `dengjiUserId` int(10) default NULL,
  `type` varchar(50) default NULL,
  `bulaiReason` varchar(500) default NULL,
  `banjiid` int(10) default NULL,
  `yingjiaoxuefei` double(20,0) default NULL,
  `updatexuefeireason` varchar(50) default NULL,
  `yingtuixuefei` double(20,0) default NULL,
  `shituixuefei` double(20,0) default NULL,
  `tuixuereason` varchar(500) default NULL,
  `zhusuflag` varchar(50) default NULL,
  `yingzhusufei` double(20,0) default NULL,
  `shizhusufei` double(20,0) default NULL,
  `yingtuizhusufei` double(20,0) default NULL,
  `shituizhusufei` double(20,0) default NULL,
  `tuizhusureason` varchar(500) default NULL,
  `diannaoflag` varchar(50) default NULL,
  `yingdiannaoyajin` double(20,0) default NULL,
  `shidiannaoyajin` double(20,0) default NULL,
  `yingtuidiannaoyajin` double(20,0) default NULL,
  `shituidiannaoyajin` double(20,0) default NULL,
  `stucardflag` int(10) default NULL,
  `dbrcardflag` int(10) default NULL,
  `dbrhukouflag` int(10) default NULL,
  `dbrbankflag` int(10) default NULL,
  `photoflag` int(10) default NULL,
  `peixunflag` int(10) default NULL,
  `dbrdanbaoflag` int(10) default NULL,
  `shixiflag` int(10) default NULL,
  `xjyflag` int(10) default NULL,
  `huankuanflag` int(10) default NULL,
  `toplapflag` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `id` int(10) NOT NULL auto_increment,
  `uname` varchar(50) default NULL,
  `pwd` varchar(50) default NULL,
  `empid` int(10) default NULL,
  `state` varchar(10) default NULL,
  `createTime` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `employee` VALUES ('2', '张6666', '1', '2012-8-8', '220104198611113324', '天津', '6', null, '100000', '2342', '4243', '2342', '2012-8-29', null, null, null, '在职');
INSERT INTO `employee` VALUES ('10', '王1', '1', '2012-8-8', '220104197911114123', '北京', '6', null, '300000', '5000', '5000', '4000', '2001-6-26', '2012-8-1', '2012-8-14', '离职!!', '离职');
INSERT INTO `employee` VALUES ('12', '小王', '1', '2012-8-8', '220102198612113001', '北京', '4', '', '100000', '100', '100', '100', '2007-7-24', null, null, null, '在职');
INSERT INTO `employee` VALUES ('13', '小李', '1', '2012-8-8', '220102198612113333', '上海', '13', '', '100000', '100', '100', '100', '2002-8-13', null, null, null, '在职');
INSERT INTO `employee` VALUES ('14', '孙一', '1', '2012-8-2', '220102191212121', '北京', '18', '15', '100000', '100', '100', '100', '2008-8-13', null, null, null, '在职');
INSERT INTO `employee` VALUES ('16', '赵3', '1', '2012-8-14', '220102144433301', '北京', '17', '12,19', '100000', '100', '100', '100', '2012-8-8', null, null, null, '在职');
INSERT INTO `employee` VALUES ('19', '天天', '1', '2012-8-2', '220102144400888', '上海', '5', null, '100000', '100', '100', '100', '2012-8-10', '2012-8-21', '2012-8-21', '辞职..', '离职');
INSERT INTO `employeejob` VALUES ('78', '14', '15');
INSERT INTO `employeejob` VALUES ('82', '16', '12');
INSERT INTO `employeejob` VALUES ('83', '16', '19');
INSERT INTO `job` VALUES ('1', '总经理', '999999', '大牛职位啊.', '0', '1', '');
INSERT INTO `job` VALUES ('2', '北京总经理', '1', '中牛职位啊.', '0', '2', '');
INSERT INTO `job` VALUES ('12', '项目经理', '2', '我是项目经理啊', '0', '17', '16');
INSERT INTO `job` VALUES ('14', '教务主任', '2', '啊啊啊', '0', '18', '');
INSERT INTO `job` VALUES ('15', '教务老师', '14', '我是班主任', '1', '18', '14');
INSERT INTO `job` VALUES ('16', '教学主任', '2', '授课老师', '0', '19', '');
INSERT INTO `job` VALUES ('17', '讲师', '16', '授课老师', '1', '19', '');
INSERT INTO `job` VALUES ('19', '苦逼程序员', '12', '码农..', '1', '17', '16');
INSERT INTO `org` VALUES ('1', '总公司', '999999', '我是总公司,谢谢', '0', '老高');
INSERT INTO `org` VALUES ('2', '北京分公司', '1', '我是分公司1', '0', '老李');
INSERT INTO `org` VALUES ('3', '长沙分公司', '1', '我是分公司2', '0', '老王');
INSERT INTO `org` VALUES ('4', '总公司研发部门', '1', '我是研发部！', '1', '老张');
INSERT INTO `org` VALUES ('5', '北京财务部门', '2', '财务部门啊', '1', '老刘');
INSERT INTO `org` VALUES ('6', '北京产品部门', '2', '分1部门2', '1', '老裴');
INSERT INTO `org` VALUES ('13', '总公司财务部门', '1', '我是总公司财务负责人', '1', '小T');
INSERT INTO `org` VALUES ('16', '长沙研发部门', '3', '研发部..', '1', '小Y');
INSERT INTO `org` VALUES ('17', '北京研发部门', '2', '啊啊啊', '1', '_oiYc');
INSERT INTO `org` VALUES ('18', '北京教务部门', '2', 'AAA', '1', '小X');
INSERT INTO `org` VALUES ('19', '北京教学部门', '2', 'AA111', '1', '小L');
INSERT INTO `user` VALUES ('2', '赵3201283', '114022', '16', '有效', '2012-08-14');
INSERT INTO `user` VALUES ('4', '张6666201288', '113324', '2', '有效', '2012-08-14');
INSERT INTO `user` VALUES ('8', '小王201288', '113001', '12', '有效', '2012-08-17');
INSERT INTO `user` VALUES ('9', '小李201288', '113333', '13', '有效', '2012-08-17');
INSERT INTO `user` VALUES ('10', '孙一201282', '212121', '14', '有效', '2012-08-21');
