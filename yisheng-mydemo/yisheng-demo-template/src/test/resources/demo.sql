-- ----------------------------
-- Table structure for `hib_clazz` 班级表
-- ----------------------------
DROP TABLE IF EXISTS `hib_clazz`;
CREATE TABLE `hib_clazz` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '班级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级表';

-- ----------------------------
-- Table structure for `hib_student` 学生表
-- ----------------------------
DROP TABLE IF EXISTS `hib_student`;
CREATE TABLE `hib_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clazzId` bigint(20) NOT NULL COMMENT '班级ID',
  `name` varchar(100) NOT NULL COMMENT '学生姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Table structure for `hib_course` 课程表
-- ----------------------------
DROP TABLE IF EXISTS `hib_course`;
CREATE TABLE `hib_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '课程名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Table structure for `hib_student_course` 学生课程表
-- ----------------------------
DROP TABLE IF EXISTS `hib_student_course`;
CREATE TABLE `hib_student_course` (
  `studentId` bigint(20) NOT NULL COMMENT '学生ID',
  `courseId` bigint(20) NOT NULL COMMENT '课程ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生课程表';

-- ----------------------------
-- Table structure for `trans_person` 人员信息表
-- ----------------------------
DROP TABLE IF EXISTS `trans_person`;
CREATE TABLE `trans_person` ( 
  `id` bigint(20) NOT NULL AUTO_INCREMENT, 
  `name` varchar(20) DEFAULT NULL COMMENT '姓名', 
  `sex` varchar(2) DEFAULT NULL COMMENT '性别', 
  `age` int(11) DEFAULT NULL COMMENT '年龄', 
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员信息表';

-- ----------------------------
-- Table structure for `trans_orders` 订单表
-- ----------------------------
DROP TABLE IF EXISTS `trans_orders`;
CREATE TABLE `trans_orders` ( 
  `id` bigint(20) NOT NULL AUTO_INCREMENT, 
  `cost` int(11) NOT NULL COMMENT '花费', 
  `customerId` int(11) NOT NULL, 
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Table structure for `t_user 用户表
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(20) DEFAULT NULL COMMENT '姓名', 
  `address` varchar(100) DEFAULT NULL COMMENT '地址', 
  `sex` tinyint(1) DEFAULT '0' COMMENT '1:女 0:男',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号', 
  `description` text COMMENT '简介', 
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATE DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '修改者',
  `update_time` DATE DEFAULT NULL COMMENT '最后修改时间',
  `is_deleted` tinyint(1) DEFAULT NULL COMMENT '1:有效 0:删除',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';