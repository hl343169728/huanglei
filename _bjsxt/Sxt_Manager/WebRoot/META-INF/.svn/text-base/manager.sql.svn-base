/*
MySQL Data Transfer
Source Host: localhost
Source Database: manager
Target Host: localhost
Target Database: manager
Date: 2012-10-25 17:55:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for employee
-- ----------------------------
CREATE TABLE `employee` (
  `id` int(10) NOT NULL auto_increment,
  `ename` varchar(30) default NULL,
  `sex` varchar(20) default NULL,
  `birthday` varchar(20) default NULL,
  `cardId` varchar(50) default NULL,
  `address` varchar(100) default NULL,
  `orgId` int(50) default NULL,
  `jobIds` varchar(100) default NULL,
  `baseSalary` int(50) default NULL,
  `phoneComm` int(50) default NULL,
  `busComm` int(50) default NULL,
  `baoxianComm` int(50) default NULL,
  `ruzhiTime` varchar(100) default NULL,
  `cizhiTime` varchar(100) default NULL,
  `lizhiTime` varchar(100) default NULL,
  `cizhiReason` varchar(1000) default NULL,
  `state` varchar(50) default NULL,
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
-- Table structure for grade
-- ----------------------------
CREATE TABLE `grade` (
  `id` int(50) NOT NULL auto_increment,
  `classnumber` varchar(50) default NULL,
  `starttime` varchar(50) default NULL,
  `endtime` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  `totalfee` double(50,0) default NULL,
  `payfee` double(50,0) default NULL,
  `prepayfee` double(50,0) default NULL,
  `teacherid` int(50) default NULL,
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
-- Table structure for memo
-- ----------------------------
CREATE TABLE `memo` (
  `id` int(10) NOT NULL auto_increment,
  `content` varchar(1000) default NULL,
  `startTime` varchar(50) default NULL,
  `endTime` varchar(50) default NULL,
  `state` varchar(20) default NULL,
  `userId` int(10) default NULL,
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
  `oname` varchar(20) default NULL,
  `pid` int(10) default NULL,
  `descript` varchar(100) default NULL,
  `leaf` int(10) default NULL,
  `principal` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shouru
-- ----------------------------
CREATE TABLE `shouru` (
  `id` int(10) NOT NULL auto_increment,
  `jine` double(20,0) default NULL,
  `shouruTime` varchar(20) default NULL,
  `descrpt` varchar(1000) default NULL,
  `userId` int(10) default NULL,
  `studentId` int(10) default NULL,
  `shenheState` varchar(50) default NULL,
  `shenheId` int(10) default NULL,
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
  `diploma` varchar(50) default NULL,
  `state` varchar(50) default NULL,
  `pretraindate` varchar(50) default NULL,
  `paytype` varchar(50) default NULL,
  `howKnow` varchar(50) default NULL,
  `classtype` varchar(50) default NULL,
  `description` varchar(500) default NULL,
  `userid` int(10) default NULL,
  `type` varchar(50) default NULL,
  `nonarrivalReason` varchar(500) default NULL,
  `gradeid` int(10) default NULL,
  `fee` double(20,0) default NULL,
  `feeupdatereason` varchar(50) default NULL,
  `feequit` double(20,0) default NULL,
  `feerealquit` double(20,0) default NULL,
  `leavereason` varchar(500) default NULL,
  `liveflag` varchar(50) default NULL,
  `handlivefee` double(20,0) default NULL,
  `reallivefee` double(20,0) default NULL,
  `quitlivefee` double(20,0) default NULL,
  `realquitlivefee` double(20,0) default NULL,
  `quitlivereason` varchar(500) default NULL,
  `computerflag` varchar(50) default NULL,
  `computerpay` double(20,0) default NULL,
  `realcomputerpay` double(20,0) default NULL,
  `quitcomputerpay` double(20,0) default NULL,
  `realquitcomputerpay` double(20,0) default NULL,
  `stucardflag` int(10) default NULL,
  `bondsmancardflag` int(10) default NULL,
  `bondsmanhouseholdflag` int(10) default NULL,
  `bondsmanaccountflag` int(10) default NULL,
  `photoflag` int(10) default NULL,
  `trainflag` int(10) default NULL,
  `guaranteeflag` int(10) default NULL,
  `practiceflag` int(10) default NULL,
  `preworkflag` int(10) default NULL,
  `repaymentflag` int(10) default NULL,
  `laptopflag` int(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for temp
-- ----------------------------
CREATE TABLE `temp` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `age` int(10) default NULL,
  `sex` varchar(10) default NULL,
  `birthday` varchar(50) default NULL,
  `r_id` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE `user` (
  `id` int(20) NOT NULL auto_increment,
  `uname` varchar(20) default NULL,
  `pwd` varchar(30) default NULL,
  `empId` int(20) default NULL,
  `state` varchar(50) default NULL,
  `createTime` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zhichu
-- ----------------------------
CREATE TABLE `zhichu` (
  `id` int(10) NOT NULL auto_increment,
  `jine` double(20,0) default NULL,
  `type` varchar(100) default NULL,
  `descrpt` varchar(100) default NULL,
  `studentId` int(10) default NULL,
  `userId` int(10) default NULL,
  `baoxiaoId` int(10) default NULL,
  `zhichuTime` varchar(20) default NULL,
  `sn` varchar(50) default NULL,
  `shenheState` varchar(20) default NULL,
  `shenheId` int(10) default NULL,
  `descript` varchar(100) default NULL,
  `approveDescript` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '张三丰', '1', '2012-9-6', '342501198802180018', '北京市', '18', '9', '20000', '2000', '2000', '4000', '2012-9-13', null, null, null, '在职');
INSERT INTO `employee` VALUES ('2', '周芷若', '2', '2012-9-13', '342501198802180077', '峨眉山', '5', '9', '20000', '2000', '200', '5000', '2012-9-27', null, null, null, '在职');
INSERT INTO `employee` VALUES ('3', '张三', '1', '2012-9-29', '342501198802180080', '天津市', '5', null, '8000', '2000', '100', '1000', '2012-9-27', '2012-9-1', '2012-9-8', '你懂得...', '已辞职');
INSERT INTO `employee` VALUES ('4', '曹操', '1', '1999-9-6', '342501198844444444', '东汉', '4', '5', '15000', '0', '0', '0', '2012-9-29', null, null, null, '在职');
INSERT INTO `employee` VALUES ('5', '刘备', '1', '2012-9-17', '342501198844444449', '东汉', '5', null, '8000', '0', '0', '100', '2012-9-28', '2012-9-6', '2012-9-21', '阿萨斯', '已辞职');
INSERT INTO `employee` VALUES ('6', '孙权', '1', '2012-9-16', '342501198844444448', '东汉', '5', '4', '5555', '0', '3', '2', '2012-9-25', null, null, null, '在职');
INSERT INTO `employee` VALUES ('7', '甄宓', '2', '2012-9-1', '342501198802777777', '邯郸', '29', '9', '20000', '2000', '100', '5000', '2012-9-1', null, null, null, '在职');
INSERT INTO `employee` VALUES ('8', '孙尚香', '2', '2012-9-8', '342501198802180014', '东吴', '13', '2', '15000', '500', '100', '400', '2012-9-30', null, null, null, '在职');
INSERT INTO `employee` VALUES ('9', '小龙女', '2', '2011-9-1', '342501198802180033', '古墓', '5', null, '8008', '2000', '200', '5000', '2012-9-26', '2012-9-5', '2012-9-29', '太累了，我怕我老的太快！', '已辞职');
INSERT INTO `employee` VALUES ('10', '黄蓉', '2', '2010-9-7', '342501198802180032', '桃花岛', '5', '9', '13000', '3000', '200', '12', '2012-9-29', null, null, null, '在职');
INSERT INTO `employee` VALUES ('11', '郭靖', '1', '2011-9-10', '342501198802180777', '大漠', '16', '5', '15000', '100', '0', '400', '2012-9-19', null, null, null, '在职');
INSERT INTO `employee` VALUES ('12', '昊天', '1', '2009-9-14', '342501198800000000', '天庭', '5', null, '20000', '20000', '20000', '20000', '2012-9-29', '2012-9-26', '2012-9-29', '我不做傀儡了！', '已辞职');
INSERT INTO `employee` VALUES ('13', '杨戬', '1', '2008-9-18', '342501198802180099', '桃山', '5', null, '20000', '200', '100', '400', '2012-9-26', '2011-9-4', '2013-9-14', '爷现在是款爷！', '已辞职');
INSERT INTO `employee` VALUES ('14', '小童', '1', '2012-9-4', '342501198802180111', '地球', '5', null, '8000', '100', '100', '400', '2012-9-26', '2012-9-8', '2012-9-21', '你们太不人道了！', '已辞职');
INSERT INTO `employee` VALUES ('15', '张飞', '1', '2012-9-12', '342501198802180070', '涿郡', '5', '3', '10000', '2000', '100', '400', '2012-9-28', null, null, null, '在职');
INSERT INTO `employee` VALUES ('16', '蒋介石', '1', '2012-9-21', '342501198802180000', '民国', '17', '9', '20000', '2000', '20000', '500', '2012-9-28', '2012-10-10', '2012-10-22', '不想做了！', '辞职');
INSERT INTO `employee` VALUES ('17', '景甜', '2', '2011-9-22', '342501198802180040', '中国', '5', '9', '8000', '20000', '20000', '5000', '2012-9-30', null, null, null, '在职');
INSERT INTO `employee` VALUES ('18', '乔峰', '1', '2009-9-13', '342501198802180010', '丐帮', '16', '9', '1', '1', '1', '1', '2012-9-29', null, null, null, '在职');
INSERT INTO `employee` VALUES ('19', '白痴', '1', '2012-9-7', '342501198802180930', '北京市', '5', '9', '10000', '2000', '21', '400', '2012-9-29', null, null, null, '在职');
INSERT INTO `employee` VALUES ('20', '盗贼', '2', '2012-9-7', '342501198802180021', '神偷门', '4', '9', '10000', '100', '200', '5000', '2012-9-28', null, null, null, '在职');
INSERT INTO `employee` VALUES ('21', '小狗', '1', '2012-9-4', '342501198802180545', '狗窝', '5', '4', '2121', '0', '0', '0', '2012-9-29', null, null, null, '在职');
INSERT INTO `employee` VALUES ('22', '貂蝉', '2', '2011-9-5', '342501198802180022', '吴国', '6', '9,5', '8888', '2000', '20000', '5000', '2012-9-29', null, null, null, '在职');
INSERT INTO `employee` VALUES ('23', '克拉斯', '1', '2012-9-5', '342501198802180020', '汴梁', '13', '5', '6000', '4000', '3000', '2000', '2012-10-31', null, null, null, '在职');
INSERT INTO `employee` VALUES ('24', '蚩尤', '1', '2012-9-4', '444444444444444444', '黎族', '29', '9', '10000', '2000', '20000', '5000', '2012-9-29', null, null, null, '在职');
INSERT INTO `employee` VALUES ('25', '刑天', '1', '2012-9-5', '342501198805454543', '黎族', '37', '9', '8000', '100', '100', '400', '2012-9-27', null, null, null, '在职');
INSERT INTO `employee` VALUES ('26', '黄蓉小妹妹', '2', '2012-10-3', '342501198802180034', '桃花岛', '16', '9', '10000', '2000', '100', '500', '2012-10-27', null, null, null, '在职');
INSERT INTO `employeejob` VALUES ('1', '11', '5');
INSERT INTO `employeejob` VALUES ('2', '15', '3');
INSERT INTO `employeejob` VALUES ('3', '16', '9');
INSERT INTO `employeejob` VALUES ('4', '17', '9');
INSERT INTO `employeejob` VALUES ('5', '18', '9');
INSERT INTO `employeejob` VALUES ('6', '19', '9');
INSERT INTO `employeejob` VALUES ('7', '20', '9');
INSERT INTO `employeejob` VALUES ('8', '21', '4');
INSERT INTO `employeejob` VALUES ('9', '22', '9');
INSERT INTO `employeejob` VALUES ('10', '22', '5');
INSERT INTO `employeejob` VALUES ('11', '23', '5');
INSERT INTO `employeejob` VALUES ('12', '24', '9');
INSERT INTO `employeejob` VALUES ('14', '25', '9');
INSERT INTO `employeejob` VALUES ('15', '26', '9');
INSERT INTO `grade` VALUES ('1', 'bj-jyl-t-2012', '2012-10-9', '2012-10-10', '业余班', '12000', '10000', '500', '5');
INSERT INTO `grade` VALUES ('2', 'bj-jyl-t-2011', '2012-10-16', '2012-10-19', '远程同步班', '12000', '10000', '500', '2');
INSERT INTO `grade` VALUES ('3', 'bj-jyl-t-2010', '2012-10-19', '2012-10-27', '远程同步班', '12000', '10000', '500', '16');
INSERT INTO `grade` VALUES ('6', 'bj-jyl-t-2009', '2012-11-29', '2012-12-28', '脱产班', '12000', '10000', '500', '6');
INSERT INTO `grade` VALUES ('7', 'bj-jyl-t-2008', '2012-11-29', '2012-12-28', '基地班', '12000', '10000', '500', '3');
INSERT INTO `grade` VALUES ('8', 'bj-jyl-t-2007', '2012-11-29', '2012-12-28', '业余班', '12000', '10000', '500', '7');
INSERT INTO `grade` VALUES ('10', 'bj-jyl-t-2006', '2012-11-29', '2012-10-27', '基地班', '12000', '8888', '500', '10');
INSERT INTO `grade` VALUES ('11', 'bj-jyl-t-2005', '2012-11-29', '2012-12-28', '远程同步班', '12000', '10000', '500', '5');
INSERT INTO `grade` VALUES ('12', 'bj-jyl-t-2004', '2012-10-18', '2012-10-18', '基地班', '11000', '9000', '100', '1');
INSERT INTO `job` VALUES ('1', '总经理', '999999', '啊啊啊啊啊', '0', '1', '');
INSERT INTO `job` VALUES ('2', '北京分公司总经理', '1', '哦哦', '0', '2', '');
INSERT INTO `job` VALUES ('3', '长沙分公司总经理', '1', '长沙总经理', '1', '16', '15');
INSERT INTO `job` VALUES ('4', '教务部主任', '2', '我是教务主任', '1', '18', '21');
INSERT INTO `job` VALUES ('5', '项目经理', '2', '啊啊我是项目经理', '1', '6', '11,22,23');
INSERT INTO `job` VALUES ('9', '班主任', '4', '我是班主任', '1', '18', '16,17,18,19,20,22,24,25,26');
INSERT INTO `memo` VALUES ('1', '美好的生活！', '2012-10-17 18', '2012-10-27 18', '', '11');
INSERT INTO `memo` VALUES ('5', '天天，你好吗？', '2012-10-24 20', '2012-10-27 20', null, '11');
INSERT INTO `memo` VALUES ('6', '龙行天下', '2012-10-2 19', '2012-10-20 19', null, '11');
INSERT INTO `memo` VALUES ('7', '明天', '2012-10-3 20', '2012-10-6 20', null, '11');
INSERT INTO `memo` VALUES ('8', '无敌战士！', '2012-10-12 20', '2012-10-20 20', null, '11');
INSERT INTO `memo` VALUES ('9', '秦时明月汉时关', '2012-10-18 9', '2012-10-27 9', null, '2');
INSERT INTO `memo` VALUES ('10', '天行健，君子以自强不息', '2012-10-4 12', '2012-10-13 12', null, '11');
INSERT INTO `message` VALUES ('1', '天下第一', '<p>谁是天下第一！<br /></p>', '2012-10-13', null, '11', '删除', '6610c1ba-569a-4f3d-a467-23e57667a984', '0');
INSERT INTO `message` VALUES ('2', '美好人生', '<p>美好人生<br /></p>', '2012-10-15', null, '11', '有效', '25e2daa4-bb0e-4dab-af96-bbcb00f6d4d3', '0');
INSERT INTO `message` VALUES ('3', '去死！', '<p>你好吗？<br /></p>', '2012-10-17', null, '11', '有效', '4e5d676e-2442-4df6-91ea-06eb2d7de279', '0');
INSERT INTO `messagereceiver` VALUES ('1', '1', '8', '未读', '有效', '0');
INSERT INTO `messagereceiver` VALUES ('2', '1', '10', '未读', '有效', '0');
INSERT INTO `messagereceiver` VALUES ('3', '2', '8', '未读', '有效', '0');
INSERT INTO `messagereceiver` VALUES ('4', '2', '10', '未读', '有效', '0');
INSERT INTO `messagereceiver` VALUES ('5', '3', '8', '未读', '有效', '0');
INSERT INTO `messagereceiver` VALUES ('6', '3', '10', '未读', '有效', '0');
INSERT INTO `org` VALUES ('1', '总公司', '999999', '我是总公司,谢谢', '0', '老高');
INSERT INTO `org` VALUES ('2', '北京分公司', '1', '我是分公司1', '0', '老李');
INSERT INTO `org` VALUES ('3', '长沙分公司', '1', '我是分公司2', '0', '老王');
INSERT INTO `org` VALUES ('4', '总公司研发部门', '1', '我是研发部！', '1', '老张');
INSERT INTO `org` VALUES ('5', '北京财务部门', '2', '财务部门', '0', '老刘');
INSERT INTO `org` VALUES ('6', '北京产品部门', '2', '财源之一', '1', '老裴');
INSERT INTO `org` VALUES ('13', '总公司财务部门', '1', '我是总公司财务负责人', '1', '小T');
INSERT INTO `org` VALUES ('16', '长沙研发部门', '3', '研发部..', '1', '小Y');
INSERT INTO `org` VALUES ('17', '北京研发部门', '2', '公司的重点部门', '1', '_oiYc');
INSERT INTO `org` VALUES ('18', '北京教务部门', '2', '日常的教学管理', '0', '小美');
INSERT INTO `org` VALUES ('28', '保安部门', '1', '保障公司的日常安全', '0', '张龙');
INSERT INTO `org` VALUES ('29', '保安一组', '28', '保卫公司安全', '1', '昊天');
INSERT INTO `org` VALUES ('37', '保安二组', '28', '保卫公司安全', '1', '赵虎');
INSERT INTO `shouru` VALUES ('1', '12000', '2012-10-6', '有钱人啊！', '0', '1', '未审核', '0');
INSERT INTO `shouru` VALUES ('2', '1234', '2012-10-3', '嘶嘶声', '0', '17', '未审核', '0');
INSERT INTO `shouru` VALUES ('3', '7890', '2012-10-26', '你可以去死了。', '0', '22', '未审核', '0');
INSERT INTO `shouru` VALUES ('4', '4567', '2012-10-20', '妹妹，你好吗？', '0', '20', '未审核', '0');
INSERT INTO `shouru` VALUES ('5', '4000', '2012-10-9', '朱重八', '0', '19', '审核通过', '0');
INSERT INTO `student` VALUES ('1', '张三', '1234567', '1111', '清华大学', '工商管理', '2011', '高中', '是', '2012-10-31', '学期内付清', '朋友推荐, ', '基地班', '白痴不是你的错！', '0', '预备学员', null, '1', '0', null, '0', '0', null, '否', '0', '0', '0', '0', null, '否', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('2', '李四', '1', '13199889922', '中山大学', '计算机', '2012', '专科', '否', '2012-10-31', '学期内付清', '朋友推荐, ', '脱产班', '朋友，你还好吗！', '0', '预备学员', null, '2', '0', null, '0', '0', null, '否', '0', '0', '0', '0', null, '是', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('4', '赵六', '1234', '142134352112', '重庆大学', '考古学', '2011', '硕士', '否', '2012-10-24', '先就业后付款', '网上文章, ', '网络班', '流氓不可怕，就怕流氓有文化！！！', '0', '正式学员', null, '3', '12000', '学费太高！', '0', '0', null, '是', '0', '0', '0', '0', null, '是', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('8', '赵六', '123232', '13199889922', '北京大学', '古文学', '2011', '硕士', '否', '2012-10-25', '学期内付清', '在校学员推荐, ', '网络班', '拖拖拖', '0', '不来了', '我不想去了！', '6', '0', null, '0', '0', null, null, '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('12', '小白', '2323', '1421343521121', '青龙学院', '古武术', '3022', '专科', '否', '2012-10-26', '先就业后付款', '朋友推荐, ', '远程同步班', '我爱武术！不为什么！', '0', '预备学员', null, '7', '0', null, '0', '0', null, '否', '0', '0', '0', '0', null, '是', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('13', '小美', '43122', '1421343', '美术学院', '美术', '2222', '硕士', '是', '2012-10-18', '学期内付清', '不知道', '远程同步班', '艺术！', '0', '不来了', '我不喜欢编程', '8', '0', null, '0', '0', null, null, '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('14', '战神', '444', '4444', '战神学员', '枪术', '0001', '硕士', '否', '2012-10-27', '学期内付清', '网上文章, ', '脱产班', '有我无敌！勇往直前！', '0', '预备学员', null, '12', '0', null, '0', '0', null, '否', '0', '0', '0', '0', null, '否', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('15', '刑天', '555', '555555', '蛮族', '体术', '0002', '本科', '是', '2012-10-24', '先就业后付款', '网上文章, ', '网络班', '无头战神！就是牛叉！', '0', '正式学员', null, '8', '12', '太低了！', '0', '0', null, '否', '0', '0', '0', '0', null, '否', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('16', '包拯', '888', '88888', '儒家', '当官', '3000', '专科', '否', '2012-10-26', '学期内付清', '北风网, ', '网络班', '我是青天大老爷！结果很悲惨！', '0', '预备学员', null, '8', '0', null, '0', '0', null, '否', '0', '0', '0', '0', null, '否', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('17', '展昭', '4343', '12321', '开封学院', '保镖', '2000', '本科', '否', '2012-10-20', '学期内付清', '在校学员推荐, ', '脱产班', '没钱途！走人。', '0', '正式学员', null, '1', '4567', '牛叉不用解释！', '0', '0', null, '否', '0', '0', '0', '0', null, '否', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('18', '实诚', '2323221', '12321231', '北京大学', '古文学', '2012', '本科', '否', '2012-10-31', '先就业后付款', '朋友推荐, ', '业余班', '你好吗？我很好！', '0', '退学', null, '8', '1234', '我想修改牛修改。', '100', '0', '我听不明白！', '否', '0', '0', '0', '0', null, '否', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('19', '周八', '2321', '2131221', '清华大学', '工商管理', '2011', '硕士', '是', '2012-10-15', '学期内付清', '在校学员推荐, ', '远程同步班', '巴伯。', '0', '预备学员', null, '3', '0', null, '0', '0', null, '否', '0', '0', '0', '0', null, '是', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('20', '白白猩猩', '455412', '13199889922', '中山大学', '计算机', '2012', '硕士', '否', '2012-11-23', '学期内付清', '北风网', '基地班', '离开，进入！GO?', '0', '预备学员', null, '6', '0', null, '0', '0', null, '否', '0', '0', '0', '0', null, '否', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('21', '天天', '00000', '01010101', '重庆大学', '物理', '3712', '专科', '否', '2012-10-27', '学期内付清', '北风网, ', '基地班', '好好学习，天天向上！', '0', '预备学员', null, '1', '0', null, '0', '0', null, '是', '0', '0', '0', '0', null, '是', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('22', '天龙', '1231', '2321', '开封学院', '工商管理', '2012', '本科', '否', '2012-10-18', '先就业后付款', '在校学员推荐, ', '远程同步班', '龙的传人！', '0', '预备学员', null, '2', '0', null, '0', '0', null, '否', '0', '0', '0', '0', null, '否', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('23', '青龙', '6543', '1111121', '青龙学院', '古武术', '0002', '专科', '否', '2012-10-31', '学期内付清', '', '远程同步班', '左青龙，右白虎！', '0', '意向学员', null, '0', '0', null, '0', '0', null, null, '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('24', '火狐', '212121', '132312321', '开封学院', '美术', '0002', '硕士', '是', '2012-10-5', '先就业后付款', '视频, ', '业余班', '一个浏览器', '0', '意向学员', null, '0', '0', null, '0', '0', null, null, '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `student` VALUES ('25', '李天霸', '34321321', '223123123', '北京大学', '古文学', '0002', '专科', '否', '2012-10-27', '先就业后付款', '', '远程同步班', '天霸', '0', '意向学员', null, '0', '0', null, '0', '0', null, null, '0', '0', '0', '0', null, null, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `user` VALUES ('1', '盗贼201297', '180021', '20', '注销', '2012-09-28');
INSERT INTO `user` VALUES ('2', '曹操199996', '4444', '4', '有效', '2012-09-28');
INSERT INTO `user` VALUES ('3', '貂蝉201195', '180022', '22', '有效', '2012-09-28');
INSERT INTO `user` VALUES ('4', '孙尚香201298', '180014', '8', '有效', '2012-09-28');
INSERT INTO `user` VALUES ('5', '蚩尤201294', '444444', '24', '有效', '2012-09-28');
INSERT INTO `user` VALUES ('6', '蒋介石2012921', '180000', '16', '有效', '2012-10-09');
INSERT INTO `user` VALUES ('7', '刑天201295', '454543', '25', '有效', '2012-10-09');
INSERT INTO `user` VALUES ('8', '乔峰2009913', '180010', '18', '有效', '2012-10-09');
INSERT INTO `user` VALUES ('9', '克拉斯201295', '180020', '23', '有效', '2012-10-09');
INSERT INTO `user` VALUES ('10', '郭靖2011910', '180777', '11', '有效', '2012-10-09');
INSERT INTO `user` VALUES ('11', '黄蓉小妹妹2012103', '180034', '26', '有效', '2012-10-12');
INSERT INTO `zhichu` VALUES ('2', '2000', '1', '你好吗？', '1', '11', '0', '2012-10-25', '001', '未审核', '0', null, null);
INSERT INTO `zhichu` VALUES ('3', '1000', '2', '我讨厌你@！', '17', '11', '0', '2012-10-31', '002', '审核通过', '0', null, null);
INSERT INTO `zhichu` VALUES ('4', '3000', '9', '有钱拿就不错了！', '22', '11', '0', '2012-10-10', '003', '未审核', '0', null, null);
INSERT INTO `zhichu` VALUES ('5', '4000', '1', '公费报销！', '4', '11', '0', '2012-10-31', '004', '未审核', '0', null, null);
INSERT INTO `zhichu` VALUES ('6', '5000', '14', '快点，我走了。', '12', '11', '0', '2012-10-30', '005', '未审核', '0', null, null);
INSERT INTO `zhichu` VALUES ('10', '7000', '5', '又有钱了！', '4', '11', '0', '2012-10-23', '007', '未审核', '0', null, null);
INSERT INTO `zhichu` VALUES ('11', '8000', '11', '通讯非欧', '4', '11', '0', '2012-10-23', '008', '未审核', '0', null, null);
