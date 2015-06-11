-- ----------------------------
-- Table structure for `t_user 用户表
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `logo` varchar(100) DEFAULT NULL COMMENT '头像LOGO',
  `sex` tinyint(1) DEFAULT '0' COMMENT '0:男  1:女',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号', 
  `provinceId` bigint(20) DEFAULT NULL COMMENT '省份ID',
  `districtId` bigint(20) DEFAULT NULL COMMENT '地区ID',
  `cityId` bigint(20) DEFAULT NULL COMMENT '县市区ID',
  `address` varchar(100) DEFAULT NULL COMMENT '地址', 
  `longitude` varchar(22) DEFAULT NULL COMMENT '经度', 
  `latitude` varchar(22) DEFAULT NULL COMMENT '纬度', 
  `description` text COMMENT '简介', 
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` DATE DEFAULT NULL COMMENT '创建时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '修改者',
  `update_time` DATE DEFAULT NULL COMMENT '最后修改时间',
  `is_deleted` tinyint(1) DEFAULT NULL COMMENT '1:有效 0:删除',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';