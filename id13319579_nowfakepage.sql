-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 22, 2020 at 10:14 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id13319579_nowfakepage`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `idItemCart` int(11) NOT NULL,
  `stock` int(11) NOT NULL DEFAULT 1,
  `idDish` int(11) NOT NULL,
  `idCustomer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`idItemCart`, `stock`, `idDish`, `idCustomer`) VALUES
(39, 1, 1, 9),
(40, 1, 5, 9);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `idComment` int(11) NOT NULL,
  `rate` int(11) NOT NULL DEFAULT 5,
  `contentComment` text COLLATE utf8_unicode_ci NOT NULL,
  `timeCommented` datetime NOT NULL,
  `idS` int(11) NOT NULL,
  `idcustomer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `idCustomer` int(11) NOT NULL,
  `nameCustomer` text COLLATE utf8_unicode_ci NOT NULL,
  `deliveryAddress` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `phoneCustomer` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `positionDeliveryAddress` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `userName` text COLLATE utf8_unicode_ci NOT NULL,
  `passWord` text COLLATE utf8_unicode_ci NOT NULL,
  `email` text COLLATE utf8_unicode_ci NOT NULL,
  `dateOfBirth` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`idCustomer`, `nameCustomer`, `deliveryAddress`, `phoneCustomer`, `positionDeliveryAddress`, `image`, `userName`, `passWord`, `email`, `dateOfBirth`) VALUES
(1, 'Toan Tran', '123  Lý Phục Man', '0972712901', '', 'link', 'toanlklk', 'lklklk', '', '0000-00-00'),
(2, 'teo', '789', '122221', '321', '3121', '123123', '456456', '', '0000-00-00'),
(3, 'teo', '789', '122221', '321', '3121', '123123', '456456', '', '0000-00-00'),
(4, 'teo', '789', '122221', '321', '3121', '123123', '456456', '', '0000-00-00'),
(5, 'teo', '789', '122221', '321', '3121', '123123', '456456', '', '0000-00-00'),
(6, 'teohf', '789', '122221', '321', '3121', 'teolklk', '456456', '', '0000-00-00'),
(7, 'teohghjf', '789', '122221', '321', '3121', 'ghjklghjk', '456456', '', '0000-00-00'),
(8, '1', NULL, '4', NULL, NULL, '2', '3', '5', '1994-09-06'),
(9, 'aloalo', NULL, '090909', NULL, NULL, 'aloalo', 'aloalo', 'aoi@alo.com', '1994-09-06'),
(10, 'Trần Quang Toàn', NULL, '0972712901', NULL, NULL, 'toanitdev', 'lklklk', 'toanitdev@gmail.com', '1994-09-06');

-- --------------------------------------------------------

--
-- Table structure for table `dish`
--

CREATE TABLE `dish` (
  `idDish` int(11) NOT NULL,
  `nameDish` text COLLATE utf8_unicode_ci NOT NULL,
  `priceDish` double NOT NULL,
  `discountPrice` double NOT NULL,
  `desciptionDish` text COLLATE utf8_unicode_ci NOT NULL,
  `shortDesciption` text COLLATE utf8_unicode_ci NOT NULL,
  `hotDeal` tinyint(1) NOT NULL DEFAULT 0,
  `linkImage` text COLLATE utf8_unicode_ci NOT NULL,
  `idstore` int(11) NOT NULL,
  `idType` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dish`
--

