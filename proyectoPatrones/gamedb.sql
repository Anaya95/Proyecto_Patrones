-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-04-2018 a las 03:44:25
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gamedb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avatar`
--

CREATE TABLE IF NOT EXISTS `avatar` (
  `avatarID` int(15) NOT NULL,
  `name` varchar(20) NOT NULL,
  `level` int(100) NOT NULL,
  `life` int(100) NOT NULL,
  `climber` int(100) NOT NULL,
  `swimmer` int(100) NOT NULL,
  `visibility` int(100) NOT NULL,
  `xCoord` int(100) NOT NULL,
  `yCoord` int(100) NOT NULL,
  `gameID` int(15) NOT NULL,
  PRIMARY KEY (`avatarID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `avatar`
--

INSERT INTO `avatar` (`avatarID`, `name`, `level`, `life`, `climber`, `swimmer`, `visibility`, `xCoord`, `yCoord`, `gameID`) VALUES
(1, 'Anaya', 3, 50, 20, 90, 69, 8, 12, 2),
(2, 'Valemova', 5, 80, 60, 20, 100, 11, 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dialog`
--

CREATE TABLE IF NOT EXISTS `dialog` (
  `dialogID` int(15) NOT NULL,
  `dialog` varchar(250) NOT NULL,
  `isNPCDialog` tinyint(1) NOT NULL,
  `missionID` int(15) NOT NULL,
  PRIMARY KEY (`dialogID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `dialog`
--

INSERT INTO `dialog` (`dialogID`, `dialog`, `isNPCDialog`, `missionID`) VALUES
(1, 'Tú: Morirás maldito dragón !!', 0, 2),
(2, '*FUEGO*', 1, 2),
(3, 'Tú: Te mataré !!', 0, 2),
(4, '*El drágón fue asesinado*', 1, 2),
(5, 'Tú: Nunca más serás un problema !', 0, 2),
(6, 'Herrero: Hola! bienvenido a la herrería de la ciudad!', 1, 1),
(7, 'Herrero: debes crear una espada para matar al dragón que resguarda el lago!', 1, 1),
(8, '...Creando espada', 1, 1),
(9, 'Espada lista!', 1, 1),
(10, 'Transporte: Súbete, salgamos de aquí!', 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game`
--

CREATE TABLE IF NOT EXISTS `game` (
  `gameID` int(15) NOT NULL,
  `avatarID` int(15) NOT NULL,
  `mapID` int(15) NOT NULL,
  PRIMARY KEY (`gameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `game`
--

INSERT INTO `game` (`gameID`, `avatarID`, `mapID`) VALUES
(1, 2, 1),
(2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gameforuser`
--

CREATE TABLE IF NOT EXISTS `gameforuser` (
  `userID` int(15) NOT NULL,
  `gameID` int(15) NOT NULL,
  PRIMARY KEY (`userID`,`gameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `gameforuser`
--

INSERT INTO `gameforuser` (`userID`, `gameID`) VALUES
(1, 2),
(2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `map`
--

CREATE TABLE IF NOT EXISTS `map` (
  `mapID` int(15) NOT NULL,
  `mapName` varchar(20) NOT NULL,
  PRIMARY KEY (`mapID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `map`
--

INSERT INTO `map` (`mapID`, `mapName`) VALUES
(1, 'map1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mission`
--

CREATE TABLE IF NOT EXISTS `mission` (
  `missionID` int(15) NOT NULL,
  `nameMission` varchar(50) NOT NULL,
  `identifierInMap` varchar(3) NOT NULL,
  `mapID` int(15) NOT NULL,
  PRIMARY KEY (`missionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `mission`
--

INSERT INTO `mission` (`missionID`, `nameMission`, `identifierInMap`, `mapID`) VALUES
(1, 'Crear espada', 'h', 1),
(2, 'Matar al dragón', 'D', 1),
(3, 'Salir de la ciudad', 'T', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `npc`
--

CREATE TABLE IF NOT EXISTS `npc` (
  `npcID` int(15) NOT NULL,
  `npcName` varchar(20) NOT NULL,
  `missionID` int(11) NOT NULL,
  PRIMARY KEY (`npcID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `npc`
--

INSERT INTO `npc` (`npcID`, `npcName`, `missionID`) VALUES
(1, 'Targaryen', 1),
(2, 'Uróboros', 2),
(3, 'Plutarco ', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `userID` int(15) NOT NULL,
  `name` varchar(20) NOT NULL,
  `lastname1` varchar(20) NOT NULL,
  `lastname2` varchar(20) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `pass` varchar(25) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`userID`, `name`, `lastname1`, `lastname2`, `email`, `pass`) VALUES
(1, 'Erick', 'Anaya', NULL, 'eanayac@ucenfotec.ac', '123'),
(2, 'Valeria', 'Morera', NULL, 'vmorerav@ucenfotec.a', '321');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
