-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 28, 2019 at 07:27 AM
-- Server version: 10.2.27-MariaDB
-- PHP Version: 7.2.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u756067896_prod`
--
CREATE DATABASE IF NOT EXISTS `u756067896_prod` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `u756067896_prod`;

-- --------------------------------------------------------

--
-- Table structure for table `faculties`
--

DROP TABLE IF EXISTS `faculties`;
CREATE TABLE `faculties` (
  `faculty_id` bigint(20) NOT NULL,
  `faculty_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rowstate` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `faculties`
--

INSERT INTO `faculties` (`faculty_id`, `faculty_name`, `rowstate`) VALUES
(5, 'Temp', 1),
(4, 'Temporary Faculty', 1),
(6, 'Temp', 1),
(7, 'Temp', 1),
(8, 'Temp', 1),
(9, 'Temp', 1),
(10, 'Temp', 1),
(11, 'Temp', 1),
(12, 'Temp', 1),
(13, 'Temp', 1),
(14, 'Temp', 1);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL,
  `role_name` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role_state` int(11) NOT NULL,
  `created_by` bigint(20) NOT NULL,
  `created_at` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated_by` bigint(20) NOT NULL,
  `updated_at` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`, `role_state`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, 'ADMIN', 1, 1, '2019-10-28 11:11:11.222', 1, '2019-10-28 11:11:11.222'),
(4, 'SUBADMIN', 1, 1, '2019-12-11 22:15:22.183', 1, '2019-12-11 22:15:22.183');

-- --------------------------------------------------------

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` bigint(20) NOT NULL,
  `r_id` bigint(20) NOT NULL,
  `u_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role_screen_mapping`
--

DROP TABLE IF EXISTS `role_screen_mapping`;
CREATE TABLE `role_screen_mapping` (
  `id` bigint(20) NOT NULL,
  `r_id` bigint(20) NOT NULL,
  `s_id` bigint(20) NOT NULL,
  `rowstate` int(11) NOT NULL,
  `RWUD` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `role_screen_mapping`
--

INSERT INTO `role_screen_mapping` (`id`, `r_id`, `s_id`, `rowstate`, `RWUD`) VALUES
(21, 4, 8, 1, '1~1~1~1'),
(22, 4, 9, 1, '1~1~0~1'),
(23, 1, 8, 1, '1~1~1~1'),
(24, 1, 9, 1, '1~1~1~1'),
(25, 1, 10, 1, '1~1~1~1'),
(26, 1, 11, 1, '1~1~1~1');

-- --------------------------------------------------------

--
-- Table structure for table `screens`
--

DROP TABLE IF EXISTS `screens`;
CREATE TABLE `screens` (
  `screen_id` bigint(20) NOT NULL,
  `screen_name` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `screen_url` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `screen_parent` bigint(20) NOT NULL,
  `screen_menu_level` int(11) NOT NULL,
  `rowstate` int(11) NOT NULL,
  `screen_icon` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `screens`
--

INSERT INTO `screens` (`screen_id`, `screen_name`, `screen_url`, `screen_parent`, `screen_menu_level`, `rowstate`, `screen_icon`) VALUES
(8, 'Administrative Tools', '#', 0, 0, 1, 'fa fa-users'),
(9, 'Screen Management', 'administrative_tools/ScreenManagement.jsp', 8, 0, 1, ''),
(10, 'Role Management', 'administrative_tools/RoleManagement.jsp', 8, 0, 1, ''),
(11, 'User Management', 'administrative_tools/UserManagement.jsp', 8, 0, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `temp_table`
--

DROP TABLE IF EXISTS `temp_table`;
CREATE TABLE `temp_table` (
  `id` bigint(20) NOT NULL,
  `lastname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `temp_table`
--

INSERT INTO `temp_table` (`id`, `lastname`, `name`) VALUES
(1, 'Gaikwad', 'Ashish'),
(2, 'Gaikwad', 'Rutik'),
(3, 'Gaikwad2', 'Rutik2');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
  `id` bigint(20) NOT NULL,
  `full_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dob` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mobile` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `c_by` bigint(20) NOT NULL,
  `c_at` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `u_by` bigint(20) NOT NULL,
  `u_at` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`id`, `full_name`, `dob`, `password`, `email`, `mobile`, `status`, `c_by`, `c_at`, `u_by`, `u_at`) VALUES
(1, 'Ashish Gaikwad', '07/09/1997', 'Ashish@1997', 'ashishgaikwad1997@gmail.com', '8976834278', 1, 0, '', 0, ''),
(4, 'Ashish Gaikwad', '07/09/1997', 'Ashish@1997', 'ashishgaikwad.6268@gmail.com', '8976834278', 1, 0, '', 0, ''),
(12, 'Namrata Kadam', '10/22/1998', 'Gaikwad@123', 'kadamnamrata98@gmail.com', '9136547383', 0, 1, '1576697925229', 1, '1576697925229'),
(13, 'Ananya Kakade', '10/21/1998', 'Kakade@123', 'ananyakakade10@gmail.com', '8983190809', 0, 1, '1576698150237', 1, '1576698150237');

-- --------------------------------------------------------

--
-- Table structure for table `users_role_mapping`
--

DROP TABLE IF EXISTS `users_role_mapping`;
CREATE TABLE `users_role_mapping` (
  `id` bigint(20) NOT NULL,
  `u_id` bigint(20) NOT NULL,
  `r_id` bigint(20) NOT NULL,
  `rowstate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users_role_mapping`
--

INSERT INTO `users_role_mapping` (`id`, `u_id`, `r_id`, `rowstate`) VALUES
(1, 1, 1, 1),
(7, 11, 1, 1),
(8, 12, 1, 1),
(9, 13, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `faculties`
--
ALTER TABLE `faculties`
  ADD PRIMARY KEY (`faculty_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `role_permission`
--
ALTER TABLE `role_permission`
  ADD PRIMARY KEY (`id`),
  ADD KEY `r_id` (`r_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `role_screen_mapping`
--
ALTER TABLE `role_screen_mapping`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FOREIGN R_R` (`r_id`),
  ADD KEY `FOREIGN R_S` (`s_id`);

--
-- Indexes for table `screens`
--
ALTER TABLE `screens`
  ADD PRIMARY KEY (`screen_id`);

--
-- Indexes for table `temp_table`
--
ALTER TABLE `temp_table`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_role_mapping`
--
ALTER TABLE `users_role_mapping`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `faculties`
--
ALTER TABLE `faculties`
  MODIFY `faculty_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `role_permission`
--
ALTER TABLE `role_permission`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role_screen_mapping`
--
ALTER TABLE `role_screen_mapping`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `screens`
--
ALTER TABLE `screens`
  MODIFY `screen_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `temp_table`
--
ALTER TABLE `temp_table`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `users_role_mapping`
--
ALTER TABLE `users_role_mapping`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `role_permission`
--
ALTER TABLE `role_permission`
  ADD CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`r_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `Users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `role_screen_mapping`
--
ALTER TABLE `role_screen_mapping`
  ADD CONSTRAINT `FOREIGN R_R` FOREIGN KEY (`r_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FOREIGN R_S` FOREIGN KEY (`s_id`) REFERENCES `screens` (`screen_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
