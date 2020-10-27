Create Database If Not Exists `cfundtool` default character set utf8mb4 collate utf8mb4_general_ci;

use cfundtool;

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `account_daily_income`;

CREATE TABLE `account_daily_income` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` varchar(32) NOT NULL DEFAULT '2020-01-01' COMMENT '日期',
  `fund_id` int(11) NOT NULL DEFAULT '0' COMMENT '基金id',
  `income` decimal(10,2) NOT NULL DEFAULT '0.01' COMMENT '收益',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户收益表';



DROP TABLE IF EXISTS `asset`;

CREATE TABLE `asset` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` varchar(16) NOT NULL DEFAULT '' COMMENT '盘点日期',
  `item_name` varchar(32) NOT NULL DEFAULT '' COMMENT '项目名称',
  `item_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '项目资产',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资产表';

LOCK TABLES `asset` WRITE;

INSERT INTO `asset` (`id`, `date`, `item_name`, `item_amount`)
VALUES
	(1,'2020-10-01','微信',100283.00),
	(2,'2020-10-01','微支付宝（余额宝|犀犀大学基金）（不动）',20192.00),
	(3,'2020-10-01','支付宝（蚂蚁基金18月）',10000.00),
	(4,'2020-10-01','微招行工资卡（活期）',83440.00),
	(5,'2020-10-01','微招行理财定期一年',20154.00),
	(6,'2020-10-01','微招行基金',29480.00),
	(7,'2020-10-01','同花顺基金',9877.38),
	(8,'2020-10-01','天天基金',10000.00);

UNLOCK TABLES;

DROP TABLE IF EXISTS `deal`;

CREATE TABLE `deal` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` varchar(32) NOT NULL DEFAULT '2020-01-01' COMMENT '日期',
  `fund_id` int(11) NOT NULL DEFAULT '0' COMMENT '基金id',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户交易表';

LOCK TABLES `deal` WRITE;

INSERT INTO `deal` (`id`, `date`, `fund_id`, `amount`)
VALUES
	(1,'2020-09-22',1,5000.00),
	(2,'2020-10-09',1,5000.00),
	(3,'2020-09-22',2,5000.00),
	(4,'2020-10-09',2,5000.00);

UNLOCK TABLES;


DROP TABLE IF EXISTS `fund`;

