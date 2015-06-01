-- ----------------------------
-- Table structure for `information` 信息相关资料表
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(64) DEFAULT NULL COMMENT 'the title',
  `subhead` varchar(64) DEFAULT NULL COMMENT 'this subtitle',
  `summary` varchar(200) DEFAULT NULL COMMENT 'summary',
  `comment` text COMMENT 'comment',
  `address` varchar(32) DEFAULT NULL COMMENT 'address',
  `m_type` int(4) DEFAULT '0' COMMENT 'message type ',
  `reource` varchar(64) DEFAULT NULL COMMENT 'resource',
  `action_time` datetime DEFAULT NULL COMMENT 'activity time',
  `action_time2` varchar(64) DEFAULT NULL COMMENT 'activity time',
  `action_addr` varchar(120) DEFAULT NULL COMMENT 'activity address',
  `field1` varchar(120) DEFAULT NULL COMMENT 'Alternate field',
  `field2` varchar(120) DEFAULT NULL COMMENT 'Alternate field',
  `field3` varchar(120) DEFAULT NULL COMMENT 'Alternate field',
  `field4` varchar(120) DEFAULT NULL COMMENT 'Alternate field',
  `creator` bigint(20) DEFAULT NULL COMMENT 'creator',
  `create_time` datetime DEFAULT NULL COMMENT 'create time',
  `updater` bigint(20) DEFAULT NULL COMMENT 'updater',
  `update_time` datetime DEFAULT NULL COMMENT 'update time',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='information';

-- ----------------------------
-- Table structure for `message_info` 在线留言表
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(64) default NULL COMMENT 'name',
  `sex` varchar(20) default NULL COMMENT 'sex',
  `address` varchar(64) default NULL COMMENT 'address',
  `mobile` varchar(11) default NULL COMMENT 'mobile',
  `email` varchar(64) default NULL COMMENT 'email',
  `comment` text COMMENT 'comment',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='message_info';

-- ----------------------------
-- Table structure for `online_service` 在线客服表
-- ----------------------------
DROP TABLE IF EXISTS `online_service`;
CREATE TABLE `online_service` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(64) default NULL COMMENT 'name',
  `address` varchar(64) default NULL COMMENT 'address',
  `mobile` varchar(11) default NULL COMMENT 'mobile',
  `comment` text COMMENT 'comment',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='online_service';