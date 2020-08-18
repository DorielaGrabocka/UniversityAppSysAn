-- MariaDB dump 10.17  Distrib 10.4.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: univerisityapp
-- ------------------------------------------------------
-- Server version	10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `StudentID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `Text` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1000,6,'Great course! Great instructor! Highly recommended.'),(2,1000,6,'When is the project deadline?'),(3,1001,11,'Hello class! When is the homework deadline?'),(4,1004,19,'What was the last lecture?'),(5,1008,5,'What is the homework for next time?\r\n'),(6,1001,17,'Very good course! Not difficult and beautiful!'),(7,1001,11,'Hello Class!'),(10,1000,6,'When is the midterm?'),(11,1000,17,'When is the homework deadline?');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `Instructor` varchar(255) NOT NULL,
  `Credits` int(2) NOT NULL,
  `Day` varchar(255) NOT NULL,
  `Time` varchar(255) NOT NULL,
  `Class` varchar(255) NOT NULL,
  `Department` varchar(255) NOT NULL,
  `Faculty` varchar(255) NOT NULL,
  `Eligibility` varchar(5) NOT NULL DEFAULT '-' COMMENT 'Who can take this course?',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Abnormal Psycology','Tony Adams',3,'Thursday','13:00-16:00','CoLAB','Psychology','Law & Social Sciences','-'),(2,'Advanced Accounting','Judy Wiliams',4,'Wednesday','13:00-16:00','LAB 2','Finance','Economy & Business','-'),(4,'Advanced Business English','Michele Herbert',3,'Tuesday','13:00-16:00','3F','Finance','Economy & Business','All'),(5,'Advanced Finance','Eda Stewart',3,'Friday','10:00-13:00','3F','Finance','Economy & Business','-'),(6,'Algorithms & Complexity','Edi Heisenhouer',3,'Monday','17:00-20:00','COLAB','Computer Science','Informatics','-'),(7,'Business Information Systems','Maria Curies',3,'Tuesday','13:00-16:00','3E','Computer Science','Informatics','-'),(8,'Business Policy','Ariana Smith',4,'Friday','09:00:13:00','1F','Business Administration','Economy & Business','-'),(9,'Calculus','Mira Tenant',4,'Wednesday','09:00-13:00','LAB 1','Computer Science','Informatics','-'),(10,'Calculus 2','Cathleen Robinson',4,'Monday','09:30-13:30','3E','Computer Science','Informatics','-'),(11,'Cognitive Psycology','Eni Barbarosa',4,'Tuesday','13:00-13:00','4','Psychology','Social Sciences','-'),(12,'Composition 2','Ovin Lancaster',3,'Wednesday','13:00-16:00','Theatre','Economy','Informatics','All'),(13,'Composition 2','Clarie Hoppkins',3,'Monday','13:00-16:00','1E','Economy','IT','All'),(14,'Computer Applications','Heiden Stallone',3,'Monday','13:00-16:00','LAB 2','Computer Science','Informatics','All'),(15,'Computer Operations and Security','Elian Roader',4,'Tuesday','13:30-17:30','LAB 3','Computer Science','Informatics','-'),(16,'Data Structures','Olgerta Heminguey',3,'Tuesday','09:00-12:00','LAB 3','Computer Science','Informatics','-'),(17,'Eastern Empires','Adam Ehrlich',3,'Monday','13:00-16:00','3E','Psychology','Law & Social Sciences','All'),(18,'Ecometrics','Jaiden Milwakee',4,'Monday','13:00-16:00','1F','Finance','Economy & Business','-'),(19,'College Algebra & Trigonometry','Dwein White',3,'Thursday ','12:00-15:00','1F','Mathematics','Mathematics','All'),(20,'Discrete Mathematics(Mathematics Only)','Dwein White',4,'Friday','15:00-19:00','3G','Mathematics','Informatics','-');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friendship`
--

DROP TABLE IF EXISTS `friendship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friendship` (
  `StudentID` int(11) NOT NULL,
  `FriendID` int(11) NOT NULL,
  PRIMARY KEY (`StudentID`,`FriendID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendship`
--

LOCK TABLES `friendship` WRITE;
/*!40000 ALTER TABLE `friendship` DISABLE KEYS */;
INSERT INTO `friendship` VALUES (1000,1003),(1000,1005),(1000,1006),(1001,1004),(1003,1000),(1003,1006),(1004,1001),(1005,1000),(1006,1000),(1006,1003),(1006,1005),(1008,1000),(1008,1007);
/*!40000 ALTER TABLE `friendship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Surname` varchar(255) NOT NULL,
  `Age` int(11) NOT NULL,
  `Major` varchar(255) NOT NULL,
  `Minor` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1000,'Doriela','Grabocka',21,'Computer Science','-','admin'),(1001,'Ann','Tomson',20,'Psychology','-','admin'),(1003,'Helen','Herbert',21,'Computer Science','-','admin'),(1004,'Mark','Smith',19,'Psychology','-','admin'),(1005,'Steven','Holland',18,'Mathematics','Computer Science','steven'),(1006,'Oliver','Khan',22,'Computer Science','Mathematics','oliver'),(1007,'Ann','Williamson',19,'Business Administration','Marketing','anna'),(1008,'William','Tennison',22,'Finance','Business Administration','willy');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentcourse`
--

DROP TABLE IF EXISTS `studentcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentcourse` (
  `StudentID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  PRIMARY KEY (`StudentID`,`CourseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentcourse`
--

LOCK TABLES `studentcourse` WRITE;
/*!40000 ALTER TABLE `studentcourse` DISABLE KEYS */;
INSERT INTO `studentcourse` VALUES (1000,6),(1000,10),(1000,16),(1000,17),(1001,1),(1001,11),(1001,17),(1001,19),(1003,6),(1003,7),(1003,10),(1003,12),(1004,13),(1004,14),(1004,17),(1004,19),(1005,14),(1005,17),(1005,19),(1005,20),(1006,17),(1006,19),(1006,20),(1007,8),(1007,17),(1008,2),(1008,4),(1008,5),(1008,18);
/*!40000 ALTER TABLE `studentcourse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-12 11:32:46
