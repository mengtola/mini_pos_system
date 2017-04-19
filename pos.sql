-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.17 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for mini_pos_system
CREATE DATABASE IF NOT EXISTS `mini_pos_system` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mini_pos_system`;


-- Dumping structure for table mini_pos_system.brands
CREATE TABLE IF NOT EXISTS `brands` (
  `bra_id` int(11) NOT NULL AUTO_INCREMENT,
  `bra_name` varchar(50) NOT NULL DEFAULT '',
  `bra_active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`bra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- Dumping data for table mini_pos_system.brands: ~21 rows (approximately)
DELETE FROM `brands`;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` (`bra_id`, `bra_name`, `bra_active`) VALUES
	(1, 'Apple', b'1'),
	(2, 'Sumsung', b'1'),
	(3, 'Hauwei', b'1'),
	(4, 'OPPO1', b'1'),
	(5, 'Xaiomi', b'1'),
	(6, 'Nokia', b'1'),
	(7, 'Meizu', b'1'),
	(8, 'Sony', b'1'),
	(9, 'LG', b'1'),
	(10, 'Microsoft', b'1'),
	(11, 'test', b'1'),
	(12, 'Logo1', b'1'),
	(13, 'test5', b'1'),
	(14, 'Tst', b'1'),
	(15, 'OPPO1', b'1'),
	(16, 'OPPO1', b'1'),
	(17, 'OPPO1', b'1'),
	(18, '0000000000999999', b'1'),
	(19, 'aaa', b'0'),
	(20, 'hhhh', b'1'),
	(21, 'OPPO', b'1');
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;


-- Dumping structure for table mini_pos_system.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) NOT NULL,
  `cat_active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Dumping data for table mini_pos_system.categories: ~15 rows (approximately)
DELETE FROM `categories`;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` (`cat_id`, `cat_name`, `cat_active`) VALUES
	(1, 'Phone', b'1'),
	(2, 'Tablet', b'1'),
	(3, 'Power Bank', b'1'),
	(4, 'Case', b'1'),
	(5, 'Charger', b'1'),
	(6, 'Watch', b'1'),
	(7, 'Smart Watch', b'1'),
	(8, 'test', b'1'),
	(9, 't', b'1'),
	(10, 'test8', b'1'),
	(11, 'test9', b'1'),
	(12, 'ggg', b'1'),
	(13, 'ggg000', b'1'),
	(14, 'Oukitel', b'1'),
	(15, 'u', b'1'),
	(16, 'Phone', b'1');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;


-- Dumping structure for table mini_pos_system.customers
CREATE TABLE IF NOT EXISTS `customers` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(50) DEFAULT '0',
  `cus_phone` varchar(50) DEFAULT '0',
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table mini_pos_system.customers: ~5 rows (approximately)
DELETE FROM `customers`;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` (`cus_id`, `cus_name`, `cus_phone`) VALUES
	(1, 'Bun Samno', '098777040'),
	(2, 'Sovanna', '087656436'),
	(3, 'Dara', '011243453'),
	(6, 'Heng Dara', '011243453'),
	(7, 'Ya Yi', '099834343'),
	(8, 'Nanu', '09765454565');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;


-- Dumping structure for table mini_pos_system.products
CREATE TABLE IF NOT EXISTS `products` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_id` int(11) DEFAULT NULL,
  `bra_id` int(11) DEFAULT NULL,
  `pro_name` varchar(200) NOT NULL,
  `pro_code` varchar(50) NOT NULL,
  `qty` int(11) NOT NULL,
  `stock_price` int(11) NOT NULL,
  `sale_price` int(11) NOT NULL,
  `pro_status` bit(1) NOT NULL,
  `pro_active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table mini_pos_system.products: ~4 rows (approximately)
DELETE FROM `products`;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`pro_id`, `cat_id`, `bra_id`, `pro_name`, `pro_code`, `qty`, `stock_price`, `sale_price`, `pro_status`, `pro_active`) VALUES
	(1, 4, 1, 'Iphone 6', '103434', 2, 400, 450, b'0', b'1'),
	(2, 1, 2, 'Sumsung galaxy s7', '876554', 0, 400, 550, b'0', b'1'),
	(3, 1, 1, 'Iphone 5s', '05684', 3, 150, 230, b'1', b'1'),
	(4, 1, 1, 'Iphone 7', '013364', 2, 300, 800, b'1', b'1');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;


-- Dumping structure for table mini_pos_system.saledetails
CREATE TABLE IF NOT EXISTS `saledetails` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_id` int(11) DEFAULT NULL,
  `pro_id` int(11) DEFAULT NULL,
  `sale_price` int(11) DEFAULT NULL,
  `sale_qty` int(11) DEFAULT NULL,
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- Dumping data for table mini_pos_system.saledetails: ~17 rows (approximately)
DELETE FROM `saledetails`;
/*!40000 ALTER TABLE `saledetails` DISABLE KEYS */;
INSERT INTO `saledetails` (`detail_id`, `sale_id`, `pro_id`, `sale_price`, `sale_qty`) VALUES
	(1, 14, 3, 900, 1),
	(4, 16, 2, 600, 1),
	(5, 16, 3, 300, 1),
	(6, 17, 2, 600, 1),
	(7, 17, 3, 300, 1),
	(8, 18, 4, 400, 1),
	(9, 19, 4, 600, 1),
	(10, 20, 4, 600, 1),
	(11, 21, 4, 400, 1),
	(12, 21, 1, 500, 1),
	(13, 22, 1, 400, 1),
	(14, 23, 2, 800, 1),
	(15, 23, 2, 800, 1),
	(16, 23, 2, 800, 1),
	(17, 23, 2, 800, 1),
	(20, 15, 3, 750, 1),
	(21, 15, 4, 900, 1);
