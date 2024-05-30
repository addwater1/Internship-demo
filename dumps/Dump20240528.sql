-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: sheetdb
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `daily_report_table`
--

DROP TABLE IF EXISTS `daily_report_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `daily_report_table` (
  `report_id` varchar(45) NOT NULL,
  `user_id` int NOT NULL,
  `report_date` varchar(45) NOT NULL,
  `checkin_time` time DEFAULT NULL,
  `checkout_time` time DEFAULT NULL,
  `break_time` int DEFAULT NULL,
  `absence_day` int DEFAULT NULL,
  `rest_day` int DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `work_site` varchar(45) DEFAULT NULL,
  `departure_place` varchar(45) DEFAULT NULL,
  `destination_place` varchar(45) DEFAULT NULL,
  `route_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_report_table`
--

LOCK TABLES `daily_report_table` WRITE;
/*!40000 ALTER TABLE `daily_report_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_report_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_table` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (1,'WangPeiJun','e10adc3949ba59abbe56e057f20f883e'),(2,'Matono Mio','508df4cb2f4d8f80519256258cfb975f'),(3,'Yamashita Shizuki','$2a$10$UB2JYazJGm6kLdUfjrerdOgdohyOcDqDqF1Q6vSFp5jzQmiybbkSy'),(4,'Taniguchi Airi','$2a$10$vnplq1i.4Rcxf7CjO4Ad5.nSg2IfWggET/8STZ.NfhuCNeakGzxe6'),(5,'Ishimori Rika','$2a$10$QFI20J65J/GpOIxo9Agb1.3tZ6SuzzGU14aXQs54aWRiAbfFN26za'),(6,'Endo Riko','$2a$10$CVkKx03paObC8UPMK5WoVeeoeThHwoeQUxLluBqRy.Rj5HnjYOnOq'),(7,'Odakura Reina','$2a$10$ZXKDoMtn9tFntBjcPx71gesF8FePmiGomg5y4WnSEpiS9cToVeoPK'),(8,'Murai Yu','$2a$10$mZQFBnNTDbyWEMDYAAyQD.SjVZq3CWdZ4p6FQUY5ZvPya3jATGNFS'),(9,'Mukai Itoha','$2a$10$D0V8AWfUIlNOIoUjkp4Y4u5wsXdUnVIx2nFxLzCQ9E86lYkUblj/K'),(10,'Murayama Miyu','$2a$10$vbpmlkd/pFlVX1zELb7uuedEdidl05Yqvcmre5jx0ui0QVnSiuMpO');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-28 11:46:22
