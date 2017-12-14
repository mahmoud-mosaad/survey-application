-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2017 at 03:02 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ia_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `survey_counter`
--

CREATE TABLE `survey_counter` (
  `userID` varchar(32) NOT NULL,
  `surveyID` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey_counter`
--

INSERT INTO `survey_counter` (`userID`, `surveyID`) VALUES
('2c3885944df14edc9becf092c4ea7432', '09f4857e4a724d9883f35ee3620187e4'),
('2c3885944df14edc9becf092c4ea7432', 'e6763929a7c44a529438f4a673903d40'),
('2c3885944df14edc9becf092c4ea7432', '09f4857e4a724d9883f35ee3620187e4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `survey_counter`
--
ALTER TABLE `survey_counter`
  ADD KEY `surveyID` (`surveyID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `survey_counter`
--
ALTER TABLE `survey_counter`
  ADD CONSTRAINT `survey_counter_ibfk_1` FOREIGN KEY (`surveyID`) REFERENCES `survey` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
