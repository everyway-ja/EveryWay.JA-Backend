-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.4.32-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database everyway
DROP DATABASE IF EXISTS `everyway`;
CREATE DATABASE IF NOT EXISTS `everyway` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `everyway`;

-- Dump della struttura di tabella everyway.accountcategories
DROP TABLE IF EXISTS `accountcategories`;
CREATE TABLE IF NOT EXISTS `accountcategories` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `id_image` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_accountcategories_images` (`id_image`),
  CONSTRAINT `FK_accountcategories_images` FOREIGN KEY (`id_image`) REFERENCES `images` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the categories (disabilities) contemplated by the application.';

-- Dump dei dati della tabella everyway.accountcategories: ~0 rows (circa)
DELETE FROM `accountcategories`;

-- Dump della struttura di tabella everyway.accountcategories_accounts
DROP TABLE IF EXISTS `accountcategories_accounts`;
CREATE TABLE IF NOT EXISTS `accountcategories_accounts` (
  `id_accountcategories` int(11) NOT NULL,
  `id_account` int(11) NOT NULL,
  PRIMARY KEY (`id_accountcategories`,`id_account`),
  KEY `id_accountcategories` (`id_accountcategories`),
  KEY `id_account` (`id_account`),
  CONSTRAINT `FK_accountcategories_accounts_accountcategories` FOREIGN KEY (`id_accountcategories`) REFERENCES `accountcategories` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_accountcategories_accounts_accounts` FOREIGN KEY (`id_account`) REFERENCES `accounts` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the categories an account is part of.';

-- Dump dei dati della tabella everyway.accountcategories_accounts: ~0 rows (circa)
DELETE FROM `accountcategories_accounts`;

