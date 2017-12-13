-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2017 at 11:52 PM
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
-- Table structure for table `admin_msg`
--

CREATE TABLE `admin_msg` (
  `userID` varchar(32) NOT NULL,
  `msg` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_msg`
--

INSERT INTO `admin_msg` (`userID`, `msg`) VALUES
('c6fb53edc6244ceebed96225800fc0c6', 'mina'),
('c6fb53edc6244ceebed96225800fc0c6', 'minahhhhg'),
('c6fb53edc6244ceebed96225800fc0c6', 'hi from amdind'),
('36ea64fc1f8146f0b2fa330997f8d18f', 'hi all'),
('c6fb53edc6244ceebed96225800fc0c6', 'hi all'),
('f6aea3a570a2478b83ce4af3d4698ced', 'hi all'),
('f6aea3a570a2478b83ce4af3d4698ced', 'thanks'),
('3496521916874f1d9083ab8a1ce881b3', 'la 4okr 3la wagb ');

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `id` varchar(32) NOT NULL,
  `value` varchar(200) NOT NULL,
  `type` varchar(10) NOT NULL,
  `questionID` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`id`, `value`, `type`, `questionID`) VALUES
('0d6e79cf147542e281285ed59006334e', 'c-1-1', 'checkbox', 'ec28bc48fb854c1f869b6f07682a70cd'),
('64586e0d294047dbb2d3ab77ea0a4b6a', 'r-1', 'mcq', 'a3f06006f8154c91a4493f48da243ab4'),
('80fd9c2989b94c178576813997695fa9', 'r-1', 'mcq', 'a3f06006f8154c91a4493f48da243ab4'),
('af252c890401445ea49f4c3072481878', 'c-1-1', 'checkbox', 'ec28bc48fb854c1f869b6f07682a70cd');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` varchar(32) NOT NULL,
  `value` varchar(32) NOT NULL,
  `type` varchar(10) NOT NULL,
  `surveyID` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `value`, `type`, `surveyID`) VALUES
('749868612d06470aa7916efa28d736a1', 'f-1', 'freeanswer', '42a2afc3d3e94735821746dbfbc86a1b'),
('8ce17941e114403aa535e8af37c83989', 'f-2', 'freeanswer', '42a2afc3d3e94735821746dbfbc86a1b'),
('a3f06006f8154c91a4493f48da243ab4', 'r', 'mcq', '42a2afc3d3e94735821746dbfbc86a1b'),
('ec28bc48fb854c1f869b6f07682a70cd', 'c-1', 'checkbox', '42a2afc3d3e94735821746dbfbc86a1b');

-- --------------------------------------------------------

--
-- Table structure for table `spam`
--

CREATE TABLE `spam` (
  `userID` varchar(32) NOT NULL,
  `surveyID` varchar(32) NOT NULL,
  `spam` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spam`
--

INSERT INTO `spam` (`userID`, `surveyID`, `spam`) VALUES
('36ea64fc1f8146f0b2fa330997f8d18f', '84e86cc407b84056a1192f9738444526', 1),
('c6fb53edc6244ceebed96225800fc0c6', '3dce425fa2774e89bcd86268b3d7456c', 1);

-- --------------------------------------------------------

--
-- Table structure for table `survey`
--

CREATE TABLE `survey` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `description` text,
  `userID` varchar(32) NOT NULL,
  `suspend` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `survey`
--

INSERT INTO `survey` (`id`, `name`, `description`, `userID`, `suspend`) VALUES
('3dce425fa2774e89bcd86268b3d7456c', 'mina1', '', '36ea64fc1f8146f0b2fa330997f8d18f', 0),
('42a2afc3d3e94735821746dbfbc86a1b', 'newsda', 'asdsads', 'c6fb53edc6244ceebed96225800fc0c6', 1),
('84e86cc407b84056a1192f9738444526', 'mina', '', 'c6fb53edc6244ceebed96225800fc0c6', 0),
('be65da60c8954f2cb6956edc0aa21713', 'new survey', 'ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss', 'c6fb53edc6244ceebed96225800fc0c6', 0);

-- --------------------------------------------------------

--
-- Table structure for table `suspended_user_msg`
--

CREATE TABLE `suspended_user_msg` (
  `userID` varchar(32) NOT NULL,
  `msg` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `email` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `age` int(11) NOT NULL,
  `suspendMsg` varchar(100) DEFAULT NULL,
  `type` tinyint(1) NOT NULL,
  `suspended` tinyint(1) NOT NULL,
  `state` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `gender`, `age`, `suspendMsg`, `type`, `suspended`, `state`) VALUES
('3496521916874f1d9083ab8a1ce881b3', 'mahmoud', 'mahmoud@admin.com', '9bb840df7f699d6547f49fd6f9ed17b2d9dd34148f0b01e798d7c51da897ea1a', 'male', 18, '', 1, 0, 0),
('36ea64fc1f8146f0b2fa330997f8d18f', 'min', 'mina@mina.com', '9bb840df7f699d6547f49fd6f9ed17b2d9dd34148f0b01e798d7c51da897ea1a', 'male', 18, '', 0, 0, 0),
('c6fb53edc6244ceebed96225800fc0c6', 'mina', 'mina@user.com', '9bb840df7f699d6547f49fd6f9ed17b2d9dd34148f0b01e798d7c51da897ea1a', 'male', 18, '', 0, 0, 0),
('f6aea3a570a2478b83ce4af3d4698ced', 'admin', 'mina@admin.com', '9bb840df7f699d6547f49fd6f9ed17b2d9dd34148f0b01e798d7c51da897ea1a', 'male', 18, '', 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_answers`
--

CREATE TABLE `user_answers` (
  `userID` varchar(32) NOT NULL,
  `surveyID` varchar(32) NOT NULL,
  `questionID` varchar(32) NOT NULL,
  `answer` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_msg`
--
ALTER TABLE `admin_msg`
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `questionID` (`questionID`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `surveyID` (`surveyID`);

--
-- Indexes for table `spam`
--
ALTER TABLE `spam`
  ADD KEY `userID` (`userID`),
  ADD KEY `surveyID` (`surveyID`);

--
-- Indexes for table `survey`
--
ALTER TABLE `survey`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `suspended_user_msg`
--
ALTER TABLE `suspended_user_msg`
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_answers`
--
ALTER TABLE `user_answers`
  ADD KEY `userID` (`userID`),
  ADD KEY `surveyID` (`surveyID`),
  ADD KEY `questionID` (`questionID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin_msg`
--
ALTER TABLE `admin_msg`
  ADD CONSTRAINT `admin_msg_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`questionID`) REFERENCES `question` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`surveyID`) REFERENCES `survey` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `spam`
--
ALTER TABLE `spam`
  ADD CONSTRAINT `spam_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `spam_ibfk_2` FOREIGN KEY (`surveyID`) REFERENCES `survey` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `survey`
--
ALTER TABLE `survey`
  ADD CONSTRAINT `survey_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `suspended_user_msg`
--
ALTER TABLE `suspended_user_msg`
  ADD CONSTRAINT `suspended_user_msg_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `user_answers`
--
ALTER TABLE `user_answers`
  ADD CONSTRAINT `user_answers_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `user_answers_ibfk_2` FOREIGN KEY (`surveyID`) REFERENCES `survey` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_answers_ibfk_3` FOREIGN KEY (`questionID`) REFERENCES `question` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
