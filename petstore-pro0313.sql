/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.39 : Database - petstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`petstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `petstore`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `userid` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `firstname` varchar(80) NOT NULL,
  `lastname` varchar(80) NOT NULL,
  `status` varchar(2) DEFAULT NULL,
  `addr1` varchar(80) NOT NULL,
  `addr2` varchar(40) DEFAULT NULL,
  `city` varchar(80) NOT NULL,
  `state` varchar(80) NOT NULL,
  `zip` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `phone` varchar(80) NOT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `account` */

insert  into `account`(`userid`,`email`,`firstname`,`lastname`,`status`,`addr1`,`addr2`,`city`,`state`,`zip`,`country`,`phone`) values ('','z','z','z','OK','z','z','z','z','z','z','z'),('ACID','acid@yourdomain.com','ABC','XYX','OK','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','555-555-5555'),('j','','','','OK','','','','','','',''),('j2ee','b','b','b',NULL,'a','a','a','a','a','a','a'),('x','x','x','x','OK','x','x','x','x','x','x','x');

/*Table structure for table `bannerdata` */

DROP TABLE IF EXISTS `bannerdata`;

CREATE TABLE `bannerdata` (
  `favcategory` varchar(80) NOT NULL,
  `bannername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`favcategory`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `bannerdata` */

insert  into `bannerdata`(`favcategory`,`bannername`) values ('BIRDS','<image src=\"../images/banner_birds.gif\">'),('CATS','<image src=\"../images/banner_cats.gif\">'),('DOGS','<image src=\"../images/banner_dogs.gif\">'),('FISH','<image src=\"../images/banner_fish.gif\">'),('REPTILES','<image src=\"../images/banner_reptiles.gif\">');

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `userid` varchar(80) NOT NULL,
  `itemid` varchar(10) NOT NULL,
  `productid` varchar(10) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  `instock` tinyint(1) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `listprice` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`userid`,`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cart` */

insert  into `cart`(`userid`,`itemid`,`productid`,`name`,`instock`,`quantity`,`listprice`,`total`) values ('1','1','1','1',1,23,'2.00','2.00'),('1','2','2','2',1,3,'4.00','12.00'),('2','1','2','2',1,2,'2.00','4.00'),('j2ee','EST-13','RP-LI-02','Iguana',1,3,'18.50','55.50'),('j2ee','EST-19','AV-SB-02','Finch',1,1,'15.50','15.50');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `catid` varchar(10) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `descn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`catid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `category` */

