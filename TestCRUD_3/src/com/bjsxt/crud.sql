-- ----------------------------
-- Table structure for `employee` 雇员表
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(20) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `salary` varchar(100) NOT NULL COMMENT '薪水',
  `tell` varchar(11) NOT NULL COMMENT '联系方式',
  `birthday` varchar(64) NOT NULL COMMENT '出生日期',
  `hiredate` varchar(64) NOT NULL COMMENT '入职日期',
  `p_id` varchar(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='雇员表';

-- ----------------------------
-- Table structure for `position` 岗位表
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(20) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL COMMENT '岗位名称',
  `level` varchar(16) NOT NULL COMMENT '岗位等级',
  `description` text NOT NULL COMMENT '岗位描述',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位表';



