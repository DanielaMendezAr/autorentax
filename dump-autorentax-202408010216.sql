-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: autorentax
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `number_phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_phone_unique` (`number_phone`),
  UNIQUE KEY `email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Rosa','Pulido Pérez','+552934719313','rosita89pp@hotmail.com'),(2,'Vladimir','López González','+522284737127','vlad.lop_glz@gmail.com'),(7,'Sofía','Valparaiso','+522938271839','');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKpnvtwliis6p05pn6i3ndjrqt2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rents_vehicles`
--

DROP TABLE IF EXISTS `rents_vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rents_vehicles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` bigint(20) NOT NULL,
  `vehicle_id` bigint(20) NOT NULL,
  `order_date` datetime NOT NULL,
  `rental_time` time NOT NULL,
  `status_id` bigint(20) NOT NULL,
  `initial_date` datetime NOT NULL,
  `final_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rents_clients_FK` (`client_id`),
  KEY `rents_vehicles_FK` (`vehicle_id`),
  KEY `rents_status_FK` (`status_id`),
  CONSTRAINT `rents_clients_FK` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  CONSTRAINT `rents_status_FK` FOREIGN KEY (`status_id`) REFERENCES `status_rents` (`id`),
  CONSTRAINT `rents_vehicles_FK` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rents_vehicles`
--

LOCK TABLES `rents_vehicles` WRITE;
/*!40000 ALTER TABLE `rents_vehicles` DISABLE KEYS */;
INSERT INTO `rents_vehicles` VALUES (1,7,2,'2024-07-31 01:12:35','05:00:00',1,'2024-07-31 13:04:30','2024-07-31 18:04:30'),(2,2,3,'2024-07-31 01:12:35','04:00:00',2,'2024-07-31 13:04:30','2024-07-31 17:04:30');
/*!40000 ALTER TABLE `rents_vehicles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rents_vehicles_seq`
--

DROP TABLE IF EXISTS `rents_vehicles_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rents_vehicles_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rents_vehicles_seq`
--

LOCK TABLES `rents_vehicles_seq` WRITE;
/*!40000 ALTER TABLE `rents_vehicles_seq` DISABLE KEYS */;
INSERT INTO `rents_vehicles_seq` VALUES (1);
/*!40000 ALTER TABLE `rents_vehicles_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permissions`
--

DROP TABLE IF EXISTS `role_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FK1rt7bn7onethg6g1jt3d2c3wb` (`permission_id`),
  CONSTRAINT `FK1rt7bn7onethg6g1jt3d2c3wb` FOREIGN KEY (`permission_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKn5fotdgk8d1xvo8nav9uv3muc` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permissions`
--

