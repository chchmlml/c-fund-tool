# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.28)
# Database: cfundtool
# Generation Time: 2020-09-28 08:48:24 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table account_daily_income
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account_daily_income`;

CREATE TABLE `account_daily_income` (
                                        `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                        `date` varchar(32) NOT NULL DEFAULT '2020-01-01' COMMENT '日期',
                                        `fund_id` int(11) NOT NULL DEFAULT '0' COMMENT '基金id',
                                        `income` double NOT NULL DEFAULT '0.01' COMMENT '收益',
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户收益表';



# Dump of table account_deal_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account_deal_log`;

CREATE TABLE `account_deal_log` (
                                    `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                    `date` varchar(32) NOT NULL DEFAULT '2020-01-01' COMMENT '日期',
                                    `fund_id` int(11) NOT NULL DEFAULT '0' COMMENT '基金id',
                                    `sum` int(11) NOT NULL DEFAULT '0' COMMENT '金额',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户交易表';



# Dump of table fund
# ------------------------------------------------------------

DROP TABLE IF EXISTS `fund`;

CREATE TABLE `fund` (
                        `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `name` varchar(64) NOT NULL DEFAULT '' COMMENT '基金名称',
                        `code` varchar(32) NOT NULL DEFAULT '' COMMENT '基金代码',
                        `scope` int(10) NOT NULL DEFAULT '0' COMMENT '基金规模',
                        `build_date` varchar(32) NOT NULL DEFAULT '2020-01-01' COMMENT '成立时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基金表';



# Dump of table fund_daily_data
# ------------------------------------------------------------

DROP TABLE IF EXISTS `fund_daily_data`;

CREATE TABLE `fund_daily_data` (
                                   `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                   `fund_id` int(11) NOT NULL DEFAULT '1' COMMENT '基金id',
                                   `date` varchar(32) NOT NULL DEFAULT '2020-01-01' COMMENT '日期',
                                   `EP` float NOT NULL DEFAULT '0.1' COMMENT '盈利收益率',
                                   `PE` float NOT NULL DEFAULT '0.1' COMMENT '市盈率',
                                   `PB` float NOT NULL DEFAULT '0.1' COMMENT '市净率',
                                   `DYR` float NOT NULL DEFAULT '0.1' COMMENT '股息率',
                                   `ROE` float NOT NULL DEFAULT '0.1' COMMENT '净资产收益率',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基金数据表';



# Dump of table relation_fund_stock
# ------------------------------------------------------------

DROP TABLE IF EXISTS `relation_fund_stock`;

CREATE TABLE `relation_fund_stock` (
                                       `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                                       `fund_id` int(11) NOT NULL DEFAULT '0' COMMENT '基金id',
                                       `stock_id` int(1) NOT NULL DEFAULT '0' COMMENT '股票id',
                                       `percent` float NOT NULL DEFAULT '0.1' COMMENT '占比',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基金股票关联表';



# Dump of table stock
# ------------------------------------------------------------

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
                         `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
                         `name` varchar(32) NOT NULL DEFAULT '' COMMENT '股票名称',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='股票表';




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
