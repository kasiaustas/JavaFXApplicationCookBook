-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: localhost    Database: cook
-- ------------------------------------------------------
-- Server version	5.7.24-log

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Cake Recipes'),(2,'Bread Recipes'),(3,'Appetizers & Snacks'),(4,'Candy and Fudge'),(5,'Salads');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET latin1 NOT NULL,
  `image` text CHARACTER SET latin1,
  `description` text CHARACTER SET latin1 NOT NULL,
  `importantText` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `category` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `data_create` datetime DEFAULT NULL,
  `creator` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`creator`),
  CONSTRAINT `id` FOREIGN KEY (`creator`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (50,'sfsf','C:\\Users\\Kasia\\Documents\\NetBeansProjects\\JavaFXApplicationFX\\src\\assets\\recipe\\sfsBass-05-LG.jpg','sddfsdfs','asdadsad','2',NULL,1),(51,'sfsf','C:\\Users\\Kasia\\Documents\\NetBeansProjects\\JavaFXApplicationFX\\src\\assets\\recipe\\sfsBass-05-LG.jpg','sddfsdfs','asdadsad','2',NULL,1),(52,'sfsf','C:\\Users\\Kasia\\Documents\\NetBeansProjects\\JavaFXApplicationFX\\src\\assets\\recipe\\sfsBass-05-LG.jpg','sddfsdfs','asdadsad','2',NULL,1),(53,'sfsf','C:\\Users\\Kasia\\Documents\\NetBeansProjects\\JavaFXApplicationFX\\src\\assets\\recipe\\sfsBass-05-LG.jpg','sddfsdfs','asdadsad','2',NULL,1),(54,'sfsf','C:\\Users\\Kasia\\Documents\\NetBeansProjects\\JavaFXApplicationFX\\src\\assets\\recipe\\sfsBass-05-LG.jpg','sddfsdfs','asdadsad','2',NULL,1),(55,'uuu','C:\\Users\\Kasia\\Documents\\NetBeansProjects\\JavaFXApplicationFX\\src\\assets\\recipe\\uuus-l300.jpg','uuuuu','uuuu','2',NULL,1);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Kate','Razhkova','kasiaustas','123456','Norway','Male'),(2,'Kat','Astapenko','kat','123456','Norway','Female'),(3,'Kat','Astapenko','kat','123456','Norway','Female'),(4,'????','???????','123456','123456','????????','Female'),(5,'kate','rozh','123456','123456','Belarus','Female'),(6,'kate','rozh','123456','123456','Belarus','Female'),(7,'kate','rozh','123456','123456','Belarus','Female'),(8,'kate','rozh','123456','123456','Belarus','Female'),(9,'kate','rozh','123456','123456','Belarus','Female'),(10,'kate','rozh','123456','123456','Belarus','Female'),(11,'kate','rozh','123456','123456','Belarus','Female'),(12,'kate','rozh','123456','123456','Belarus','Female'),(13,'kate','rozh','123456','123456','Belarus','Female'),(14,'kate','rozh','123456','123456','Belarus','Female'),(15,'kate','rozh','123456','123456','Belarus','Female'),(16,'tertert','ertet','erte','erte','retet','Female');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cook'
--

--
-- Dumping routines for database 'cook'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 20:54:53
