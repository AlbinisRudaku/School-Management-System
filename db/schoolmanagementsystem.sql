

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `schoolmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
CREATE TABLE IF NOT EXISTS `grades` (
  `gradeId` int(10) NOT NULL,
  `grade` varchar(30) NOT NULL,
  `noOfStudents` int(100) DEFAULT NULL,
  PRIMARY KEY (`gradeId`))
   ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`gradeId`, `grade`, `noOfStudents`) VALUES
(1, 'Year 1', NULL),
(2, 'Year 2', NULL),
(3, 'Year 3', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `schoolinfo`
--

DROP TABLE IF EXISTS `schoolinfo`;
CREATE TABLE IF NOT EXISTS `schoolinfo` (
  `SchoolName` varchar(80) DEFAULT NULL,
  `SchoolAddress` varchar(80) DEFAULT NULL,
  `classAvailable` varchar(20) DEFAULT NULL,
  `postalCode` varchar(10) NOT NULL,
  `dateOfEstd` date DEFAULT NULL,
  `totalLandArea` varchar(30) NOT NULL,
  `province` varchar(30) NOT NULL,
  `nameOfPrincipal` varchar(30) NOT NULL,
  `pricipalNo` varchar(10) NOT NULL)
   ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

DROP TABLE IF EXISTS `staffs`;
CREATE TABLE IF NOT EXISTS `staffs` (
  `empNo` varchar(10) NOT NULL,
  `teacherName` varchar(60) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT '-',
  `assumpOfDuties` date DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `prsntGrade` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`empNo`))
   ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE IF NOT EXISTS `students` (
  `adNo` int(11) NOT NULL,
  `fullName` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `doa` date DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `grade` varchar(15) DEFAULT NULL,
  `parentName` varchar(60) DEFAULT NULL,
  `nic` char(10) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`adNo`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('admin', 'admin'),
('teacher', 'admin');
('albinisi', 'admin');
('yllka', 'admin');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