insert  into `category`(`catid`,`name`,`descn`) values ('BIRDS','Birds','<image src=\"../images/birds_icon.gif\"><font size=\"5\" color=\"blue\"> Birds</font>'),('CATS','Cats','<image src=\"../images/cats_icon.gif\"><font size=\"5\" color=\"blue\"> Cats</font>'),('DOGS','Dogs','<image src=\"../images/dogs_icon.gif\"><font size=\"5\" color=\"blue\"> Dogs</font>'),('FISH','Fish','<image src=\"../images/fish_icon.gif\"><font size=\"5\" color=\"blue\"> Fish</font>'),('REPTILES','Reptiles','<image src=\"../images/reptiles_icon.gif\"><font size=\"5\" color=\"blue\"> Reptiles</font>');

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `itemid` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`itemid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `inventory` */

insert  into `inventory`(`itemid`,`qty`) values ('EST-1',9998),('EST-10',10000),('EST-11',9997),('EST-12',10000),('EST-13',9998),('EST-14',10000),('EST-15',10000),('EST-16',10000),('EST-17',10000),('EST-18',9977),('EST-19',9940),('EST-2',10000),('EST-20',10000),('EST-21',10000),('EST-22',10000),('EST-23',10000),('EST-24',10000),('EST-25',10000),('EST-26',9996),('EST-27',9983),('EST-28',10000),('EST-3',10000),('EST-4',9992),('EST-5',10000),('EST-6',9997),('EST-7',10000),('EST-8',10000),('EST-9',10000);

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `itemid` varchar(10) NOT NULL,
  `productid` varchar(10) NOT NULL,
  `listprice` decimal(10,2) DEFAULT NULL,
  `unitcost` decimal(10,2) DEFAULT NULL,
  `supplier` int(11) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `attr1` varchar(80) DEFAULT NULL,
  `attr2` varchar(80) DEFAULT NULL,
  `attr3` varchar(80) DEFAULT NULL,
  `attr4` varchar(80) DEFAULT NULL,
  `attr5` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`itemid`) USING BTREE,
  KEY `fk_item_2` (`supplier`) USING BTREE,
  KEY `itemProd` (`productid`) USING BTREE,
  CONSTRAINT `fk_item_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `fk_item_2` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`suppid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `item` */

insert  into `item`(`itemid`,`productid`,`listprice`,`unitcost`,`supplier`,`status`,`attr1`,`attr2`,`attr3`,`attr4`,`attr5`) values ('EST-1','FI-SW-01','16.50','10.00',1,'P','Large',NULL,NULL,NULL,NULL),('EST-10','K9-DL-01','18.50','12.00',1,'P','Spotted Adult Female',NULL,NULL,NULL,NULL),('EST-11','RP-SN-01','18.50','12.00',1,'P','Venomless',NULL,NULL,NULL,NULL),('EST-12','RP-SN-01','18.50','12.00',1,'P','Rattleless',NULL,NULL,NULL,NULL),('EST-13','RP-LI-02','18.50','12.00',1,'P','Green Adult',NULL,NULL,NULL,NULL),('EST-14','FL-DSH-01','58.50','12.00',1,'P','Tailless',NULL,NULL,NULL,NULL),('EST-15','FL-DSH-01','23.50','12.00',1,'P','With tail',NULL,NULL,NULL,NULL),('EST-16','FL-DLH-02','93.50','12.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-17','FL-DLH-02','93.50','12.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-18','AV-CB-01','193.50','92.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-19','AV-SB-02','15.50','2.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-2','FI-SW-01','16.50','10.00',1,'P','Small',NULL,NULL,NULL,NULL),('EST-20','FI-FW-02','5.50','2.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-21','FI-FW-02','5.29','1.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-22','K9-RT-02','135.50','100.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-23','K9-RT-02','145.49','100.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-24','K9-RT-02','255.50','92.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-25','K9-RT-02','325.29','90.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-26','K9-CW-01','125.50','92.00',1,'P','Adult Male',NULL,NULL,NULL,NULL),('EST-27','K9-CW-01','155.29','90.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-28','K9-RT-01','155.29','90.00',1,'P','Adult Female',NULL,NULL,NULL,NULL),('EST-3','FI-SW-02','18.50','12.00',1,'P','Toothless',NULL,NULL,NULL,NULL),('EST-4','FI-FW-01','18.50','12.00',1,'P','Spotted',NULL,NULL,NULL,NULL),('EST-5','FI-FW-01','18.50','12.00',1,'P','Spotless',NULL,NULL,NULL,NULL),('EST-6','K9-BD-01','18.50','12.00',1,'P','Male Adult',NULL,NULL,NULL,NULL),('EST-7','K9-BD-01','18.50','12.00',1,'P','Female Puppy',NULL,NULL,NULL,NULL),('EST-8','K9-PO-02','18.50','12.00',1,'P','Male Puppy',NULL,NULL,NULL,NULL),('EST-9','K9-DL-01','18.50','12.00',1,'P','Spotless Male Puppy',NULL,NULL,NULL,NULL);

/*Table structure for table `lineitem` */

DROP TABLE IF EXISTS `lineitem`;

CREATE TABLE `lineitem` (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `itemid` varchar(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitprice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`orderid`,`linenum`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `lineitem` */

insert  into `lineitem`(`orderid`,`linenum`,`itemid`,`quantity`,`unitprice`) values (1005,1,'EST-18',1,'193.50'),(1006,1,'EST-18',1,'193.50'),(1007,1,'EST-18',1,'193.50'),(1008,1,'EST-18',1,'193.50'),(1008,2,'EST-4',1,'18.50'),(1009,1,'EST-1',1,'16.50'),(1009,2,'EST-6',2,'18.50'),(1009,3,'EST-27',1,'155.29'),(1010,1,'EST-19',1,'15.50'),(1010,2,'EST-1',1,'16.50'),(1011,1,'EST-4',3,'18.50'),(1012,1,'EST-19',1,'15.50'),(1013,1,'EST-19',1,'15.50'),(1014,1,'EST-19',1,'15.50'),(1020,1,'EST-18',1,'193.50'),(1021,1,'EST-18',1,'193.50'),(1022,1,'EST-18',1,'193.50'),(1023,1,'EST-18',1,'193.50'),(1024,1,'EST-18',1,'193.50'),(1025,1,'EST-18',1,'193.50'),(1026,1,'EST-18',1,'193.50'),(1027,1,'EST-4',1,'18.50'),(1028,1,'EST-19',1,'15.50'),(1029,1,'EST-19',1,'15.50'),(1030,1,'EST-26',3,'125.50'),(1030,2,'EST-19',1,'15.50'),(1031,1,'EST-19',5,'15.50'),(1032,1,'EST-19',5,'15.50'),(1033,1,'EST-19',5,'15.50'),(1034,1,'EST-19',5,'15.50'),(1035,1,'EST-19',5,'15.50'),(1036,1,'EST-19',5,'15.50'),(1037,1,'EST-19',5,'15.50'),(1038,1,'EST-19',5,'15.50'),(1039,1,'EST-19',5,'15.50'),(1040,1,'EST-27',4,'155.29'),(1041,1,'EST-27',4,'155.29'),(1042,1,'EST-27',4,'155.29'),(1043,1,'EST-27',4,'155.29'),(1044,1,'EST-18',4,'193.50'),(1044,2,'EST-11',1,'18.50'),(1045,1,'EST-18',2,'193.50'),(1046,1,'EST-18',1,'193.50'),(1047,1,'EST-4',3,'18.50'),(1048,1,'EST-19',3,'15.50'),(1048,2,'EST-13',1,'18.50'),(1049,1,'EST-13',1,'18.50'),(1050,1,'EST-19',1,'15.50'),(1051,1,'EST-19',1,'15.50'),(1052,1,'EST-19',1,'15.50'),(1053,1,'EST-19',1,'15.50'),(1054,1,'EST-26',1,'125.50'),(1055,1,'EST-6',1,'18.50'),(1056,1,'EST-18',1,'193.50'),(1057,1,'EST-19',1,'15.50'),(1057,2,'EST-11',2,'18.50');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL,
  `userid` varchar(80) NOT NULL,
  `orderdate` date NOT NULL,
  `shipaddr1` varchar(80) NOT NULL,
  `shipaddr2` varchar(80) DEFAULT NULL,
  `shipcity` varchar(80) NOT NULL,
  `shipstate` varchar(80) NOT NULL,
  `shipzip` varchar(20) NOT NULL,
  `shipcountry` varchar(20) NOT NULL,
  `billaddr1` varchar(80) NOT NULL,
  `billaddr2` varchar(80) DEFAULT NULL,
  `billcity` varchar(80) NOT NULL,
  `billstate` varchar(80) NOT NULL,
  `billzip` varchar(20) NOT NULL,
  `billcountry` varchar(20) NOT NULL,
  `courier` varchar(80) NOT NULL,
  `totalprice` decimal(10,2) NOT NULL,
  `billtofirstname` varchar(80) NOT NULL,
  `billtolastname` varchar(80) NOT NULL,
  `shiptofirstname` varchar(80) NOT NULL,
  `shiptolastname` varchar(80) NOT NULL,
  `creditcard` varchar(80) NOT NULL,
  `exprdate` varchar(7) NOT NULL,
  `cardtype` varchar(80) NOT NULL,
  `locale` varchar(80) NOT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `orders` */

insert  into `orders`(`orderid`,`userid`,`orderdate`,`shipaddr1`,`shipaddr2`,`shipcity`,`shipstate`,`shipzip`,`shipcountry`,`billaddr1`,`billaddr2`,`billcity`,`billstate`,`billzip`,`billcountry`,`courier`,`totalprice`,`billtofirstname`,`billtolastname`,`shiptofirstname`,`shiptolastname`,`creditcard`,`exprdate`,`cardtype`,`locale`) values (1003,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1004,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1005,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1006,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1007,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1008,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','212.00','AB1111','XYX','AB1111','XYX','6666666666666','11/11','Visa','CA'),(1009,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','208.79','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1010,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','32.00','AB','XYX','AB2222','XYX','6666666666666','11/11','Visa','CA'),(1011,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','55.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1012,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','15.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1013,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','15.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1014,'j2ee','2019-08-17','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','15.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1020,'j2ee','2019-08-18','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1021,'j2ee','2019-08-18','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1022,'j2ee','2019-08-18','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1023,'j2ee','2019-08-18','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1024,'j2ee','2019-08-18','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1025,'j2ee','2019-08-18','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1026,'j2ee','2019-08-18','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1027,'j2ee','2019-08-18','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','18.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1028,'j2ee','2019-08-19','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','15.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1029,'j2ee','2019-08-19','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','15.50','AB','XYX','AB','XYX','6666666666666','11/11','Visa','CA'),(1030,'j2ee','2019-08-25','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','392.00','AB675','XYX777','AB675777','XYX777888','6666666666666','11/11','Visa','CA'),(1031,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','77.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1032,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','77.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1033,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','77.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1034,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','77.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1035,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','77.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1036,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','77.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1037,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','77.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1038,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','77.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1039,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','77.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1040,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','621.16','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1041,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','621.16','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1042,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','621.16','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1043,'j2ee','2019-08-27','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','621.16','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1044,'j2ee','2019-08-29','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','792.50','AB122222','XYX33333','AB122222','XYX33','6666666666666','11/11','Visa','CA'),(1045,'j2ee','2019-09-07','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','387.00','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1046,'j2ee','2019-09-07','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','193.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1047,'j2ee','2019-09-18','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','55.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1048,'j2ee','2019-09-29','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','65.00','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1049,'j2ee','2019-09-30','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','901 San Antonio Road','MS UCUP02-206','Palo Alto','CA','94303','USA','UPS','18.50','AB1','XYX','AB1','XYX','6666666666666','11/11','Visa','CA'),(1050,'j2ee','2019-10-05','a','a','a','a','a','a','a','a','a','a','a','a','UPS','15.50','b','b','b','b','6666666666666','11/11','Visa','CA'),(1051,'j2ee','2019-10-05','a','a','a','a','a','a','a','a','a','a','a','a','UPS','15.50','b','b','b','b','6666666666666','11/11','Visa','CA'),(1052,'j2ee','2019-10-05','a','a','a','a','a','a','a','a','a','a','a','a','UPS','15.50','b','b','b','b','6666666666666','11/11','Visa','CA'),(1053,'j2ee','2019-10-05','a','a','a','a','a','a','a','a','a','a','a','a','UPS','15.50','b','b','b','b','6666666666666','11/11','Visa','CA'),(1054,'j2ee','2019-10-05','a','a','a','a','a','a','a','a','a','a','a','a','UPS','125.50','b','b','b','b','6666666666666','11/11','Visa','CA'),(1055,'j2ee','2019-10-05','a','a','a','a','a','a','a','a','a','a','a','a','UPS','18.50','b','b','b','b','6666666666666','11/11','Visa','CA'),(1056,'j2ee','2019-10-05','a','a','a','a','a','a','a','a','a','a','a','a','UPS','193.50','b','b','b','b','6666666666666','11/11','Visa','CA'),(1057,'j2ee','2019-10-06','a','a','a','a','a','a','a','a','a','a','a','a','UPS','52.50','b','b','b','b','6666666666666','11/11','Visa','CA');

/*Table structure for table `orderstatus` */

DROP TABLE IF EXISTS `orderstatus`;

CREATE TABLE `orderstatus` (
  `orderid` int(11) NOT NULL,
  `linenum` int(11) NOT NULL,
  `timestamp` date NOT NULL,
  `status` varchar(2) NOT NULL,
  PRIMARY KEY (`orderid`,`linenum`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `orderstatus` */

insert  into `orderstatus`(`orderid`,`linenum`,`timestamp`,`status`) values (1004,1004,'2019-08-17','P'),(1005,1005,'2019-08-17','P'),(1006,1006,'2019-08-17','P'),(1007,1007,'2019-08-17','P'),(1008,1008,'2019-08-17','P'),(1009,1009,'2019-08-17','P'),(1010,1010,'2019-08-17','P'),(1011,1011,'2019-08-17','P'),(1012,1012,'2019-08-17','P'),(1013,1013,'2019-08-17','P'),(1014,1014,'2019-08-17','P'),(1020,1020,'2019-08-18','P'),(1021,1021,'2019-08-18','P'),(1022,1022,'2019-08-18','P'),(1023,1023,'2019-08-18','P'),(1024,1024,'2019-08-18','P'),(1025,1025,'2019-08-18','P'),(1026,1026,'2019-08-18','P'),(1027,1027,'2019-08-18','P'),(1028,1028,'2019-08-19','P'),(1029,1029,'2019-08-19','P'),(1030,1030,'2019-08-25','P'),(1031,1031,'2019-08-27','P'),(1032,1032,'2019-08-27','P'),(1033,1033,'2019-08-27','P'),(1034,1034,'2019-08-27','P'),(1035,1035,'2019-08-27','P'),(1036,1036,'2019-08-27','P'),(1037,1037,'2019-08-27','P'),(1038,1038,'2019-08-27','P'),(1039,1039,'2019-08-27','P'),(1040,1040,'2019-08-27','P'),(1041,1041,'2019-08-27','P'),(1042,1042,'2019-08-27','P'),(1043,1043,'2019-08-27','P'),(1044,1044,'2019-08-29','P'),(1045,1045,'2019-09-07','P'),(1046,1046,'2019-09-07','P'),(1047,1047,'2019-09-18','P'),(1048,1048,'2019-09-29','P'),(1049,1049,'2019-09-30','P'),(1050,1050,'2019-10-05','P'),(1051,1051,'2019-10-05','P'),(1052,1052,'2019-10-05','P'),(1053,1053,'2019-10-05','P'),(1054,1054,'2019-10-05','P'),(1055,1055,'2019-10-05','P'),(1056,1056,'2019-10-05','P'),(1057,1057,'2019-10-06','P');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `productid` varchar(10) NOT NULL,
  `category` varchar(10) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `descn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productid`) USING BTREE,
  KEY `productCat` (`category`) USING BTREE,
  KEY `productName` (`name`) USING BTREE,
  CONSTRAINT `fk_product_1` FOREIGN KEY (`category`) REFERENCES `category` (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `product` */

insert  into `product`(`productid`,`category`,`name`,`descn`) values ('AV-CB-01','BIRDS','Amazon Parrot','<image src=\"images/bird2.gif\">Great companion for up to 75 years'),('AV-SB-02','BIRDS','Finch','<image src=\"images/bird1.gif\">Great stress reliever'),('FI-FW-01','FISH','Koi','<image src=\"images/fish3.gif\">Fresh Water fish from Japan'),('FI-FW-02','FISH','Goldfish','<image src=\"images/fish2.gif\">Fresh Water fish from China'),('FI-SW-01','FISH','Angelfish','<image src=\"images/fish1.gif\">Salt Water fish from Australia'),('FI-SW-02','FISH','Tiger Shark','<image src=\"images/fish4.gif\">Salt Water fish from Australia'),('FL-DLH-02','CATS','Persian','<image src=\"images/cat1.gif\">Friendly house cat, doubles as a princess'),('FL-DSH-01','CATS','Manx','<image src=\"images/cat2.gif\">Great for reducing mouse populations'),('K9-BD-01','DOGS','Bulldog','<image src=\"images/dog2.gif\">Friendly dog from England'),('K9-CW-01','DOGS','Chihuahua','<image src=\"images/dog4.gif\">Great companion dog'),('K9-DL-01','DOGS','Dalmation','<image src=\"images/dog5.gif\">Great dog for a Fire Station'),('K9-PO-02','DOGS','Poodle','<image src=\"images/dog6.gif\">Cute dog from France'),('K9-RT-01','DOGS','Golden Retriever','<image src=\"images/dog1.gif\">Great family dog'),('K9-RT-02','DOGS','Labrador Retriever','<image src=\"images/dog5.gif\">Great hunting dog'),('RP-LI-02','REPTILES','Iguana','<image src=\"images/lizard1.gif\">Friendly green friend'),('RP-SN-01','REPTILES','Rattlesnake','<image src=\"images/snake1.gif\">Doubles as a watch dog');

/*Table structure for table `profile` */

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `userid` varchar(80) NOT NULL,
  `langpref` varchar(80) NOT NULL,
  `favcategory` varchar(30) DEFAULT NULL,
  `mylistopt` int(11) DEFAULT NULL,
  `banneropt` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `profile` */

insert  into `profile`(`userid`,`langpref`,`favcategory`,`mylistopt`,`banneropt`) values ('','japanese','CATS',NULL,NULL),('ACID','english','CATS',1,1),('j','english','FISH',NULL,NULL),('j2ee','english','DOGS',0,0),('x','english','FISH',NULL,NULL);

/*Table structure for table `sequence` */

DROP TABLE IF EXISTS `sequence`;

CREATE TABLE `sequence` (
  `name` varchar(30) NOT NULL,
  `nextid` int(11) NOT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `sequence` */

insert  into `sequence`(`name`,`nextid`) values ('ordernum',1058);

/*Table structure for table `signon` */

DROP TABLE IF EXISTS `signon`;

CREATE TABLE `signon` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `signon` */

insert  into `signon`(`username`,`password`) values ('',''),('ACID','ACID'),('j',''),('j2ee','j2ee'),('x','x');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `suppid` int(11) NOT NULL,
  `name` varchar(80) DEFAULT NULL,
  `status` varchar(2) NOT NULL,
  `addr1` varchar(80) DEFAULT NULL,
  `addr2` varchar(80) DEFAULT NULL,
  `city` varchar(80) DEFAULT NULL,
  `state` varchar(80) DEFAULT NULL,
  `zip` varchar(5) DEFAULT NULL,
  `phone` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`suppid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `supplier` */

