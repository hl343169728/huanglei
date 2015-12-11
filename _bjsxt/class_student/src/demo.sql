-- ----------------------------
-- Table structure for `student` 学生表
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL auto_increment,
  `sname` varchar(20) NOT NULL COMMENT '姓名',
  `phone` varchar(11) NOT NULL COMMENT '联系方式',
  `age` int(10) NOT NULL COMMENT '年龄',
  `imagePath` varchar(100) NOT NULL COMMENT '图片路径',
  `srow` int(10) NOT NULL COMMENT '学生行号',
  `scol` int(10) NOT NULL COMMENT '学生列号',
  `cid` bigint(20) NOT NULL COMMENT '班级的id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

-- ----------------------------
-- Table structure for `clz` 班级表
-- ----------------------------
DROP TABLE IF EXISTS `clz`;
CREATE TABLE `clz` (
  `id` bigint(20) NOT NULL auto_increment,
  `cname` varchar(20) NOT NULL COMMENT '班级名称',
  `address` varchar(100) NOT NULL COMMENT '班级地址',
  `teacher` varchar(100) NOT NULL COMMENT '班级的老师',
  `crow` int(10) NOT NULL COMMENT '班级的行数',
  `ccol` int(10) NOT NULL COMMENT '班级的列数',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级表';