/*!40000 ALTER TABLE `saledetails` ENABLE KEYS */;


-- Dumping structure for table mini_pos_system.sales
CREATE TABLE IF NOT EXISTS `sales` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `sale_date` datetime DEFAULT NULL,
  `cus_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_edit` datetime DEFAULT NULL,
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Dumping data for table mini_pos_system.sales: ~14 rows (approximately)
DELETE FROM `sales`;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` (`sale_id`, `sale_date`, `cus_id`, `user_id`, `user_edit`) VALUES
	(8, '2017-03-23 00:00:00', 1, 1, '2017-03-23 00:00:00'),
	(9, '2017-03-23 00:00:00', 2, 1, '2017-03-23 00:00:00'),
	(10, '2017-03-23 00:00:00', 3, 1, '2017-03-23 00:00:00'),
	(11, '2017-03-23 00:00:00', 6, 1, '2017-03-23 00:00:00'),
	(14, '2017-03-23 00:00:00', 1, 1, '2017-03-23 00:00:00'),
	(15, '2017-03-23 00:00:00', 8, 1, '2017-03-30 00:00:00'),
	(16, '2017-03-30 00:00:00', 6, 1, '2017-03-30 00:00:00'),
	(17, '2017-03-30 00:00:00', 6, 1, '2017-03-30 00:00:00'),
	(18, '2017-03-30 00:00:00', 1, 1, '2017-03-30 00:00:00'),
	(19, '2017-03-30 00:00:00', 1, 1, '2017-03-30 00:00:00'),
	(20, '2017-03-30 00:00:00', 1, 1, '2017-03-30 00:00:00'),
	(21, '2017-03-30 00:00:00', 1, 1, '2017-03-30 00:00:00'),
	(22, '2017-03-30 00:00:00', 1, 1, '2017-03-30 00:00:00'),
	(23, '2017-03-30 00:00:00', 7, 1, '2017-03-30 00:00:00');
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;


-- Dumping structure for table mini_pos_system.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `reg_date` datetime NOT NULL,
  `last_login` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table mini_pos_system.users: ~0 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`, `name`, `username`, `password`, `active`, `reg_date`, `last_login`) VALUES
	(1, 'Meng Tola', 'tola', '123456', b'1', '2016-08-15 10:39:46', '2017-02-02 02:59:54');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Dumping structure for trigger mini_pos_system.update_stock
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `update_stock` AFTER INSERT ON `saledetails` FOR EACH ROW begin
       DECLARE proQty int;
       -- Check BookingRequest table
       SELECT products.qty
       INTO @proQty
       FROM products
       WHERE products.pro_id= NEW.pro_id;

       IF @proQty > 0
       THEN
           UPDATE products
           SET qty = @proQty - NEW.sale_qty
           WHERE pro_id = NEW.pro_id;
        END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
