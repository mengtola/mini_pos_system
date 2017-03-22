-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 22, 2017 at 01:12 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mini_pos_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `brands`
--

CREATE TABLE IF NOT EXISTS `brands` (
  `bra_id` int(11) NOT NULL AUTO_INCREMENT,
  `bra_name` varchar(50) NOT NULL DEFAULT '',
  `bra_active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`bra_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `brands`
--

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
(19, 'aaa', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) NOT NULL,
  `cat_active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `categories`
--

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
(15, 'u', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(50) DEFAULT '0',
  `cus_phone` varchar(50) DEFAULT '0',
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`cus_id`, `cus_name`, `cus_phone`) VALUES
(1, 'Bun Samno', '098777040'),
(2, 'Sovanna', '087656436'),
(3, 'Dara', '011243453'),
(6, 'Heng Dara', '011243453'),
(7, 'Ya', '099834343'),
(8, 'Nanu', '09765454565');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_id` int(11) DEFAULT NULL,
  `bra_id` int(11) DEFAULT NULL,
  `pro_name` varchar(200) NOT NULL,
  `pro_code` varchar(50) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `stock_price` int(11) NOT NULL,
  `sale_price` int(11) NOT NULL,
  `pro_status` enum('N','U') NOT NULL,
  `pro_active` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`pro_id`, `cat_id`, `bra_id`, `pro_name`, `pro_code`, `qty`, `stock_price`, `sale_price`, `pro_status`, `pro_active`) VALUES
(1, 1, 1, 'Iphone 6', '103434', 5, 400, 450, 'U', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) DEFAULT NULL,
  `sale_price` int(11) DEFAULT NULL,
  `sale_qty` int(11) DEFAULT NULL,
  `sale_date` datetime DEFAULT NULL,
  `cus_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_edit` datetime DEFAULT NULL,
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sale_id`, `pro_id`, `sale_price`, `sale_qty`, `sale_date`, `cus_id`, `user_id`, `user_edit`) VALUES
(1, 1, 450, 1, '2017-03-21 12:04:06', 1, 1, '2017-03-21 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `active` bit(1) NOT NULL DEFAULT b'1',
  `reg_date` datetime NOT NULL,
  `last_login` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `username`, `password`, `active`, `reg_date`, `last_login`) VALUES
(1, 'Meng Tola', 'tola', '123456', b'1', '2016-08-15 10:39:46', '2017-02-02 02:59:54');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
