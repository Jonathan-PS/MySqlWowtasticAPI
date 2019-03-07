-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Mar 07, 2019 at 12:45 PM
-- Server version: 5.7.24-log
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wowtastic`
--

-- --------------------------------------------------------

--
-- Table structure for table `characters`
--

CREATE TABLE `characters` (
  `character_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `character_name` varchar(20) NOT NULL,
  `class_name` varchar(20) NOT NULL,
  `level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `characters`
--

INSERT INTO `characters` (`character_id`, `user_id`, `character_name`, `class_name`, `level`) VALUES
(1, 3, 'Aliensvortex', 'Warlock', 58),
(2, 6, 'Diaboli', 'Mage', 45),
(3, 1, 'Duckdozer', 'Hunter', 60),
(4, 5, 'Larmax', 'Warrior', 60),
(5, 4, 'Gaiasis', 'Paladin', 39),
(6, 1, 'Duckmaster', 'Hunter', 60),
(7, 5, 'Jothan', 'Rogue', 60),
(8, 6, 'Impmazing', 'Warlock', 28),
(9, 6, 'Mamamia', 'Priest', 8),
(10, 1, 'Bullbilly', 'Warrior', 50),
(23, 3, 'Mirmir', 'Shaman', 60),
(28, 5, 'Anexis', 'Druid', 29);

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

CREATE TABLE `classes` (
  `class_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`class_name`) VALUES
('Druid'),
('Hunter'),
('Mage'),
('Paladin'),
('Priest'),
('Rogue'),
('Shaman'),
('Warlock'),
('Warrior');

-- --------------------------------------------------------

--
-- Table structure for table `class_abilities`
--

CREATE TABLE `class_abilities` (
  `class_ability_id` int(11) NOT NULL,
  `class_name` varchar(20) NOT NULL,
  `ability` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `class_abilities`
--

INSERT INTO `class_abilities` (`class_ability_id`, `class_name`, `ability`) VALUES
(1, 'Hunter', 'mark'),
(2, 'Hunter', 'poison_arrow'),
(3, 'Mage', 'firebolt'),
(4, 'Mage', 'froststrike'),
(5, 'Paladin', 'consecrate'),
(6, 'Paladin', 'taunt'),
(7, 'Priest', 'bless'),
(8, 'Priest', 'heal'),
(9, 'Rogue', 'stealth'),
(10, 'Rogue', 'vanish'),
(11, 'Rogue', 'backstab'),
(12, 'Shaman', 'summon_totem'),
(14, 'Warlock', 'siphon_soul'),
(15, 'Warlock', 'summon_imp'),
(16, 'warrior', 'taunt'),
(17, 'Warrior', 'charge'),
(18, 'Paladin', 'heal'),
(19, 'Druid', 'regrowth'),
(20, 'Druid', 'bear_form');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `first_name`, `last_name`, `email`, `username`, `password`) VALUES
(1, 'Olebrum', 'Duck', 'oleduck@gmail.com', 'Duckdozer', 'a1b2c3d4e5'),
(3, 'Ali', 'Jippikayey', 'aliensvortex@hotmail.com', 'Aliensvortex', 'anxltdm'),
(4, 'Trude', 'Thomassen', 'TTHomas@protonmail.com', 'Gaiasis', 'int.Rilda2503'),
(5, 'Thomas', 'Trudelutt', 'jothan.pos@gmail.com', 'Jothan', 'positronID01001'),
(6, 'Ohpapa', 'Salsa Di Mama', 'ohpapa@gmail.com', 'Impmazing', 'bretboy1998'),
(7, 'Happy', 'Mediadoc', 'happymediadoc@grogmail.com', 'mediadoc', 'codcod'),
(8, 'Jona', 'Postan', 'Sogn@stsdfsf.no', 'Minimoi', '12345'),
(12, 'Postman', 'Pat', 'awesome.pat@pstmnpt.no', 'Patastic', '11apata11');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`character_id`),
  ADD KEY `class_name` (`class_name`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`class_name`);

--
-- Indexes for table `class_abilities`
--
ALTER TABLE `class_abilities`
  ADD PRIMARY KEY (`class_ability_id`),
  ADD KEY `class` (`class_name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `characters`
--
ALTER TABLE `characters`
  MODIFY `character_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `class_abilities`
--
ALTER TABLE `class_abilities`
  MODIFY `class_ability_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `characters`
--
ALTER TABLE `characters`
  ADD CONSTRAINT `characters_ibfk_1` FOREIGN KEY (`class_name`) REFERENCES `classes` (`class_name`),
  ADD CONSTRAINT `characters_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `class_abilities`
--
ALTER TABLE `class_abilities`
  ADD CONSTRAINT `class_abilities_ibfk_1` FOREIGN KEY (`class_name`) REFERENCES `classes` (`class_name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
