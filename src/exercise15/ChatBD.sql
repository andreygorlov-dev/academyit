-- MySQL dump 10.13  Distrib 5.6.38, for Win32 (AMD64)
--
-- Host: localhost    Database: ChatBD
-- ------------------------------------------------------
-- Server version	5.6.38

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
-- Current Database: `ChatBD`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ChatBD` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ChatBD`;

--
-- Table structure for table `ADMINISTRATION_TABLE`
--

DROP TABLE IF EXISTS `ADMINISTRATION_TABLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ADMINISTRATION_TABLE` (
  `GROUP_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  KEY `GROUP_ID` (`GROUP_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `administration_table_ibfk_1` FOREIGN KEY (`GROUP_ID`) REFERENCES `GROUPS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `administration_table_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADMINISTRATION_TABLE`
--

LOCK TABLES `ADMINISTRATION_TABLE` WRITE;
/*!40000 ALTER TABLE `ADMINISTRATION_TABLE` DISABLE KEYS */;
INSERT INTO `ADMINISTRATION_TABLE` VALUES (2,2),(3,4),(1,3),(5,2);
/*!40000 ALTER TABLE `ADMINISTRATION_TABLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GROUPS`
--

DROP TABLE IF EXISTS `GROUPS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GROUPS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(2000) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GROUPS`
--

LOCK TABLES `GROUPS` WRITE;
/*!40000 ALTER TABLE `GROUPS` DISABLE KEYS */;
INSERT INTO `GROUPS` VALUES (1,'╨Я╤А╨╛╨│╤А╨░╨╝╨╝╨╕╤Б╤В╤Л'),(2,'╨Р╨┤╨╝╨╕╨╜╤Л'),(3,'╨Р╨╜╨░╨╗╨╕╤В╨╕╨║╨╕'),(4,'╨б╨╛╨┐╤А╨╛╨▓╨╛╨╢╨┤╨╡╨╜╨╕╨╡'),(5,'╨Ф╨╕╨╖╨░╨╣╨╜╨╡╤А╤Л');
/*!40000 ALTER TABLE `GROUPS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MESSAGES`
--

DROP TABLE IF EXISTS `MESSAGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MESSAGES` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEXT_MESSAGE` varchar(2000) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `TOPIC_ID` int(11) NOT NULL,
  `DATE_TIME_MESSAGE` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `TOPIC_ID` (`TOPIC_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`TOPIC_ID`) REFERENCES `TOPICS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `USERS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MESSAGES`
--

LOCK TABLES `MESSAGES` WRITE;
/*!40000 ALTER TABLE `MESSAGES` DISABLE KEYS */;
INSERT INTO `MESSAGES` VALUES (1,'╨г╤А╨╛╨║ ╨▒╤Г╨┤╨╡╤В ╨╖╨░╨▓╤В╤А╨░ ╨▓ 22:00',3,5,'2022-07-13 09:15:12'),(2,'╨╛╨║',2,5,'2022-07-13 10:00:00');
/*!40000 ALTER TABLE `MESSAGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TOPICS`
--

DROP TABLE IF EXISTS `TOPICS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TOPICS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(100) NOT NULL,
  `GROUP_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `GROUP_ID` (`GROUP_ID`),
  CONSTRAINT `topics_ibfk_1` FOREIGN KEY (`GROUP_ID`) REFERENCES `GROUPS` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TOPICS`
--

LOCK TABLES `TOPICS` WRITE;
/*!40000 ALTER TABLE `TOPICS` DISABLE KEYS */;
INSERT INTO `TOPICS` VALUES (1,'╨Я╨╛╨┤╨╜╤П╤В╨╕╨╡ ╤Б╨╡╤А╨▓╨╡╤А╨░',2),(2,'╨Я╨╛╨┤╨╜╤П╤В╨╕╨╡ ╤Б╨╡╤А╨▓╨╡╤А╨░',2),(3,'╨г╤Б╤В╨░╨╜╨╛╨▓╨║╨░ KAFKA',2),(4,'╨Ю╨б Linux',2),(5,'╨Ш╨╖╤Г╤З╨╡╨╜╨╕╨╡ Spring',1);
/*!40000 ALTER TABLE `TOPICS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `LOGIN` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` VALUES (1,'╨Ш╨▓╨░╨╜╨╛╨▓ ╨Ш╨▓╨░╨╜ ╨Ш╨▓╨░╨╜╨╛╨▓╨╕╤З','IVANOV_RU','RU_IVANOV'),(2,'╨Я╨╡╤В╤А╨╛╨▓ ╨Я╤С╤В╤А ╨Я╨╡╤В╤А╨╛╨▓╨╕╤З','PETROV_RU','RU_PETROV'),(3,'╨б╨╡╨╝╤С╨╜╨╛╨▓ ╨Я╤С╤В╤А ╨Я╨╡╤В╤А╨╛╨▓╨╕╤З','SEMENOV','SEMENOV'),(4,'╨г╨╗╤М╤П╨╜╨╛╨▓╨░ ╨Ш╤А╨╕╨╜╨░ ╨Т╨╕╨║╤В╨╛╤А╨╛╨▓╨╜╨░','╨г╨╗╤М╤П╨╜╨╛╨▓╨░','╨г╨╗╤М╤П╨╜╨╛╨▓╨░'),(5,'╨Р╨╜╨╛╨╜╨╕╨╝','ANON','ANON');
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-23  0:19:59
