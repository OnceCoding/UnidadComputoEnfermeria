-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: bdcomputo
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Current Database: `bdcomputo`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bdcomputo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bdcomputo`;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `codigo` tinyint(4) NOT NULL,
  `user` varchar(30) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `nombreCompleto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'admin','admin','registro',''),(2,'admin','123','computo','José Chanduvi Asmat'),(3,'admin','admin','simulacion',NULL),(4,'admin','admin','biblioteca',NULL);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computadora`
--

DROP TABLE IF EXISTS `computadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `computadora` (
  `codigo` int(11) NOT NULL,
  `estado` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computadora`
--

LOCK TABLES `computadora` WRITE;
/*!40000 ALTER TABLE `computadora` DISABLE KEYS */;
INSERT INTO `computadora` VALUES (1,'Disponible'),(2,'Disponible'),(3,'Disponible'),(4,'Disponible'),(5,'Disponible'),(6,'Disponible'),(7,'Disponible'),(8,'Disponible'),(9,'Disponible'),(10,'Disponible'),(11,'Disponible'),(12,'Disponible'),(13,'Disponible'),(14,'Disponible'),(15,'Disponible'),(16,'Disponible'),(17,'Disponible'),(18,'Disponible'),(19,'Disponible'),(20,'Disponible'),(21,'Disponible'),(22,'Disponible'),(23,'Disponible'),(24,'Disponible'),(25,'Disponible'),(26,'Disponible'),(27,'Disponible'),(28,'Disponible'),(29,'Disponible'),(30,'Disponible'),(31,'Disponible'),(32,'Disponible');
/*!40000 ALTER TABLE `computadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contadorregistro`
--

DROP TABLE IF EXISTS `contadorregistro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contadorregistro` (
  `codigo` tinyint(4) NOT NULL,
  `tipo` varchar(10) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contadorregistro`
--

LOCK TABLES `contadorregistro` WRITE;
/*!40000 ALTER TABLE `contadorregistro` DISABLE KEYS */;
INSERT INTO `contadorregistro` VALUES (1,'usuario',34),(2,'historial',9);
/*!40000 ALTER TABLE `contadorregistro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger cursosEliminados before delete on curso for each row
	begin
		insert into cursoEliminado values(old.codigo,old.nombre);
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `cursoeliminado`
--

DROP TABLE IF EXISTS `cursoeliminado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursoeliminado` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursoeliminado`
--

LOCK TABLES `cursoeliminado` WRITE;
/*!40000 ALTER TABLE `cursoeliminado` DISABLE KEYS */;
INSERT INTO `cursoeliminado` VALUES (1,'OFIMÁTICA');
/*!40000 ALTER TABLE `cursoeliminado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codUsuario` int(11) DEFAULT NULL,
  `codPC` int(11) DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `indexFecha` (`fecha`),
  KEY `indexCodUsuario` (`codUsuario`),
  CONSTRAINT `registro_ibfk_1` FOREIGN KEY (`codUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `registro` VALUES (1,1,15,'12:05:36','12:23:02','2017-05-02'),(2,3,15,'13:01:02','13:23:58','2017-05-02'),(3,4,14,'10:52:03','11:12:56','2017-05-03'),(4,5,15,'12:09:57','12:33:42','2017-05-03'),(5,6,25,'14:03:45','14:59:39','2017-05-08'),(6,4,8,'13:27:35','13:31:03','2017-05-10'),(7,6,1,'11:40:00','14:00:00','2017-05-22'),(8,34,2,'13:29:23','13:29:53','2017-08-14'),(9,34,3,'13:30:16','13:30:49','2017-08-14');
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger aumentarContadorHistorialRegistro after insert on registro for each row
	begin
		declare cantidadNueva int;
        declare cantActual int;
		select cantidad into cantActual from contadorRegistro where tipo = 'historial';
        set cantidadNueva = cantActual + 1;
		update contadorRegistro set cantidad = cantidadNueva where tipo = 'historial';
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger registrosEliminados before delete on registro for each row
	begin
		insert into registroEliminado values(old.codigo,old.codUsuario,old.codPC,old.horaInicio,old.horaFin,old.fecha);
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger disminuirContadorHistorialRegistro after delete on registro for each row
	begin
		declare cantidadNueva int;
        declare cantActual int;
		select cantidad into cantActual from contadorRegistro where tipo = 'historial';
        set cantidadNueva = cantActual - 1;
		update contadorRegistro set cantidad = cantidadNueva where tipo = 'historial';
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `registrocurso`
--

DROP TABLE IF EXISTS `registrocurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrocurso` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codCurso` int(11) DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `codCurso` (`codCurso`),
  CONSTRAINT `registrocurso_ibfk_1` FOREIGN KEY (`codCurso`) REFERENCES `curso` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrocurso`
--

LOCK TABLES `registrocurso` WRITE;
/*!40000 ALTER TABLE `registrocurso` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrocurso` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger registroCursosEliminados before delete on registrocurso for each row
	begin
		insert into registroCursoEliminado values(old.codigo,old.codCurso,old.horaInicio,old.horaFin,old.fecha);
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `registrocursoeliminado`
--

DROP TABLE IF EXISTS `registrocursoeliminado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrocursoeliminado` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codCurso` int(11) DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrocursoeliminado`
--

LOCK TABLES `registrocursoeliminado` WRITE;
/*!40000 ALTER TABLE `registrocursoeliminado` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrocursoeliminado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrocursotemporal`
--

DROP TABLE IF EXISTS `registrocursotemporal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrocursotemporal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codCurso` int(11) DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrocursotemporal`
--

LOCK TABLES `registrocursotemporal` WRITE;
/*!40000 ALTER TABLE `registrocursotemporal` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrocursotemporal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registroeliminado`
--

DROP TABLE IF EXISTS `registroeliminado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registroeliminado` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codUsuario` int(11) DEFAULT NULL,
  `codPC` int(11) DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registroeliminado`
--

LOCK TABLES `registroeliminado` WRITE;
/*!40000 ALTER TABLE `registroeliminado` DISABLE KEYS */;
/*!40000 ALTER TABLE `registroeliminado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrotemporal`
--

DROP TABLE IF EXISTS `registrotemporal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrotemporal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codUsuario` int(11) DEFAULT NULL,
  `codPC` int(11) DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `codUsuario` (`codUsuario`),
  CONSTRAINT `registrotemporal_ibfk_1` FOREIGN KEY (`codUsuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrotemporal`
--

LOCK TABLES `registrotemporal` WRITE;
/*!40000 ALTER TABLE `registrotemporal` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrotemporal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(11) DEFAULT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(70) DEFAULT NULL,
  `tipo` varchar(12) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigoUsuario` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'1070900114','CLAUDIA GABRIELA','NUNTON RIOS','cnuntonr@hotmail.com','Estudiante','2017-05-02','12:04:42'),(2,'1020900714','SHEYLA JANETH ','NEYRA LOPEZ','sheylaneyra15@gmail.com','Estudiante','2017-05-02','12:09:04'),(3,'1010901214','NATALI MILAGROS ','GARCIA RODRIGUEZ',' nataligarciar10@gmail.com','Estudiante','2017-05-02','13:00:12'),(4,'4198','NORA','VARGAS CASTAÑEDA','noravargas@gmail.com','Docente','2017-05-03','10:51:18'),(5,'5665','MAGALY','COLLAVE SALAS','magalycollave@hotmail.com','Docente','2017-05-03','12:09:40'),(6,'1050901614','LEYDI VANESSA','DIAZ SANDOVAL','banesa2007@hotmail.com','Estudiante','2017-05-08','14:02:04'),(7,'1020901517','ROCIO ','RODRIGUEZ GONZALES','enf.rociorg@gmail.com','Estudiante','2017-05-23','12:48:00'),(8,'1510901617','MARTHA','ORTECHO BARROS','marthamariluzortechobarros97@gmail.com','Estudiante','2017-05-23','12:49:14'),(9,'1510900816','STEFANY','ROJAS DAVALOS','stefany_cancer_14@hotmail.com','Estudiante','2017-05-23','12:50:11'),(10,'1050902317','ESTEFANNY DALILA','RAMOS CAMPOS','ESTEFANNYDALILA@HOTMAIL.COM','Estudiante','2017-05-24','12:42:03'),(11,'1510901017','ALEXANDRA PATRICIA','RODRIGUEZ MINCHOLA','ROMI.1970@HOTMAIL.COM','Estudiante','2017-05-24','12:42:42'),(12,'1010900517','VALERIA','YATACO','merly_ely@hotmail.com','Estudiante','2017-05-24','12:44:58'),(13,'1510901217','LUCIANA','PAREDES SANCHEZ','luciana12261913@gmail.com','Estudiante','2017-05-24','12:45:50'),(14,'1510901415','MIREYA','SÁNCHEZ TELLO','anel18.12@hotmail.com','Estudiante','2017-05-24','12:46:51'),(15,'1050900617','HELY ALONSO','VALDERRAMA LEÓN','helyvalderrama@gmail.com','Estudiante','2017-05-24','12:48:20'),(16,'1010900116','FIORELA INDIRA','CABRERA PONCE','fiorela_fj7@hotmail.com','Estudiante','2017-05-24','13:58:16'),(17,'1510901316','MARIA DE LOS ANGELES','CIPRIANO CASTILLO','angeles_09_11@hotmail.com','Estudiante','2017-05-24','13:58:54'),(18,'1020900916','LUSMARVI','MONTENEGRO SALAZAR','montenegrosalazar.28@hotmail.com','Estudiante','2017-05-24','13:59:49'),(19,'1020900917','CAROLINE','RIVERA GALLARDO','carc_2804@hotmail.com','Estudiante','2017-05-24','14:05:59'),(20,'1020900915','DEISI NATHALY','PLASENCIA VILCARROMERO','deisi_aries96@hotmail.com','Estudiante','2017-05-25','08:11:12'),(21,'2200901411','ESTER','JULCA SANDOVAL','estercita_9011@hotmail.com','Estudiante','2017-05-25','09:31:44'),(22,'2210900812','VILMA GIOVANNA','VASQUEZ FLORES','giovanna_libra_23@hotmail.com','Estudiante','2017-05-25','10:10:41'),(23,'1010901217','MILAGROS ','CUEVA VALENCIA','miliruth46@gmail.com','Estudiante','2017-05-25','10:22:32'),(24,'1530900517','NATALY','LAYZA BOCANEGRA','nathaly_tauro_15@hotmail.com','Estudiante','2017-05-25','10:23:33'),(25,'2270901714','LAURA PATRICIA','CAMPOS VEINTEMILLA','laura27.cv@hotmail.com','Estudiante','2017-05-26','11:55:05'),(26,'2270900914','LUCERO','BORJAS ALDAMAS','lu.190512@gmail.com','Estudiante','2017-05-26','11:56:18'),(27,'1510901016','LAURA NOELIA','ORDOÑEZ SGÁSTEGUI ','sagasteguilaura1996@hotmail.com','Estudiante','2017-06-02','11:45:50'),(28,'1010900316','ALEXANDRA JOHANNA','MARQUINA CALDERON','aleemarquina02@gmail.com','Estudiante','2017-06-02','11:46:58'),(29,'1010901216','BRAYAN','TERRONES MENDOZA ','raperozi24@gmail.com','Estudiante','2017-07-25','08:37:04'),(30,'1030900116','ESMERALDA','GAVIDIA MARQUINA ','esmitagm@gmail.com','Estudiante','2017-07-25','08:40:14'),(31,'1050902217','JOSELYN','MONZON MALCA','joselyn_05@outlook.es','Estudiante','2017-07-25','10:12:26'),(32,'1050901716','ESTELITA DE JESUS','ESCOBAL MINCHOLA ','estelita_acuario24@hotmail.com','Estudiante','2017-07-25','11:01:38'),(33,'1020900416','JEYZI ARACELI','HORNA ROSARIO','jeyzihr.1998@gmail.com','Estudiante','2017-07-25','11:02:36'),(34,'1050901316','LUZ CLARITA ','MORENO FLORES','luz_cielito_fm@hotmail.com','Estudiante','2017-08-04','13:14:51');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger aumentarContadorUsuarioRegistro after insert on usuario for each row
	begin
		declare cantidadNueva int;
        declare cantActual int;
		select cantidad into cantActual from contadorRegistro where tipo = 'usuario';
        set cantidadNueva = cantActual + 1;
		update contadorRegistro set cantidad = cantidadNueva where tipo = 'usuario';
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger usuariosEliminados before delete on usuario for each row
	begin
		insert into usuarioEliminado values(old.id,old.codigo,old.nombre,old.apellido,old.correo,old.tipo,old.fecha,old.hora);
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger disminuirContadorUsuarioRegistro after delete on usuario for each row
	begin
		declare cantidadNueva int;
        declare cantActual int;
		select cantidad into cantActual from contadorRegistro where tipo = 'usuario';
        set cantidadNueva = cantActual - 1;
		update contadorRegistro set cantidad = cantidadNueva where tipo = 'usuario';
    end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `usuarioeliminado`
--

DROP TABLE IF EXISTS `usuarioeliminado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarioeliminado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(11) DEFAULT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(70) DEFAULT NULL,
  `tipo` varchar(12) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioeliminado`
--

LOCK TABLES `usuarioeliminado` WRITE;
/*!40000 ALTER TABLE `usuarioeliminado` DISABLE KEYS */;
INSERT INTO `usuarioeliminado` VALUES (7,'1512701214','ANGIE PAMELA','QUISPE RAMIREZ','angy-22@hotmail.com','Estudiante','2017-05-10','13:18:54');
/*!40000 ALTER TABLE `usuarioeliminado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-14 13:59:49
