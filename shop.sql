-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 03, 2017 at 07:30 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

create database mini_pos_system;
use mini_pos_system;
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE IF NOT EXISTS `brand` (
  `bra_id` int(11) NOT NULL AUTO_INCREMENT,
  `bra_name` varchar(50) NOT NULL DEFAULT '0',
  `bra_description` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bra_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`bra_id`, `bra_name`, `bra_description`) VALUES
(1, 'Apple', '0'),
(2, 'Sumsung', '0'),
(3, 'Hauwei', '0'),
(4, 'OPPO', '0'),
(5, 'Xaiomi', '0'),
(6, 'Nokia', '0'),
(7, 'Meizu', '0'),
(8, 'Sony', '0'),
(9, 'LG', '0');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`cat_id`, `cat_name`) VALUES
(1, 'Phone'),
(2, 'Tablet'),
(3, 'Power Bank'),
(4, 'Case'),
(5, 'Charger');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_name` varchar(50) DEFAULT '0',
  `cus_phone` varchar(50) DEFAULT '0',
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_id` int(11) DEFAULT NULL,
  `bra_id` int(11) DEFAULT NULL,
  `pro_name` varchar(200) NOT NULL,
  `pro_code` varchar(50) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `unit_price` int(11) NOT NULL,
  `pro_status` enum('N','U') NOT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE IF NOT EXISTS `sale` (
  `sale_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) DEFAULT NULL,
  `sale_price` int(11) DEFAULT NULL,
  `sale_qty` int(11) DEFAULT NULL,
  `cus_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_edit` int(11) DEFAULT NULL,
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `active` enum('T','F') NOT NULL,
  `reg_date` datetime NOT NULL,
  `last_login` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `username`, `password`, `active`, `reg_date`, `last_login`) VALUES
(1, 'Mengkry', 'mengkry', 'p28464a464w2', 'T', '2016-08-15 10:39:46', '2017-02-02 02:59:54');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