-- Dump della struttura di tabella everyway.accountcategories_itineraries
DROP TABLE IF EXISTS `accountcategories_itineraries`;
CREATE TABLE IF NOT EXISTS `accountcategories_itineraries` (
  `id_accountcategory` int(11) NOT NULL,
  `id_itinerary` int(11) NOT NULL,
  PRIMARY KEY (`id_accountcategory`,`id_itinerary`),
  KEY `id_accountcategory` (`id_accountcategory`),
  KEY `id_itinerary` (`id_itinerary`),
  CONSTRAINT `FK_accountcategories_itineraries_accounts` FOREIGN KEY (`id_accountcategory`) REFERENCES `accounts` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_accountcategories_itineraries_itineraries` FOREIGN KEY (`id_itinerary`) REFERENCES `itineraries` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FKrsrypqogltcybjhredd7ia5th` FOREIGN KEY (`id_accountcategory`) REFERENCES `accountcategories` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the account categories an itinerary is friendly to.';

-- Dump dei dati della tabella everyway.accountcategories_itineraries: ~0 rows (circa)
DELETE FROM `accountcategories_itineraries`;

-- Dump della struttura di tabella everyway.accountcategories_locationreports
DROP TABLE IF EXISTS `accountcategories_locationreports`;
CREATE TABLE IF NOT EXISTS `accountcategories_locationreports` (
  `id_accountcategory` int(11) NOT NULL,
  `id_locationreport` int(11) NOT NULL,
  PRIMARY KEY (`id_accountcategory`,`id_locationreport`),
  KEY `id_accountcategory` (`id_accountcategory`),
  KEY `id_locationreport` (`id_locationreport`),
  CONSTRAINT `FK_accountcategories_locationreports_accountcategories` FOREIGN KEY (`id_accountcategory`) REFERENCES `accountcategories` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_accountcategories_locationreports_locationreports` FOREIGN KEY (`id_locationreport`) REFERENCES `locationreports` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the account categories a location that is being reported is friendly to.';

-- Dump dei dati della tabella everyway.accountcategories_locationreports: ~0 rows (circa)
DELETE FROM `accountcategories_locationreports`;

-- Dump della struttura di tabella everyway.accountcategories_locations
DROP TABLE IF EXISTS `accountcategories_locations`;
CREATE TABLE IF NOT EXISTS `accountcategories_locations` (
  `id_accountcategory` int(11) NOT NULL,
  `id_location` int(11) NOT NULL,
  PRIMARY KEY (`id_accountcategory`,`id_location`),
  KEY `id_accountcategory` (`id_accountcategory`),
  KEY `id_location` (`id_location`),
  CONSTRAINT `FK267u0bpgwdhiuwf41np828a6e` FOREIGN KEY (`id_location`) REFERENCES `locations` (`ID`),
  CONSTRAINT `FK__locations` FOREIGN KEY (`id_accountcategory`) REFERENCES `locations` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_accountcategories_locations_accountcategories` FOREIGN KEY (`id_location`) REFERENCES `accountcategories` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FKsoub10xc1gf70g6xn6xfaiv82` FOREIGN KEY (`id_accountcategory`) REFERENCES `accountcategories` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the account categories a location is friendly to.';

-- Dump dei dati della tabella everyway.accountcategories_locations: ~0 rows (circa)
DELETE FROM `accountcategories_locations`;

-- Dump della struttura di tabella everyway.accounts
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE IF NOT EXISTS `accounts` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `birthdate` date NOT NULL,
  `id_language` int(11) NOT NULL DEFAULT 1,
  `id_image` int(11) NOT NULL,
  `creation_timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_timestamp` timestamp NULL DEFAULT NULL,
  `deletion_timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `language` (`id_language`) USING BTREE,
  KEY `FK_accounts_images` (`id_image`),
  CONSTRAINT `FK_accounts_images` FOREIGN KEY (`id_image`) REFERENCES `images` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_accounts_languages` FOREIGN KEY (`id_language`) REFERENCES `languages` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2147483648 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the information related to accounts.';

-- Dump dei dati della tabella everyway.accounts: ~0 rows (circa)
DELETE FROM `accounts`;

-- Dump della struttura di tabella everyway.accounts_positions
DROP TABLE IF EXISTS `accounts_positions`;
CREATE TABLE IF NOT EXISTS `accounts_positions` (
  `id_account` int(11) NOT NULL,
  `id_position` int(11) NOT NULL,
  `isAccountHome` bit(1) DEFAULT NULL,
  `creation_timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_account`,`id_position`,`creation_timestamp`),
  KEY `id_account` (`id_account`),
  KEY `id_position` (`id_position`),
  CONSTRAINT `FK__accounts` FOREIGN KEY (`id_account`) REFERENCES `accounts` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_accounts_positions_positions` FOREIGN KEY (`id_position`) REFERENCES `positions` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the positions an account has been in.';

-- Dump dei dati della tabella everyway.accounts_positions: ~0 rows (circa)
DELETE FROM `accounts_positions`;

-- Dump della struttura di tabella everyway.images
DROP TABLE IF EXISTS `images`;
CREATE TABLE IF NOT EXISTS `images` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the images that everyway uses.';

-- Dump dei dati della tabella everyway.images: ~0 rows (circa)
DELETE FROM `images`;

-- Dump della struttura di tabella everyway.images_itineraries
DROP TABLE IF EXISTS `images_itineraries`;
CREATE TABLE IF NOT EXISTS `images_itineraries` (
  `id_image` int(11) NOT NULL,
  `id_itinerary` int(11) NOT NULL,
  PRIMARY KEY (`id_image`,`id_itinerary`),
  KEY `id_image` (`id_image`),
  KEY `id_itinerary` (`id_itinerary`),
  CONSTRAINT `FK_images_itineraries_images` FOREIGN KEY (`id_image`) REFERENCES `images` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FKhh03dkuw0gf3baqibok2cv87i` FOREIGN KEY (`id_itinerary`) REFERENCES `itineraries` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella everyway.images_itineraries: ~0 rows (circa)
DELETE FROM `images_itineraries`;

-- Dump della struttura di tabella everyway.images_locations
DROP TABLE IF EXISTS `images_locations`;
CREATE TABLE IF NOT EXISTS `images_locations` (
  `id_image` int(11) NOT NULL,
  `id_location` int(11) NOT NULL,
  `id_itinerary` int(11) NOT NULL,
  PRIMARY KEY (`id_image`,`id_location`),
  KEY `id_location` (`id_location`),
  KEY `id_image` (`id_image`),
  KEY `FK82ggr0qhfjxbxuiwmnohivknq` (`id_itinerary`),
  CONSTRAINT `FK82ggr0qhfjxbxuiwmnohivknq` FOREIGN KEY (`id_itinerary`) REFERENCES `locations` (`ID`),
  CONSTRAINT `FK_images_locations_images` FOREIGN KEY (`id_image`) REFERENCES `images` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_images_locations_locations` FOREIGN KEY (`id_location`) REFERENCES `locations` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dump dei dati della tabella everyway.images_locations: ~0 rows (circa)
DELETE FROM `images_locations`;

-- Dump della struttura di tabella everyway.itineraries
DROP TABLE IF EXISTS `itineraries`;
CREATE TABLE IF NOT EXISTS `itineraries` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_account` int(11) NOT NULL,
  `creation_timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_timestamp` timestamp NULL DEFAULT NULL,
  `deletion_timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `id_account` (`id_account`),
  CONSTRAINT `FK_itineraries_accounts` FOREIGN KEY (`id_account`) REFERENCES `accounts` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the created itineraries.';

-- Dump dei dati della tabella everyway.itineraries: ~0 rows (circa)
DELETE FROM `itineraries`;

-- Dump della struttura di tabella everyway.itineraries_locations
DROP TABLE IF EXISTS `itineraries_locations`;
CREATE TABLE IF NOT EXISTS `itineraries_locations` (
  `id_itinerary` int(11) NOT NULL,
  `id_location` int(11) NOT NULL,
  `index` int(11) NOT NULL,
  PRIMARY KEY (`id_itinerary`,`id_location`),
  KEY `id_itinerary` (`id_itinerary`),
  KEY `FK_itineraries_locations_locations` (`id_location`),
  CONSTRAINT `FK__itineraries` FOREIGN KEY (`id_itinerary`) REFERENCES `itineraries` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_itineraries_locations_locations` FOREIGN KEY (`id_location`) REFERENCES `locations` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the locations comprehended in an itinerary.';

-- Dump dei dati della tabella everyway.itineraries_locations: ~0 rows (circa)
DELETE FROM `itineraries_locations`;

-- Dump della struttura di tabella everyway.itinerarycategories
DROP TABLE IF EXISTS `itinerarycategories`;
CREATE TABLE IF NOT EXISTS `itinerarycategories` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `id_image` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `id_image` (`id_image`),
  CONSTRAINT `FK_itinerarycategories_images` FOREIGN KEY (`id_image`) REFERENCES `images` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the available categories of itineraries.';

-- Dump dei dati della tabella everyway.itinerarycategories: ~5 rows (circa)
DELETE FROM `itinerarycategories`;
INSERT INTO `itinerarycategories` (`ID`, `description`, `id_image`) VALUES
	(1, 'Standard', NULL),
	(2, 'Adventure', NULL),
	(3, 'Cultural', NULL),
	(4, 'Luxury', NULL),
	(5, 'Family', NULL),
	(6, 'Road Trip', NULL),
	(7, 'Eco-friendly', NULL),
	(8, 'Food & Culinary', NULL),
	(9, 'Wellness', NULL),
	(10, 'Business', NULL),
	(11, 'Backpacking', NULL),
	(12, 'Solo Travel', NULL),
	(13, 'Themed', NULL),
	(14, 'Budget', NULL),
	(15, 'Romantic', NULL),
	(16, 'Staycation', NULL),
	(17, 'Relaxing', NULL),
	(18, 'Naturalistic', NULL),
	(19, 'Urban', NULL);

-- Dump della struttura di tabella everyway.itinerarycategories_itineraries
DROP TABLE IF EXISTS `itinerarycategories_itineraries`;
CREATE TABLE IF NOT EXISTS `itinerarycategories_itineraries` (
  `id_itinerarycategory` int(11) NOT NULL,
  `id_itinerary` int(11) NOT NULL,
  PRIMARY KEY (`id_itinerarycategory`,`id_itinerary`),
  KEY `id_itinerarycategory` (`id_itinerarycategory`),
  KEY `id_itinerary` (`id_itinerary`),
  CONSTRAINT `FK__itenerarycategories` FOREIGN KEY (`id_itinerarycategory`) REFERENCES `itinerarycategories` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_itinerarycategories_itinerary_itineraries` FOREIGN KEY (`id_itinerary`) REFERENCES `itineraries` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the categories an itinerary is part of.';

-- Dump dei dati della tabella everyway.itinerarycategories_itineraries: ~0 rows (circa)
DELETE FROM `itinerarycategories_itineraries`;

-- Dump della struttura di tabella everyway.languages
DROP TABLE IF EXISTS `languages`;
CREATE TABLE IF NOT EXISTS `languages` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `short_description` varchar(255) NOT NULL,
  `long_description` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the available languages.';

-- Dump dei dati della tabella everyway.languages: ~2 rows (circa)
DELETE FROM `languages`;
INSERT INTO `languages` (`ID`, `short_description`, `long_description`) VALUES
	(1, 'en', 'English'),
	(2, 'it', 'Italiano');

-- Dump della struttura di tabella everyway.locationcategories
DROP TABLE IF EXISTS `locationcategories`;
CREATE TABLE IF NOT EXISTS `locationcategories` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `id_image` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `id_image` (`id_image`),
  CONSTRAINT `FK_locationcategories_images` FOREIGN KEY (`id_image`) REFERENCES `images` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the categories of locations.';

-- Dump dei dati della tabella everyway.locationcategories: ~21 rows (circa)
DELETE FROM `locationcategories`;
INSERT INTO `locationcategories` (`ID`, `description`, `id_image`) VALUES
	(1, 'Restaurant', NULL),
	(2, 'Hotel', NULL),
	(3, 'Bar', NULL),
	(4, 'Public Park', NULL),
	(5, 'Amusement Park', NULL),
	(6, 'Museum', NULL),
	(7, 'Bed and Breakfast', NULL),
	(8, 'Hospital', NULL),
	(9, 'Pharmacy', NULL),
	(10, 'Police Station', NULL),
	(11, 'Bus Stop', NULL),
	(12, 'Train Station', NULL),
	(13, 'Airport', NULL),
	(14, 'Beach', NULL),
	(15, 'Supermarket', NULL),
	(16, 'Hypermarket', NULL),
	(17, 'Shopping Center', NULL),
	(18, 'Open Market', NULL),
	(19, 'Indoor Market', NULL),
	(20, 'Shop', NULL),
	(21, 'Nightclub', NULL);

-- Dump della struttura di tabella everyway.locationcategories_locationreports
DROP TABLE IF EXISTS `locationcategories_locationreports`;
CREATE TABLE IF NOT EXISTS `locationcategories_locationreports` (
  `id_locationcategory` int(11) NOT NULL,
  `id_locationreport` int(11) NOT NULL,
  PRIMARY KEY (`id_locationcategory`,`id_locationreport`) USING BTREE,
  KEY `id_locationcategory` (`id_locationcategory`),
  KEY `FK_locationcategories_locationreports_locations` (`id_locationreport`) USING BTREE,
  CONSTRAINT `FK__locationcategories` FOREIGN KEY (`id_locationcategory`) REFERENCES `locationcategories` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_locationcategories_locationreports_locationreports` FOREIGN KEY (`id_locationreport`) REFERENCES `locationreports` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the category a location that is being reported is part of.';

-- Dump dei dati della tabella everyway.locationcategories_locationreports: ~0 rows (circa)
DELETE FROM `locationcategories_locationreports`;

-- Dump della struttura di tabella everyway.locationcategories_locations
DROP TABLE IF EXISTS `locationcategories_locations`;
CREATE TABLE IF NOT EXISTS `locationcategories_locations` (
  `id_locationcategory` int(11) NOT NULL,
  `id_location` int(11) NOT NULL,
  PRIMARY KEY (`id_locationcategory`,`id_location`),
  KEY `id_locationcategory` (`id_locationcategory`),
  KEY `id_location` (`id_location`),
  CONSTRAINT `FK_locatiocategory_locations_locationcategories` FOREIGN KEY (`id_locationcategory`) REFERENCES `locationcategories` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_locatiocategory_locations_locations` FOREIGN KEY (`id_location`) REFERENCES `locations` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the categories a location is part of.';

-- Dump dei dati della tabella everyway.locationcategories_locations: ~0 rows (circa)
DELETE FROM `locationcategories_locations`;

-- Dump della struttura di tabella everyway.locationreports
DROP TABLE IF EXISTS `locationreports`;
CREATE TABLE IF NOT EXISTS `locationreports` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_position` int(11) NOT NULL,
  `id_account` int(11) NOT NULL,
  `creation_timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`ID`),
  KEY `id_position` (`id_position`),
  KEY `id_account` (`id_account`),
  CONSTRAINT `FK__positions` FOREIGN KEY (`id_position`) REFERENCES `positions` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_locationreports_accounts` FOREIGN KEY (`id_account`) REFERENCES `accounts` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the reports of undiscovered locations.';

-- Dump dei dati della tabella everyway.locationreports: ~0 rows (circa)
DELETE FROM `locationreports`;

-- Dump della struttura di tabella everyway.locations
DROP TABLE IF EXISTS `locations`;
CREATE TABLE IF NOT EXISTS `locations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_position` int(11) NOT NULL,
  `id_account` int(11) DEFAULT NULL,
  `creation_timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_timestamp` timestamp NULL DEFAULT NULL,
  `deletion_timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `id_position` (`id_position`),
  KEY `id_account` (`id_account`),
  CONSTRAINT `FK_locations_accounts` FOREIGN KEY (`id_account`) REFERENCES `accounts` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_locations_positions` FOREIGN KEY (`id_position`) REFERENCES `positions` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the registered location. \r\nNote that a location is not a position: while the first implies a landmark of any kind, a position can coincide with a landmark or can be a random point on a road.';

-- Dump dei dati della tabella everyway.locations: ~0 rows (circa)
DELETE FROM `locations`;

-- Dump della struttura di tabella everyway.locations&itineraries_accounts
DROP TABLE IF EXISTS `locations&itineraries_accounts`;
CREATE TABLE IF NOT EXISTS `locations&itineraries_accounts` (
  `id_account` int(11) NOT NULL,
  `id_itinerary` int(11) NOT NULL,
  `id_location` int(11) NOT NULL,
  `creation_timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_account`,`id_itinerary`,`id_location`,`creation_timestamp`),
  KEY `id_account` (`id_account`),
  KEY `id_itinerary` (`id_itinerary`),
  KEY `id_location` (`id_location`),
  CONSTRAINT `FK_locations&itineraries_accounts_accounts` FOREIGN KEY (`id_account`) REFERENCES `accounts` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_locations&itineraries_accounts_itineraries` FOREIGN KEY (`id_itinerary`) REFERENCES `itineraries` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_locations&itineraries_accounts_locations` FOREIGN KEY (`id_location`) REFERENCES `locations` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the locations and itineraries an account visited.';

-- Dump dei dati della tabella everyway.locations&itineraries_accounts: ~0 rows (circa)
DELETE FROM `locations&itineraries_accounts`;

-- Dump della struttura di tabella everyway.positions
DROP TABLE IF EXISTS `positions`;
CREATE TABLE IF NOT EXISTS `positions` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `x_coordinate` double NOT NULL,
  `y_coordinate` double NOT NULL,
  `nation` varchar(255) NOT NULL,
  `region_state` varchar(255) NOT NULL,
  `province` varchar(255) NOT NULL,
  `city_town` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postalcode` varchar(255) DEFAULT NULL,
  `creation_timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing all positions (coordinates etc.) that have been used by the application.';

-- Dump dei dati della tabella everyway.positions: ~0 rows (circa)
DELETE FROM `positions`;

-- Dump della struttura di tabella everyway.reviews
DROP TABLE IF EXISTS `reviews`;
CREATE TABLE IF NOT EXISTS `reviews` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `id_account` int(11) NOT NULL,
  `id_location` int(11) DEFAULT NULL,
  `id_itinerary` int(11) DEFAULT NULL,
  `isFactualityReport` bit(1) DEFAULT NULL,
  `creation_timestamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_timestamp` timestamp NULL DEFAULT NULL,
  `deletion_timestamp` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `id_account` (`id_account`),
  KEY `id_location` (`id_location`),
  KEY `id_itinerary` (`id_itinerary`),
  CONSTRAINT `FK_reviews_accounts` FOREIGN KEY (`id_account`) REFERENCES `accounts` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_reviews_itineraries` FOREIGN KEY (`id_itinerary`) REFERENCES `itineraries` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_reviews_locations` FOREIGN KEY (`id_location`) REFERENCES `locations` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Table storing the reviews of locations or itineraries.';

-- Dump dei dati della tabella everyway.reviews: ~0 rows (circa)
DELETE FROM `reviews`;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