CREATE TABLE `fund` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fund_name` varchar(32) NOT NULL DEFAULT '' COMMENT '基金名称',
  `outside_fund` varchar(32) NOT NULL DEFAULT '' COMMENT '基金代码（场外）',
  `inside_fund` varchar(32) NOT NULL DEFAULT '' COMMENT '基金代码（场内）',
  `build_date` varchar(32) NOT NULL DEFAULT '2020-01-01' COMMENT '成立时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基金表';

LOCK TABLES `fund` WRITE;

INSERT INTO `fund` (`id`, `fund_name`, `outside_fund`, `inside_fund`, `build_date`)
VALUES
	(1,'华夏上证50AH优选指数（LOF）A','501050','501050','2016-10-27'),
	(2,'天弘中证银行A','001594','512800','2015-07-08'),
	(3,'嘉实50','160716','160716','2009-12-30'),
	(4,'易H股ETF联接人民币A','110031','510900','2012-08-21'),
	(5,'银河沪深300价值指数基金','519671','','2009-12-28'),
	(6,'大成中证红利指数A','090010','','2010-02-02'),
	(7,'华夏恒生ETF联接A','000071','159920','2012-08-21'),
	(8,'易基50指数A','110003','510710','2004-03-22'),
	(9,'华宝兴业标普中国A股红利机会指数证券','501029','501029','2017-01-18'),
	(10,'易沪深300ETF联接','110020','510310','2009-08-26'),
	(11,'招商央视50指数','217027','159965','2013-02-05'),
	(12,'华宝兴业标普香港上市中国中小盘指数证券','501021','501021','2016-06-24'),
	(13,'华安180联接','040180','510180','2009-09-29'),
	(14,'景顺长城中证500行业中性低波动','003318','512260','2017-03-03'),
	(15,'嘉实深证120联接','070023','159910','2011-08-01'),
	(16,'富国500前收费基金','161017','510580','2011-10-12'),
	(17,'广发可选消费联接A类','001133','159936','2015-04-15'),
	(18,'南方全指证券联接A','004069','512000','2017-03-08'),
	(19,'建信深证基本面60ETF联接A','530015','159916','2011-09-08'),
	(20,'国投瑞银深证100指数','161227','159901','2015-08-14'),
	(21,'申万菱信深证成指分级基金','163109','159943','2010-10-22'),
	(22,'汇添富中证主要消费ETF联接','000248','159928','2015-03-24'),
	(23,'国泰纳斯达克100指数基金','160213','513100','2010-04-29'),
	(24,'广发中证养老指数A类','000968','','2015-02-13'),
	(25,'博时标普500ETF联接A','050025','513500','2012-06-14'),
	(26,'天弘中证医药100A','001550','','2015-06-30'),
	(27,'富国创业板指数分级证券投资基金','161022','159915','2013-09-12');

UNLOCK TABLES;


DROP TABLE IF EXISTS `index`;

CREATE TABLE `index` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '指数名称',
  `code` varchar(32) NOT NULL DEFAULT '' COMMENT '指数代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='指数表';

LOCK TABLES `index` WRITE;

INSERT INTO `index` (`id`, `name`, `code`)
VALUES
	(1,'50AH优选','SH000170'),
	(2,'中证银行','SZ399986'),
	(3,'基本面50','SH000925'),
	(4,'H股指数','HKHSCEI'),
	(5,'300价值','000919'),
	(6,'上证红利','000015'),
	(7,'中证红利','SH000922'),
	(8,'恒生指数','HKHSI'),
	(9,'上证50','SH000016'),
	(10,'红利机会','CSPSADRP'),
	(11,'沪深300','SH000300'),
	(12,'央视50','SZ399550'),
	(13,'香港中小','SPHCMSHP'),
	(14,'上证180','000010'),
	(15,'500低波动','CSI930782'),
	(16,'基本面120','399702'),
	(17,'中证500','SH000905'),
	(18,'可选消费','SH000989'),
	(19,'证券行业','399975'),
	(20,'基本面60','399701'),
	(21,'深证100','SZ399330'),
	(22,'深证成指','399001'),
	(23,'中证消费','000932'),
	(24,'纳斯达克100','NDX'),
	(25,'中证养老','SZ399812'),
	(26,'标普500','SP500'),
	(27,'医药100','000978'),
	(28,'创业板指数','SZ399006');

UNLOCK TABLES;


DROP TABLE IF EXISTS `index_daily_report`;

CREATE TABLE `index_daily_report` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `index_id` int(11) NOT NULL COMMENT '指数id',
  `date` varchar(32) NOT NULL DEFAULT '2020-01-01' COMMENT '日期',
  `ep` double NOT NULL DEFAULT '0.1' COMMENT '盈利收益率',
  `pe` double NOT NULL DEFAULT '0.1' COMMENT '市盈率',
  `pb` double NOT NULL DEFAULT '0.1' COMMENT '市净率',
  `dyr` double NOT NULL DEFAULT '0.1' COMMENT '股息率',
  `roe` double NOT NULL DEFAULT '0.1' COMMENT '净资产收益率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基金数据表';

LOCK TABLES `index_daily_report` WRITE;

INSERT INTO `index_daily_report` (`id`, `index_id`, `date`, `ep`, `pe`, `pb`, `dyr`, `roe`)
VALUES
	(1,1,'2020-09-30',0.1033,9.68,1.03,0.0331,0.1064),
	(2,2,'2020-09-30',0,0,0.87,0,0),
	(3,3,'2020-09-30',0.1023,9.78,1.02,0.0305,0.1044),
	(4,4,'2020-09-30',0.1009,9.91,1.11,0.0213,0.1117),
	(5,5,'2020-09-30',0.1003,9.97,0.98,0.0381,0.098),
	(6,6,'2020-09-30',0.0998,10.02,1.05,0.0479,0.1043),
	(7,7,'2020-09-30',0.099,10.11,1.09,0.0451,0.1082),
	(8,8,'2020-09-30',0.0826,12.11,1.12,0.0242,0.0924),
	(9,9,'2020-09-30',0.0968,10.33,1.19,0.0257,0.1151),
	(10,10,'2020-09-30',0.0716,13.97,1.58,0.0333,0.1131),
	(11,11,'2020-09-30',0.0764,13.09,1.45,0.0202,0.1107),
	(12,12,'2020-09-30',0.0925,10.81,1.27,0.0279,0.1171),
	(13,13,'2020-09-30',0.071,14.08,1.59,0,0.1129),
	(14,14,'2020-09-30',0.0832,12.02,1.19,0.0248,0.0993),
	(15,15,'2020-09-30',0.0358,27.92,1.44,0.0164,0.0516),
	(16,16,'2020-09-30',0.0463,21.58,2.67,0.0112,0.1235),
	(17,17,'2020-09-30',0.0312,32.01,2.05,0.0108,0.064),
	(18,18,'2020-09-30',0.0277,36.09,2.52,0.0148,0.0698),
	(19,19,'2020-09-30',0,0,2.1,0,0),
	(20,20,'2020-09-30',0.0472,21.19,2.67,0.0116,0.126),
	(21,21,'2020-09-30',0.0353,28.32,3.78,0.0077,0.1336),
	(22,22,'2020-09-30',0.0326,30.71,3.15,0.0078,0.1025),
	(23,23,'2020-09-30',0.0274,36.53,8.75,0.0078,0.2397),
	(24,24,'2020-09-30',0.0317,31.58,7.3,0,0.2312),
	(25,25,'2020-09-30',0.0309,32.41,3.78,0.0094,0.1166),
	(26,26,'2020-09-30',0.0342,29.28,3.44,0,0.1176),
	(27,27,'2020-09-30',0.0241,41.49,5.94,0.0057,0.1431),
	(28,28,'2020-09-30',0.0172,58.07,7.64,0.0027,0.1316),
	(29,1,'2020-10-09',0.1012,9.88,1.05,0.0324,0.1063),
	(30,2,'2020-10-09',0,0,0.87,0,0),
	(31,3,'2020-10-09',0.1013,9.87,1.03,0.0302,0.1043),
	(32,5,'2020-10-09',0.0995,10.05,0.98,0.0378,0.0979),
	(33,4,'2020-10-09',0.0988,10.12,1.13,0.0206,0.1121),
	(34,6,'2020-10-09',0.0984,10.17,1.06,0.0476,0.104),
	(35,7,'2020-10-09',0.0976,10.24,1.1,0.0448,0.1072),
	(36,8,'2020-10-09',0.0805,12.42,1.15,0.0235,0.0922),
	(37,9,'2020-10-09',0.0957,10.45,1.2,0.0254,0.1151),
	(38,10,'2020-10-09',0.0704,14.21,1.61,0.0327,0.1133),
	(39,11,'2020-10-09',0.075,13.33,1.47,0.0199,0.1105),
	(40,12,'2020-10-09',0.0913,10.95,1.28,0.0275,0.1171),
	(41,13,'2020-10-09',0.0689,14.52,1.64,0,0.1129),
	(42,14,'2020-10-09',0.0822,12.17,1.21,0.0245,0.0993),
	(43,15,'2020-10-09',0.0353,28.33,1.47,0.0161,0.0519),
	(44,16,'2020-10-09',0.0456,21.91,2.74,0.0109,0.1249),
	(45,17,'2020-10-09',0.0305,32.84,2.1,0.0105,0.064),
	(46,18,'2020-10-09',0.0273,36.69,2.56,0.0146,0.0697),
	(47,19,'2020-10-09',0,0,2.13,0,0),
	(48,20,'2020-10-09',0.0459,21.81,2.75,0.0113,0.126),
	(49,21,'2020-10-09',0.0343,29.17,3.9,0.0075,0.1336),
	(50,22,'2020-10-09',0.0316,31.63,3.24,0.0076,0.1025),
	(51,23,'2020-10-09',0.0269,37.16,8.9,0.0077,0.2396),
	(52,24,'2020-10-09',0.0311,32.19,7.43,0,0.2308),
	(53,25,'2020-10-09',0.0304,32.88,3.84,0.0093,0.1168),
	(54,26,'2020-10-09',0.0329,30.38,3.56,0,0.1171),
	(55,27,'2020-10-09',0.0234,42.82,6.09,0.0056,0.1422),
	(56,28,'2020-10-09',0.0165,60.58,7.95,0.0026,0.1313);

UNLOCK TABLES;


DROP TABLE IF EXISTS `relation_fund_stock`;

CREATE TABLE `relation_fund_stock` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fund_id` int(11) NOT NULL DEFAULT '0' COMMENT '基金id',
  `stock_id` int(1) NOT NULL DEFAULT '0' COMMENT '股票id',
  `percent` double NOT NULL DEFAULT '0.1' COMMENT '占比',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基金股票关联表';

DROP TABLE IF EXISTS `stock`;

CREATE TABLE `stock` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '股票名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='股票表';

