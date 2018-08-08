-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema deduplication_bigdata
--

CREATE DATABASE IF NOT EXISTS deduplication_bigdata;
USE deduplication_bigdata;

--
-- Definition of table `files`
--

DROP TABLE IF EXISTS `files`;
CREATE TABLE `files` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `filename` varchar(455) NOT NULL,
  `file` varchar(455) NOT NULL,
  `filekey` varchar(455) NOT NULL,
  `hashcode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `files`
--

/*!40000 ALTER TABLE `files` DISABLE KEYS */;
INSERT INTO `files` (`id`,`filename`,`file`,`filekey`,`hashcode`) VALUES 
 (1,'aa.txt','Julie loves me more than Linda loves me','0PCSXEXW2F','c2a97be46400ff3b5eaabf79356916af');
/*!40000 ALTER TABLE `files` ENABLE KEYS */;


--
-- Definition of table `keydetails`
--

DROP TABLE IF EXISTS `keydetails`;
CREATE TABLE `keydetails` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `filename` varchar(45) NOT NULL,
  `filekey` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `keydetails`
--

/*!40000 ALTER TABLE `keydetails` DISABLE KEYS */;
INSERT INTO `keydetails` (`id`,`email`,`filename`,`filekey`) VALUES 
 (1,'sonalimitkari05@gmail.com','aa.txt','84VRKCH5O7');
/*!40000 ALTER TABLE `keydetails` ENABLE KEYS */;


--
-- Definition of table `tbl_ap`
--

DROP TABLE IF EXISTS `tbl_ap`;
CREATE TABLE `tbl_ap` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_ap`
--

/*!40000 ALTER TABLE `tbl_ap` DISABLE KEYS */;
INSERT INTO `tbl_ap` (`id`,`username`,`password`) VALUES 
 (1,'ap@gmail.com','ap123');
/*!40000 ALTER TABLE `tbl_ap` ENABLE KEYS */;


--
-- Definition of table `tbl_csp`
--

DROP TABLE IF EXISTS `tbl_csp`;
CREATE TABLE `tbl_csp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_csp`
--

/*!40000 ALTER TABLE `tbl_csp` DISABLE KEYS */;
INSERT INTO `tbl_csp` (`id`,`email`,`password`) VALUES 
 (1,'csp@gmail.com','csp123');
/*!40000 ALTER TABLE `tbl_csp` ENABLE KEYS */;


--
-- Definition of table `tbl_dataholder`
--

DROP TABLE IF EXISTS `tbl_dataholder`;
CREATE TABLE `tbl_dataholder` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `mobileno` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `dob` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_dataholder`
--

/*!40000 ALTER TABLE `tbl_dataholder` DISABLE KEYS */;
INSERT INTO `tbl_dataholder` (`id`,`name`,`email`,`password`,`mobileno`,`gender`,`dob`,`address`,`status`) VALUES 
 (3,'sonali mitkari','sonalimitkari05@gmail.com','Sonali123','9876543111','FeMale','2018-02-27','pune','Active');
/*!40000 ALTER TABLE `tbl_dataholder` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
