CREATE DATABASE  IF NOT EXISTS `lojadejogos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lojadejogos`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: lojadejogos
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `jogos`
--

DROP TABLE IF EXISTS `jogos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogos` (
  `idJogo` int NOT NULL AUTO_INCREMENT,
  `nomeJogo` varchar(45) DEFAULT NULL,
  `dataLancamento` date DEFAULT NULL,
  `desenvolvedora` varchar(60) DEFAULT NULL,
  `distribuidora` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`idJogo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogos`
--

LOCK TABLES `jogos` WRITE;
/*!40000 ALTER TABLE `jogos` DISABLE KEYS */;
INSERT INTO `jogos` VALUES (1,'Among Us','2018-06-15','Innersloth','Innersloth'),(2,'Minecraft','2011-11-18','Mojang Studios, ‪Double Eleven','Xbox Game Studios'),(3,'Red Dead Redemption','2010-05-18','Rockstar Games','Rockstar Games'),(4,'Red Dead Redemption 2','2018-10-24','Rockstar Games','Rockstar Games'),(5,'Grand Theft Auto V','2013-09-17','Rockstar North','Rockstar Games'),(6,'Stray','2022-07-19','BlueTwelve Studio','Annapurna Interactive'),(7,'ELDEN RING','2022-02-25','FromSoftware Inc.','FromSoftware Inc., Bandai Namco Entertainment'),(8,'The Elder Scrolls® Online','2014-04-04','ZeniMax Online Studios','Bethesda Softworks'),(9,'Terraria','2011-05-16','Re-Logic','Re-Logic'),(10,'Stardew Valley','2016-02-26','ConcernedApe','ConcernedApe'),(11,'Undertale','2015-09-15','tobyfox','tobyfox'),(12,'EA SPORTS™ FIFA 23','2022-10-01','EA Canada & EA Romania','Electronic Arts'),(13,'God of War','2018-04-20','Santa Monica Studio','PlayStation PC LLC'),(14,'God of War Ragnarok','2022-11-09','Santa Monica Studio','PlayStation PC LLC'),(15,'Assassins Creed® Odyssey','2017-10-27','Ubisoft Quebec,Ubisoft Montreal,Ubisoft Bucharest','Ubisoft'),(16,'Cyberpunk 2077','2020-12-10','CD PROJEKT RED','CD PROJEKT RED'),(17,'Dead by Daylight','2016-06-14','Behaviour Interactive Inc.','Behaviour Interactive Inc.'),(18,'The Witcher® 3: Wild Hunt','2015-05-18','CD PROJEKT RED','CD PROJEKT RED'),(19,'Mortal Kombat 11 Ultimate','2019-04-27','NetherRealm Studios, QLOC, Shiver','Warner Bros. Games, Warner Bros. Interactive Entertainment'),(20,'Minecraft Dungeons','2021-09-22','Mojang Studios, ‪Double Eleven','Xbox Game Studios');
/*!40000 ALTER TABLE `jogos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-13 11:06:31
