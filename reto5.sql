-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2021 at 01:00 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reto5`
--

-- --------------------------------------------------------

--
-- Table structure for table `baile`
--

CREATE TABLE `baile` (
  `bai_id` int(11) NOT NULL,
  `bai_nombre` char(30) NOT NULL,
  `bai_antiguedad` int(11) DEFAULT NULL,
  `bai_duracion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `baile`
--

INSERT INTO `baile` (`bai_id`, `bai_nombre`, `bai_antiguedad`, `bai_duracion`) VALUES
(102, 'Cumbia', 40, 5),
(102, 'Samba', 50, 5),
(102, 'Break dance', 30, 4),
(102, 'Salsa', 30, 4),
(102, 'Danza irlandesa', 34, 7),
(102, 'Arrow', 35, 6),
(102, 'Polca', 50, 6),
(102, 'Danza clasica', 56, 5);

-- --------------------------------------------------------

--
-- Table structure for table `cancion`
--

CREATE TABLE `cancion` (
  `ca_id` int(11) NOT NULL,
  `ca_nombre` char(30) DEFAULT NULL,
  `ca_genero` char(20) DEFAULT NULL,
  `ca_anio` year(4) DEFAULT NULL,
  `ca_cantante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cancion`
--

INSERT INTO `cancion` (`ca_id`, `ca_nombre`, `ca_genero`, `ca_anio`, `ca_cantante`) VALUES
(102, 'Amiga', 'Balada', 1990, 101),
(102, 'Las locuras mias', 'vallenato', 2019, 102),
(102, 'Gracias a ti', 'popular', 2020, 103),
(102, 'Tu', 'popular', 2019, 104),
(102, 'La gata bajo la lluvia', 'Balada', 1981, 105);

-- --------------------------------------------------------

--
-- Table structure for table `cantante`
--

CREATE TABLE `cantante` (
  `can_id` int(11) NOT NULL,
  `can_nombre` char(20) DEFAULT NULL,
  `can_apellido` char(20) DEFAULT NULL,
  `can_nacionalidad` char(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cantante`
--

INSERT INTO `cantante` (`can_id`, `can_nombre`, `can_apellido`, `can_nacionalidad`) VALUES
(101, 'Miguel', ' Bose', 'español'),
(102, 'Silvestre', 'Dangond', 'colombiano'),
(103, 'Jeison', 'Jiménez', 'colombiano'),
(104, 'Carin', 'León', 'mexicano'),
(105, 'Roció', 'Dúrcal', 'española');

-- --------------------------------------------------------

--
-- Table structure for table `concurso`
--

CREATE TABLE `concurso` (
  `con_id` int(11) NOT NULL,
  `con_nombre` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `concurso`
--

INSERT INTO `concurso` (`con_id`, `con_nombre`) VALUES
(101, 'canto'),
(102, 'bailo');

-- --------------------------------------------------------

--
-- Table structure for table `participacion`
--

CREATE TABLE `participacion` (
  `pn_id` int(11) NOT NULL,
  `pn_user` char(20) NOT NULL,
  `pn_concurso` int(11) NOT NULL,
  `pn_actuacion` char(30) NOT NULL,
  `pn_fecha` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `participacion`
--

INSERT INTO `participacion` (`pn_id`, `pn_user`, `pn_concurso`, `pn_actuacion`, `pn_fecha`) VALUES
(1001, 'rortiz', 101, 'Amiga', '2021-08-10 20:00:00'),
(1002, 'rortiz', 101, 'Tu', '2021-08-15 18:30:00'),
(1003, 'rortiz', 102, 'Salsa', '2021-08-20 20:30:18'),
(1004, 'paploper', 101, 'Amiga', '2021-08-10 20:30:00'),
(1005, 'nataper', 101, 'Gracias a ti', '2021-08-14 20:30:00'),
(1006, 'nataper', 102, 'Las locuras mías', '2018-08-15 21:30:00'),
(1007, 'nataper', 102, 'Cumbia', '2021-08-14 15:30:00'),
(1008, 'jaironi', 101, 'Cumbia', '2021-08-14 15:30:00'),
(1009, 'jaironi', 101, 'Samba', '2021-08-13 18:30:00'),
(1010, 'Jairve', 102, 'Break dance', '2021-08-16 20:30:00'),
(1011, 'Jairve', 102, 'Salsa', '2021-08-14 18:30:20'),
(1012, 'Jairve', 102, 'Flamenco', '2021-08-14 18:30:00'),
(1013, 'renegó', 101, 'Danza irlandesa', '2021-08-12 21:30:00'),
(1014, 'camiru', 102, 'Las locuras mías', '2021-08-13 17:30:00'),
(1015, 'camiru', 102, 'Tu', '2021-08-16 18:30:00'),
(1016, 'camiru', 102, 'La gata bajo la lluvia', '2021-08-16 18:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `participantes`
--

CREATE TABLE `participantes` (
  `par_login` char(20) NOT NULL,
  `par_nombre` char(20) DEFAULT NULL,
  `par_apellido` char(45) DEFAULT NULL,
  `par_email` char(45) DEFAULT NULL,
  `par_celular` varchar(10) DEFAULT NULL,
  `par_clave` char(45) DEFAULT NULL,
  `par_fecha_nto` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `participantes`
--

INSERT INTO `participantes` (`par_login`, `par_nombre`, `par_apellido`, `par_email`, `par_celular`, `par_clave`, `par_fecha_nto`) VALUES
('camiru', 'Camilo2', 'Rueda', 'camiru@gmail.com', '1234567890', 'nnn', '1997-08-08'),
('jaironi', 'JairoLuis', 'Nieto', 'jaironi@gmail.com', '1234567890', 'nnn', '1993-04-04'),
('Jairve', 'Jair', 'Velasco', 'Jairve@gmail.com', '1234567890', 'nnn', '1994-05-05'),
('luisco', 'Luis', 'Cortez', 'luisco@gmail.com', '1234567890', 'nnn', '1995-06-06'),
('nataper', 'Natali', 'Perez', 'nataper@gmail.com', '1234567890', 'nnn', '1992-03-03'),
('paploper', 'Pablo', 'Perez', 'paploper@gmail.com', '1234567890', 'nnn', '1991-02-02'),
('renegó', 'Rene', 'Gómez', 'renegó@gmail.com', '1234567890', 'nnn', '1996-07-07'),
('rortiz', 'Roberto', 'Ortiz', 'rortiz@gmail.com', '1234567890', 'nada', '1990-01-01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `baile`
--
ALTER TABLE `baile`
  ADD KEY `bai_id` (`bai_id`);

--
-- Indexes for table `cancion`
--
ALTER TABLE `cancion`
  ADD KEY `ca_id` (`ca_id`),
  ADD KEY `ca_cantante` (`ca_cantante`);

--
-- Indexes for table `cantante`
--
ALTER TABLE `cantante`
  ADD PRIMARY KEY (`can_id`);

--
-- Indexes for table `concurso`
--
ALTER TABLE `concurso`
  ADD PRIMARY KEY (`con_id`);

--
-- Indexes for table `participacion`
--
ALTER TABLE `participacion`
  ADD PRIMARY KEY (`pn_id`),
  ADD KEY `pn_concurso` (`pn_concurso`),
  ADD KEY `pn_user` (`pn_user`);

--
-- Indexes for table `participantes`
--
ALTER TABLE `participantes`
  ADD PRIMARY KEY (`par_login`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `baile`
--
ALTER TABLE `baile`
  ADD CONSTRAINT `baile_ibfk_1` FOREIGN KEY (`bai_id`) REFERENCES `concurso` (`con_id`);

--
-- Constraints for table `cancion`
--
ALTER TABLE `cancion`
  ADD CONSTRAINT `cancion_ibfk_1` FOREIGN KEY (`ca_id`) REFERENCES `concurso` (`con_id`),
  ADD CONSTRAINT `cancion_ibfk_2` FOREIGN KEY (`ca_cantante`) REFERENCES `cantante` (`can_id`);

--
-- Constraints for table `participacion`
--
ALTER TABLE `participacion`
  ADD CONSTRAINT `participacion_ibfk_1` FOREIGN KEY (`pn_concurso`) REFERENCES `concurso` (`con_id`),
  ADD CONSTRAINT `participacion_ibfk_2` FOREIGN KEY (`pn_user`) REFERENCES `participantes` (`par_login`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