insert  into `supplier`(`suppid`,`name`,`status`,`addr1`,`addr2`,`city`,`state`,`zip`,`phone`) values (1,'XYZ Pets','AC','600 Avon Way','','Los Angeles','CA','94024','212-947-0797'),(2,'ABC Pets','AC','700 Abalone Way','','San Francisco ','CA','94024','415-947-0797');

/*Table structure for table `syslog` */

DROP TABLE IF EXISTS `syslog`;

CREATE TABLE `syslog` (
  `username` varchar(64) DEFAULT NULL,
  `operation` varchar(64) DEFAULT NULL,
  `method` varchar(64) DEFAULT NULL,
  `params` varchar(64) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `syslog` */

insert  into `syslog`(`username`,`operation`,`method`,`params`,`createdate`,`ip`) values ('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-27','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-27','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-08-27','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-27','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-27','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-27','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-27','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-08-27','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-27','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-08-27','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-27','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-08-27','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-29','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-08-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-08-29','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-08-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-07','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-09-07','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-07','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-09-07','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-07','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-09-07','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-10','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-18','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-09-18','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-29','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-30','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-30','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-30','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-30','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-30','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-30','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-09-30','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-09-30','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-09-30','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-03','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-03','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-03','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-03','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-03','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-03','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-03','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-03','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-03','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-03','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-03','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-03','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-03','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-03','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-03','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-03','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-05','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-05','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-05','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-05','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-05','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-05','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-05','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-05','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-05','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-05','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-05','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-05','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-05','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-05','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-05','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-06','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-06','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-06','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-06','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-06','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-06','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-06','localhost'),('username','根据大类查询产品列表','getProductListByCategory','categoryId','2019-10-06','localhost'),('username','根据productID查询单一产品','getProduct','productId','2019-10-06','localhost');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