LOCK TABLES `role_permissions` WRITE;
/*!40000 ALTER TABLE `role_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` enum('ADMIN','USER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_rents`
--

DROP TABLE IF EXISTS `status_rents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status_rents` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_rents_unique` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_rents`
--

LOCK TABLES `status_rents` WRITE;
/*!40000 ALTER TABLE `status_rents` DISABLE KEYS */;
INSERT INTO `status_rents` VALUES (2,'CANCELADO'),(1,'PEDIDO');
/*!40000 ALTER TABLE `status_rents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_vehicle`
--

DROP TABLE IF EXISTS `type_vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_vehicle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type_vehicle_unique` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_vehicle`
--

LOCK TABLES `type_vehicle` WRITE;
/*!40000 ALTER TABLE `type_vehicle` DISABLE KEYS */;
INSERT INTO `type_vehicle` VALUES (2,'Hatchback '),(5,'Pick-up'),(1,'Sedán'),(3,'SUV'),(4,'Van');
/*!40000 ALTER TABLE `type_vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` varchar(20) NOT NULL,
  `account_expired` bit(1) DEFAULT NULL,
  `account_locked` bit(1) DEFAULT NULL,
  `credential_expired` bit(1) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Nancy','Mendez','dany@gmail.com','ndma','ADMIN',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_seq`
--

DROP TABLE IF EXISTS `users_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_seq`
--

LOCK TABLES `users_seq` WRITE;
/*!40000 ALTER TABLE `users_seq` DISABLE KEYS */;
INSERT INTO `users_seq` VALUES (1);
/*!40000 ALTER TABLE `users_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `model_id` bigint(20) NOT NULL,
  `year` int(11) NOT NULL,
  `manufacturer_id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` decimal(38,2) NOT NULL,
  `available` tinyint(1) NOT NULL,
  `total` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicles_models_FK` (`model_id`),
  KEY `vehicles_manufacturer_FK` (`manufacturer_id`),
  KEY `vehicles_type_vehicle_FK` (`type_id`),
  CONSTRAINT `vehicles_manufacturer_FK` FOREIGN KEY (`manufacturer_id`) REFERENCES `vehicles_manufacturer` (`id`),
  CONSTRAINT `vehicles_models_FK` FOREIGN KEY (`model_id`) REFERENCES `vehicles_models` (`id`),
  CONSTRAINT `vehicles_type_vehicle_FK` FOREIGN KEY (`type_id`) REFERENCES `type_vehicle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES (1,2,2010,10,1,'Auto rojo con 4 puertas, perfecto para viajar en ciudad.',2999.00,1,5),(2,6,2011,2,5,'Camioneta azul. Cuenta con 4 puertas, perfecta para que viaje con toda la familia a lugares fuera de ciudad, cuenta con llantas perfectas para manejarse sobre todo terreno.',5700.00,1,3),(3,4,2023,2,1,'Auto plateado con un espacio para hasta 5 personas.',4000.00,1,10);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles_manufacturer`
--

DROP TABLE IF EXISTS `vehicles_manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles_manufacturer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_unique` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles_manufacturer`
--

LOCK TABLES `vehicles_manufacturer` WRITE;
/*!40000 ALTER TABLE `vehicles_manufacturer` DISABLE KEYS */;
INSERT INTO `vehicles_manufacturer` VALUES (1,'Audi'),(8,'BWM'),(2,'Chevrolet'),(3,'Ford'),(5,'Honda'),(4,'Hyundai'),(9,'KIA'),(10,'Nissan'),(6,'Peugeot'),(11,'Suzuki'),(7,'Toyota'),(14,'Volkswagen');
/*!40000 ALTER TABLE `vehicles_manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles_models`
--

DROP TABLE IF EXISTS `vehicles_models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles_models` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `manufacturer_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_unique` (`name`),
  KEY `vehicles_models_manufacturer_FK` (`manufacturer_id`),
  CONSTRAINT `vehicles_models_manufacturer_FK` FOREIGN KEY (`manufacturer_id`) REFERENCES `vehicles_manufacturer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles_models`
--

LOCK TABLES `vehicles_models` WRITE;
/*!40000 ALTER TABLE `vehicles_models` DISABLE KEYS */;
INSERT INTO `vehicles_models` VALUES (1,'VERSA',10),(2,'SENTRA',10),(3,'URVAN',10),(4,'AVEO',2),(5,'ONIX',2),(6,'SILVERADO',2);
/*!40000 ALTER TABLE `vehicles_models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicles_seq`
--

DROP TABLE IF EXISTS `vehicles_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles_seq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles_seq`
--

LOCK TABLES `vehicles_seq` WRITE;
/*!40000 ALTER TABLE `vehicles_seq` DISABLE KEYS */;
INSERT INTO `vehicles_seq` VALUES (1),(2);
/*!40000 ALTER TABLE `vehicles_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vrent_vehicle`
--

DROP TABLE IF EXISTS `vrent_vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vrent_vehicle` (
  `id` bigint(20) NOT NULL,
  `description_vehicle` varchar(255) DEFAULT NULL,
  `email_client` varchar(255) DEFAULT NULL,
  `final_date` varchar(255) DEFAULT NULL,
  `initial_date` varchar(255) DEFAULT NULL,
  `manufacturer_vehicle` varchar(255) DEFAULT NULL,
  `model_vehicle` varchar(255) DEFAULT NULL,
  `name_client` varchar(255) DEFAULT NULL,
  `order_date` varchar(255) DEFAULT NULL,
  `phone_client` varchar(255) DEFAULT NULL,
  `price_total` varchar(255) DEFAULT NULL,
  `rental_time` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type_vehicle` varchar(255) DEFAULT NULL,
  `year_vehicle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vrent_vehicle`
--

LOCK TABLES `vrent_vehicle` WRITE;
/*!40000 ALTER TABLE `vrent_vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `vrent_vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vvehicle`
--

DROP TABLE IF EXISTS `vvehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vvehicle` (
  `id` bigint(20) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vvehicle`
--

LOCK TABLES `vvehicle` WRITE;
/*!40000 ALTER TABLE `vvehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `vvehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'autorentax'
--
/*!50003 DROP PROCEDURE IF EXISTS `fgetrentsvehicles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fgetrentsvehicles`(

    IN p_id BIGINT,

    IN p_model BIGINT,

    IN p_client BIGINT,

    IN p_year VARCHAR(4),

    IN p_manufacturer BIGINT,

    IN p_type BIGINT

)
BEGIN

    IF p_id IS NOT NULL THEN

        SELECT 

            rv.id,

            CONCAT(c.name, ' ', c.lastname) AS name_client,

            c.number_phone AS phone_client,

            c.email AS email_client,

            vm.name AS model_vehicle,

            v.year AS year_vehicle,

            mf.name AS manufacturer_vehicle,

            tv.name AS type_vehicle,

            v.description AS description_vehicle,

            FORMAT(ROUND(v.price * (TIME_TO_SEC(rv.rental_time) / 3600), 2), 2) AS price_total,

            rv.order_date,

            rv.rental_time,

            sr.name AS status,

            rv.initial_date,

            rv.final_date

        FROM rents_vehicles rv

        LEFT JOIN clients c ON c.id = rv.client_id

        LEFT JOIN vehicles v ON v.id = rv.vehicle_id

        LEFT JOIN vehicles_models vm ON vm.id = v.model_id

        LEFT JOIN vehicles_manufacturer mf ON mf.id = v.manufacturer_id

        LEFT JOIN type_vehicle tv ON tv.id = v.type_id

        LEFT JOIN status_rents sr ON sr.id = rv.status_id

        WHERE rv.id = p_id;

    ELSE

        SELECT 

            rv.id,

            CONCAT(c.name, ' ', c.lastname) AS name_client,

            c.number_phone AS phone_client,

            c.email AS email_client,

            vm.name AS model_vehicle,

            v.year AS year_vehicle,

            mf.name AS manufacturer_vehicle,

            tv.name AS type_vehicle,

            v.description AS description_vehicle,

            FORMAT(ROUND(v.price * (TIME_TO_SEC(rv.rental_time) / 3600), 2), 2) AS price_total,

            rv.order_date,

            rv.rental_time,

            sr.name AS status,

            rv.initial_date,

            rv.final_date

        FROM rents_vehicles rv

        LEFT JOIN clients c ON c.id = rv.client_id

        LEFT JOIN vehicles v ON v.id = rv.vehicle_id

        LEFT JOIN vehicles_models vm ON vm.id = v.model_id

        LEFT JOIN vehicles_manufacturer mf ON mf.id = v.manufacturer_id

        LEFT JOIN type_vehicle tv ON tv.id = v.type_id

        LEFT JOIN status_rents sr ON sr.id = rv.status_id

        WHERE (p_model IS NULL OR vm.id = p_model)

          AND (p_year IS NULL OR v.year = p_year)

          AND (p_client IS NULL OR c.id = p_client)

          AND (p_manufacturer IS NULL OR mf.id = p_manufacturer)

          AND (p_type IS NULL OR v.type_id = p_type);

    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `fgetvehicles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fgetvehicles`(

    IN p_id BIGINT,

    IN p_model BIGINT,

    IN p_year VARCHAR(4),

    IN p_manufacturer BIGINT,

    IN p_type BIGINT

)
BEGIN

    IF p_id IS NOT NULL THEN        

   	    

        SELECT 

            v.id,

            vm.name AS model,

            v.year,

            mf.name AS manufacturer,

            tv.name AS type,

            v.description,

            v.price,

            v.available,

            v.total

        FROM vehicles v

        LEFT JOIN vehicles_models vm ON vm.id = v.model_id

        LEFT JOIN vehicles_manufacturer mf ON mf.id = v.manufacturer_id

        LEFT JOIN type_vehicle tv ON tv.id = v.type_id

        WHERE v.id = p_id;

    ELSE

        

        SELECT 

            v.id,

            vm.name AS model,

            v.year,

            mf.name AS manufacturer,

            tv.name AS type,

            v.description,

            v.price,

            v.available,

            v.total

        FROM vehicles v

        LEFT JOIN vehicles_models vm ON vm.id = v.model_id

        LEFT JOIN vehicles_manufacturer mf ON mf.id = v.manufacturer_id

        LEFT JOIN type_vehicle tv ON tv.id = v.type_id

        WHERE (p_model IS NULL OR vm.id = p_model)

          AND (p_year IS NULL OR v.year = p_year)

          AND (p_manufacturer IS NULL OR mf.id = p_manufacturer)

          AND (p_type IS NULL OR v.type_id = p_type)

          AND (v.available = 1);

    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-01  2:16:06
