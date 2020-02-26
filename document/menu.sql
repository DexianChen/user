CREATE DATABASE db_menu;
USE db_menu;
CREATE TABLE `menu` (
  `menu_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '菜谱id',
  `name` VARCHAR(50) NOT NULL COMMENT '菜式名称',
  `taste` VARCHAR(50) DEFAULT NULL COMMENT '味道, 0-酸,1-甜,2-苦,3-辣,4-咸',
  `picture_url` VARCHAR(500) DEFAULT NULL COMMENT '菜谱图片',
  `category` VARCHAR(20) DEFAULT NULL COMMENT '菜谱图片',
  `step` TEXT COMMENT '做法步骤',
  `score` INT(11) DEFAULT NULL COMMENT '评分',
  `evaluate_content` TEXT CHARACTER SET latin1 COMMENT '评价内容',
  `create_time` DATE NOT NULL COMMENT '创建时间',
  `update_time` DATE DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8