INSERT INTO `dish` (`idDish`, `nameDish`, `priceDish`, `discountPrice`, `desciptionDish`, `shortDesciption`, `hotDeal`, `linkImage`, `idstore`, `idType`) VALUES
(1, 'Cơm gà sối mỡ.', 3500000000, -320000000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/001.jpg', 2, 2),
(2, 'Pizza', 185000, 120000, '', '', 1, 'https://nowfakepage.000webhostapp.com/api/images/002.jpg', 3, 2),
(5, 'Mỳ ý', 45000, 35000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/003.jpg', 3, 2),
(6, 'Phở bò', 55000, 55000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/004.jpeg', 1, 2),
(7, 'Trà sữa trân châu đường đen', 40000, 20000, '', '', 1, 'https://nowfakepage.000webhostapp.com/api/images/005.jpeg', 4, 3),
(8, 'Hủ tíu bò kho', 35000, 35000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/006.jpeg', 1, 2),
(9, 'Hủ tíu nam vang', 30000, 3000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/007.jpeg', 1, 2),
(10, 'Bò sốt vang', 35000, 35000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/008.jpeg', 6, 2),
(13, 'Cơm tấm sườn', 35000, 32000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/009.jpeg', 2, 2),
(14, 'Bò bít tết', 45000, 42000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/010.jpeg', 7, 2),
(15, 'Bò bía', 5000, 5000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/011.jpeg', 7, 1),
(16, 'Bò bít tết', 45000, 45000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/012.jpeg', 6, 2),
(17, 'Cafe đá', 25000, 22000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/013.jpeg', 4, 3),
(18, 'Sinh tố bơ', 40000, 35000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/014.jpeg', 4, 3),
(19, 'Sinh tố xoài', 45000, 40000, '', '', 1, 'https://nowfakepage.000webhostapp.com/api/images/015.jpeg', 4, 3),
(20, 'Bánh tráng trộn', 20000, 20000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/016.jpeg', 7, 1),
(21, 'Bánh tráng nướng', 25000, 25000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/017.jpeg', 7, 1),
(22, 'Bò viên chiên.', 10000, 10000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/018.jpeg', 7, 1),
(23, 'Há cảo chiên', 26000, 25000, '', '', 1, 'https://nowfakepage.000webhostapp.com/api/images/019.jpeg', 6, 1),
(24, 'Bánh xếp hấp', 32000, 30000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/020.jpeg', 6, 1),
(25, 'Bún đậu mắm tôm', 45000, 45000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/021.jpeg', 6, 2),
(26, 'Bánh Bao', 20000, 18000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/023.jpeg', 7, 2),
(27, 'Bánh bao chiên', 7000, 6500, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/024.jpeg', 7, 1),
(28, 'Chuối chiên', 8000, 8000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/025.jpeg', 7, 1),
(29, 'Nước chanh mủ trôm', 25000, 25000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/026.jpeg', 5, 3),
(30, 'Sinh tố dâu', 43000, 43000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/027.jpeg', 5, 3),
(31, 'Trà đào cam sả', 33000, 33000, '', '', 0, 'https://nowfakepage.000webhostapp.com/api/images/028.jpeg', 5, 3);

-- --------------------------------------------------------

--
-- Table structure for table `itemOrders`
--

CREATE TABLE `itemOrders` (
  `idItemOrder` int(11) NOT NULL,
  `originPrice` double NOT NULL,
  `discountPrice` double NOT NULL,
  `number` int(11) NOT NULL,
  `name` text COLLATE utf8_unicode_ci NOT NULL,
  `idDish` int(11) NOT NULL,
  `idOrder` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `itemOrders`
--

INSERT INTO `itemOrders` (`idItemOrder`, `originPrice`, `discountPrice`, `number`, `name`, `idDish`, `idOrder`) VALUES
(24, 0, 0, 1, '0', 22, 28),
(25, 0, 20000, 3, '0', 7, 32),
(26, 0, 120000, 2, '0', 2, 32),
(27, 0, 18000, 1, '0', 26, 32),
(28, 0, 35000, 1, '0', 18, 32),
(29, 0, 40000, 2, '0', 19, 32),
(30, 0, 45000, 1, '0', 25, 32),
(31, 0, 33000, 1, '0', 31, 32),
(32, 0, 20000, 4, '0', 20, 32),
(33, 0, 3000, 1, '0', 9, 32),
(34, 0, 42000, 5, '0', 14, 33),
(35, 0, 32000, 1, '0', 1, 34),
(36, 0, 20000, 1, '0', 7, 34),
(37, 0, 32000, 1, '0', 1, 35),
(38, 0, 25000, 1, '0', 29, 36),
(39, 0, 32000, 1, '0', 1, 37),
(40, 0, 20000, 1, '0', 7, 38);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `idOrder` int(11) NOT NULL,
  `total` double NOT NULL,
  `shippingAddress` text COLLATE utf8_unicode_ci NOT NULL,
  `numberPhone` text COLLATE utf8_unicode_ci NOT NULL,
  `orderTime` datetime NOT NULL DEFAULT current_timestamp(),
  `idCustomer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`idOrder`, `total`, `shippingAddress`, `numberPhone`, `orderTime`, `idCustomer`) VALUES
(28, 10000, 'hhh, vvvv, ggv, vv, vvv', '88', '2020-06-13 15:14:06', 1),
(32, 594000, 'đdcc, ccc, ccc, ccc, cc', '88', '2020-06-13 19:20:23', 1),
(35, 32000, '33, gv, hb, gv, gg', '99', '2020-06-17 12:07:00', 1),
(36, 25000, '51, Ly Phuc Man, Binh Thuan, Quan 7, Ho Chi Minh', '555-555-555', '2020-06-19 15:53:45', 1),
(37, 32000, 'ff, ff, ff, ff, ff', '118-8', '2020-06-19 18:16:17', 10),
(38, 20000, '11, 11, 11, 11, 11', '11', '2020-06-21 11:01:05', 10);

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE `store` (
  `idStore` int(11) NOT NULL,
  `nameStore` text COLLATE utf8_unicode_ci NOT NULL,
  `addressStore` text COLLATE utf8_unicode_ci NOT NULL,
  `numberPhoneStore` text COLLATE utf8_unicode_ci NOT NULL,
  `positionAddressStore` text COLLATE utf8_unicode_ci NOT NULL,
  `descriptionStore` text COLLATE utf8_unicode_ci NOT NULL,
  `imageStore` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`idStore`, `nameStore`, `addressStore`, `numberPhoneStore`, `positionAddressStore`, `descriptionStore`, `imageStore`) VALUES
(1, 'Quán bà Bảy', '123 Lý Phục Man', '032000001', '', '', ''),
(2, 'Quán cơm đầu bếp', '456 Lý Tự Trọng', '032000001', '', '', ''),
(3, 'Pizza Hoàng Kim', '712 huỳnh Tân Phát', '032000001', '', '', ''),
(4, 'The Copy', '111 Trần Trọng Cung', '07985221521', '', '', ''),
(5, 'The Pass', '898 Nguyễn Thị Thập', '05454624154', '', '', ''),
(6, 'Cô 7', '145 Nguyễn Văn Cừ', '0808090506', '', '', ''),
(7, 'A Trí', '999 Thủ Khoa Huân', '19001570', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `idType` int(11) NOT NULL,
  `name` text COLLATE utf8_unicode_ci NOT NULL,
  `imageLink` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`idType`, `name`, `imageLink`) VALUES
(1, 'Ăn vặt', ''),
(2, 'Món chính', ''),
(3, 'Thức uống', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`idItemCart`),
  ADD KEY `itemCart_dish` (`idDish`),
  ADD KEY `itemCart_customer` (`idCustomer`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`idComment`),
  ADD KEY `cmt_store` (`idS`),
  ADD KEY `cmt_customer` (`idcustomer`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idCustomer`);

--
-- Indexes for table `dish`
--
ALTER TABLE `dish`
  ADD PRIMARY KEY (`idDish`),
  ADD KEY `dish_type` (`idType`),
  ADD KEY `dish_store` (`idstore`);

--
-- Indexes for table `itemOrders`
--
ALTER TABLE `itemOrders`
  ADD PRIMARY KEY (`idItemOrder`),
  ADD KEY `itemOrder_dish` (`idDish`),
  ADD KEY `itemOder_order` (`idOrder`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`idOrder`),
  ADD KEY `orders_customer` (`idCustomer`);

--
-- Indexes for table `store`
--
ALTER TABLE `store`
  ADD PRIMARY KEY (`idStore`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`idType`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `idItemCart` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `idComment` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `idCustomer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `dish`
--
ALTER TABLE `dish`
  MODIFY `idDish` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `itemOrders`
--
ALTER TABLE `itemOrders`
  MODIFY `idItemOrder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `idOrder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `store`
--
ALTER TABLE `store`
  MODIFY `idStore` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `idType` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `itemCart_customer` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`idCustomer`),
  ADD CONSTRAINT `itemCart_dish` FOREIGN KEY (`idDish`) REFERENCES `dish` (`idDish`);

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `cmt_customer` FOREIGN KEY (`idcustomer`) REFERENCES `customer` (`idCustomer`),
  ADD CONSTRAINT `cmt_store` FOREIGN KEY (`idS`) REFERENCES `store` (`idStore`);

--
-- Constraints for table `dish`
--
ALTER TABLE `dish`
  ADD CONSTRAINT `dish_store` FOREIGN KEY (`idstore`) REFERENCES `store` (`idStore`),
  ADD CONSTRAINT `dish_type` FOREIGN KEY (`idType`) REFERENCES `type` (`idType`);

--
-- Constraints for table `itemOrders`
--
ALTER TABLE `itemOrders`
  ADD CONSTRAINT `itemOrder_dish` FOREIGN KEY (`idDish`) REFERENCES `dish` (`idDish`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_customer` FOREIGN KEY (`idCustomer`) REFERENCES `customer` (`idCustomer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
