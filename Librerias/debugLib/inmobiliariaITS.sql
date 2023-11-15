-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: inmobiliariaits
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `CI` int NOT NULL,
  `NombreCompleto` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `FechaNac` date DEFAULT NULL,
  `Email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `tipoCliente` int DEFAULT NULL,
  PRIMARY KEY (`CI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (45227453,'Luis Nantes ','1991-05-07','nantesluis72@gmail.com',92094988,1),(48830732,'Natalia Silva','1995-03-01','nati.silva.26.03.95@gmail.com',92095992,2);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `NroContrato` int NOT NULL,
  `FechaInicial` date DEFAULT NULL,
  `FechaFinal` date DEFAULT NULL,
  `Garantia` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `Autorizacion` int DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `desc` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  `cliente` int DEFAULT NULL,
  PRIMARY KEY (`NroContrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (1234,'2023-11-01','2023-11-30','Deposito',0,123,'UPDATE',1,45227453),(789456,'2023-11-01','2023-11-01','Santander',1,15000,'sdf',0,45227453),(789654,'2023-12-01','2023-12-31','Anda',0,1,'update',1,48830732);
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitable`
--

DROP TABLE IF EXISTS `habitable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitable` (
  `NroPadron` int NOT NULL,
  `CantCuarto` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CantBano` int DEFAULT NULL,
  `OtrosHabitaciones` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `comodidades` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tipo` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`NroPadron`),
  KEY `NroPadron_idx` (`NroPadron`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitable`
--

LOCK TABLES `habitable` WRITE;
/*!40000 ALTER TABLE `habitable` DISABLE KEYS */;
INSERT INTO `habitable` VALUES (45,'1',1,'1','sd','Casa'),(777,'3',3,'1','balcon','Apartamento'),(987,'1',7,'1','garage,picina','Mejora');
/*!40000 ALTER TABLE `habitable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inmueble` (
  `NroPadron` int NOT NULL,
  `calle` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nroPuerta` int DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `tamanio` double DEFAULT NULL,
  `departamento` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cliente` int DEFAULT NULL,
  PRIMARY KEY (`NroPadron`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmueble`
--

LOCK TABLES `inmueble` WRITE;
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
INSERT INTO `inmueble` VALUES (546,'San Martin',789,450,120.2,'Durazno',45227453),(777,'Boulevar Artigas',77789,77777,77,'Montevideo',45227453),(897,'artigas',234,2333333,333,'Artigas',45227453);
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terreno`
--

DROP TABLE IF EXISTS `terreno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `terreno` (
  `NroPadron` int NOT NULL,
  `servicios` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`NroPadron`),
  CONSTRAINT `NroPadron` FOREIGN KEY (`NroPadron`) REFERENCES `inmueble` (`NroPadron`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terreno`
--

LOCK TABLES `terreno` WRITE;
/*!40000 ALTER TABLE `terreno` DISABLE KEYS */;
INSERT INTO `terreno` VALUES (897,'ose,');
/*!40000 ALTER TABLE `terreno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL,
  `NombreUsuario` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `PassUsuario` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `RolUsuario` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Luis Nantes','123',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-15  1:02:44
