-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mobile
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `street_id` int NOT NULL,
  `house` varchar(25) NOT NULL,
  `flat` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `street_id` (`street_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`street_id`) REFERENCES `street` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calls`
--

DROP TABLE IF EXISTS `calls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calls` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `incoming_phone_number` tinyint NOT NULL,
  `outgoing_phone_number` tinyint NOT NULL,
  `duration` time NOT NULL,
  `tower_id` int NOT NULL,
  `status_code` smallint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `incoming_phone_number` (`incoming_phone_number`),
  KEY `outgoing_phone_number` (`outgoing_phone_number`),
  KEY `tower_id` (`tower_id`),
  KEY `status_code` (`status_code`),
  CONSTRAINT `calls_ibfk_1` FOREIGN KEY (`incoming_phone_number`) REFERENCES `subscriber` (`phone_number`),
  CONSTRAINT `calls_ibfk_2` FOREIGN KEY (`outgoing_phone_number`) REFERENCES `subscriber` (`phone_number`),
  CONSTRAINT `calls_ibfk_3` FOREIGN KEY (`tower_id`) REFERENCES `tower` (`id`),
  CONSTRAINT `calls_ibfk_4` FOREIGN KEY (`status_code`) REFERENCES `status` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calls`
--

LOCK TABLES `calls` WRITE;
/*!40000 ALTER TABLE `calls` DISABLE KEYS */;
/*!40000 ALTER TABLE `calls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(180) NOT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_type`
--

DROP TABLE IF EXISTS `client_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_type` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `type` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_type`
--

LOCK TABLES `client_type` WRITE;
/*!40000 ALTER TABLE `client_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `client_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `client_type_id` tinyint NOT NULL,
  `tariff_plan_id` int NOT NULL,
  `discount` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_type_id` (`client_type_id`),
  KEY `tariff_plan_id` (`tariff_plan_id`),
  CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`client_type_id`) REFERENCES `client_type` (`id`),
  CONSTRAINT `contract_ibfk_2` FOREIGN KEY (`tariff_plan_id`) REFERENCES `tariff_plan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `country` (`country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency` (
  `numerical_code` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `country_id` int NOT NULL,
  `code` varchar(25) NOT NULL,
  PRIMARY KEY (`numerical_code`),
  UNIQUE KEY `numerical_code` (`numerical_code`),
  UNIQUE KEY `code` (`code`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `currency_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mobile_operator`
--

DROP TABLE IF EXISTS `mobile_operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mobile_operator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `operator` varchar(45) NOT NULL,
  `code` int NOT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `mobile_operator_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mobile_operator`
--

LOCK TABLES `mobile_operator` WRITE;
/*!40000 ALTER TABLE `mobile_operator` DISABLE KEYS */;
/*!40000 ALTER TABLE `mobile_operator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passport`
--

DROP TABLE IF EXISTS `passport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passport` (
  `id_number` varchar(45) NOT NULL,
  `series_number` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `issuer` varchar(80) NOT NULL,
  PRIMARY KEY (`id_number`),
  UNIQUE KEY `id_number` (`id_number`),
  UNIQUE KEY `series_number` (`series_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passport`
--

LOCK TABLES `passport` WRITE;
/*!40000 ALTER TABLE `passport` DISABLE KEYS */;
/*!40000 ALTER TABLE `passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pricing_unit`
--

DROP TABLE IF EXISTS `pricing_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pricing_unit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unit` (`unit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricing_unit`
--

LOCK TABLES `pricing_unit` WRITE;
/*!40000 ALTER TABLE `pricing_unit` DISABLE KEYS */;
/*!40000 ALTER TABLE `pricing_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `code` smallint NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `street` (
  `id` int NOT NULL AUTO_INCREMENT,
  `street` varchar(50) NOT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `street_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
/*!40000 ALTER TABLE `street` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriber`
--

DROP TABLE IF EXISTS `subscriber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriber` (
  `phone_number` tinyint NOT NULL,
  `last_name` varchar(105) NOT NULL,
  `first_name` varchar(105) NOT NULL,
  `middle_name` varchar(105) DEFAULT NULL,
  `passport_id` varchar(45) NOT NULL,
  `address_id` int NOT NULL,
  `contract_id` int NOT NULL,
  `mobile_operator_id` int NOT NULL,
  `email` varchar(320) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`phone_number`),
  UNIQUE KEY `phone_number` (`phone_number`),
  UNIQUE KEY `passport_id` (`passport_id`),
  UNIQUE KEY `contract_id` (`contract_id`),
  UNIQUE KEY `email` (`email`),
  KEY `address_id` (`address_id`),
  KEY `mobile_operator_id` (`mobile_operator_id`),
  CONSTRAINT `subscriber_ibfk_1` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`id_number`),
  CONSTRAINT `subscriber_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `subscriber_ibfk_3` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`),
  CONSTRAINT `subscriber_ibfk_4` FOREIGN KEY (`mobile_operator_id`) REFERENCES `mobile_operator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriber`
--

LOCK TABLES `subscriber` WRITE;
/*!40000 ALTER TABLE `subscriber` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscriber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tariff_plan`
--

DROP TABLE IF EXISTS `tariff_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tariff_plan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `abonent_payment` int DEFAULT NULL,
  `pricing_unit_id` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `currency_numerical_code` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `pricing_unit_id` (`pricing_unit_id`),
  KEY `currency_numerical_code` (`currency_numerical_code`),
  CONSTRAINT `tariff_plan_ibfk_1` FOREIGN KEY (`pricing_unit_id`) REFERENCES `pricing_unit` (`id`),
  CONSTRAINT `tariff_plan_ibfk_2` FOREIGN KEY (`currency_numerical_code`) REFERENCES `currency` (`numerical_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tariff_plan`
--

LOCK TABLES `tariff_plan` WRITE;
/*!40000 ALTER TABLE `tariff_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `tariff_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tower`
--

DROP TABLE IF EXISTS `tower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tower` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location_city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `location_city_id` (`location_city_id`),
  CONSTRAINT `tower_ibfk_1` FOREIGN KEY (`location_city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tower`
--

LOCK TABLES `tower` WRITE;
/*!40000 ALTER TABLE `tower` DISABLE KEYS */;
/*!40000 ALTER TABLE `tower` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-22 21:30:02
