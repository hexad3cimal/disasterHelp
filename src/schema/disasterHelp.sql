CREATE DATABASE  IF NOT EXISTS `disasterHelp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `disasterHelp`;
-- MySQL dump 10.13  Distrib 5.6.25, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: disasterHelp
-- ------------------------------------------------------
-- Server version	5.6.25-0ubuntu0.15.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aidAvailable`
--

DROP TABLE IF EXISTS `aidAvailable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aidAvailable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aidType` varchar(250) DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `isValid` int(11) DEFAULT NULL,
  `isInvalid` int(11) DEFAULT NULL,
  `disaster` int(11) DEFAULT NULL,
  `contactNo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_aidAvailable_1_idx` (`area`),
  KEY `fk_aidAvailable_2_idx` (`disaster`),
  CONSTRAINT `fk_aidAvailable_1` FOREIGN KEY (`area`) REFERENCES `area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aidAvailable_2` FOREIGN KEY (`disaster`) REFERENCES `disaster` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `aidNeeded`
--

DROP TABLE IF EXISTS `aidNeeded`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aidNeeded` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aidType` varchar(250) DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `isValid` int(11) DEFAULT NULL,
  `isInvalid` int(11) DEFAULT NULL,
  `disaster` int(11) DEFAULT NULL,
  `contactNo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_aidNeeded_1_idx` (`area`),
  KEY `fk_aidNeeded_2_idx` (`disaster`),
  CONSTRAINT `fk_aidNeeded_1` FOREIGN KEY (`area`) REFERENCES `area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_aidNeeded_2` FOREIGN KEY (`disaster`) REFERENCES `disaster` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `areaName` varchar(60) DEFAULT NULL,
  `disaster` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_area_1_idx` (`disaster`),
  CONSTRAINT `fk_area_1` FOREIGN KEY (`disaster`) REFERENCES `disaster` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `disaster`
--

DROP TABLE IF EXISTS `disaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disaster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `disasterName` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `groupby`
--

DROP TABLE IF EXISTS `groupby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groupby` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `helpline`
--

DROP TABLE IF EXISTS `helpline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helpline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `helplineno` varchar(45) DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `disaster_id` int(11) DEFAULT NULL,
  `isValid` int(11) DEFAULT NULL,
  `isInvalid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_helpline_1_idx` (`disaster_id`),
  KEY `fk_helpline_2_idx` (`area`),
  CONSTRAINT `fk_helpline_1` FOREIGN KEY (`disaster_id`) REFERENCES `disaster` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_helpline_2` FOREIGN KEY (`area`) REFERENCES `area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mainMenu`
--

DROP TABLE IF EXISTS `mainMenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mainMenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `link` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `subMenu`
--

DROP TABLE IF EXISTS `subMenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subMenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `link` varchar(150) DEFAULT NULL,
  `mainMenu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_subMenu_1_idx` (`mainMenu`),
  CONSTRAINT `fk_subMenu_1` FOREIGN KEY (`mainMenu`) REFERENCES `mainMenu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `volunteers`
--

DROP TABLE IF EXISTS `volunteers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volunteers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(100) DEFAULT NULL,
  `contactNo` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `disaster` int(11) DEFAULT NULL,
  `area` int(11) DEFAULT NULL,
  `isValid` int(11) DEFAULT NULL,
  `isInvalid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_volunteers_1_idx` (`disaster`),
  KEY `fk_volunteers_2_idx` (`area`),
  CONSTRAINT `fk_volunteers_1` FOREIGN KEY (`disaster`) REFERENCES `disaster` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_volunteers_2` FOREIGN KEY (`area`) REFERENCES `area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'disasterHelp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-11 13:13:39
