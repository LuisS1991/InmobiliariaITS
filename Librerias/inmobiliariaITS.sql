-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 12-10-2023 a las 19:49:28
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inmobiliariaITS`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Alquiler`
--

CREATE TABLE `Alquiler` (
  `NroContrato` int(11) NOT NULL,
  `FechaInicioAlquiler` date DEFAULT NULL,
  `FechaFinAlquiler` date DEFAULT NULL,
  `Garantia` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

CREATE TABLE `Cliente` (
  `CI` int(11) NOT NULL,
  `NombreCompleto` varchar(255) DEFAULT NULL,
  `FechaNac` date DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Compra`
--

CREATE TABLE `Compra` (
  `NroContrato` int(11) NOT NULL,
  `FechaCompra` date DEFAULT NULL,
  `FechaVenta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Contrato`
--

CREATE TABLE `Contrato` (
  `NroContrato` int(11) NOT NULL,
  `Autorizacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ContratosClientes`
--

CREATE TABLE `ContratosClientes` (
  `CI` int(11) DEFAULT NULL,
  `NroContrato` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ContratosInmubles`
--

CREATE TABLE `ContratosInmubles` (
  `NroPadron` int(11) DEFAULT NULL,
  `NroContrato` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Habitable`
--

CREATE TABLE `Habitable` (
  `NroPadron` int(11) NOT NULL,
  `CantCuarto` varchar(255) DEFAULT NULL,
  `CantBano` int(11) DEFAULT NULL,
  `OtrosHabitaciones` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Inmueble`
--

CREATE TABLE `Inmueble` (
  `NroPadron` int(11) NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `nroPuerta` int(11) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `tipoInmueble` varchar(255) DEFAULT NULL,
  `tamano` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `InmueblesClientes`
--

CREATE TABLE `InmueblesClientes` (
  `CI` int(11) NOT NULL,
  `NroPadron` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Terreno`
--

CREATE TABLE `Terreno` (
  `NroPadron` int(11) NOT NULL,
  `servicios` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE `Usuario` (
  `id` int(11) NOT NULL,
  `NombreUsuario` varchar(255) DEFAULT NULL,
  `PassUsuario` varchar(255) DEFAULT NULL,
  `RolUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`id`, `NombreUsuario`, `PassUsuario`, `RolUsuario`) VALUES
(1, 'Luis Nantes', '123', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Alquiler`
--
ALTER TABLE `Alquiler`
  ADD PRIMARY KEY (`NroContrato`);

--
-- Indices de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`CI`);

--
-- Indices de la tabla `Compra`
--
ALTER TABLE `Compra`
  ADD PRIMARY KEY (`NroContrato`);

--
-- Indices de la tabla `Contrato`
--
ALTER TABLE `Contrato`
  ADD PRIMARY KEY (`NroContrato`);

--
-- Indices de la tabla `ContratosClientes`
--
ALTER TABLE `ContratosClientes`
  ADD KEY `CI` (`CI`),
  ADD KEY `NroContrato` (`NroContrato`);

--
-- Indices de la tabla `ContratosInmubles`
--
ALTER TABLE `ContratosInmubles`
  ADD KEY `NroContrato` (`NroContrato`),
  ADD KEY `NroPadron` (`NroPadron`);

--
-- Indices de la tabla `Habitable`
--
ALTER TABLE `Habitable`
  ADD PRIMARY KEY (`NroPadron`);

--
-- Indices de la tabla `Inmueble`
--
ALTER TABLE `Inmueble`
  ADD PRIMARY KEY (`NroPadron`);

--
-- Indices de la tabla `InmueblesClientes`
--
ALTER TABLE `InmueblesClientes`
  ADD PRIMARY KEY (`CI`,`NroPadron`),
  ADD KEY `NroPadron` (`NroPadron`);

--
-- Indices de la tabla `Terreno`
--
ALTER TABLE `Terreno`
  ADD PRIMARY KEY (`NroPadron`);

--
-- Indices de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Compra`
--
ALTER TABLE `Compra`
  ADD CONSTRAINT `Compra_ibfk_1` FOREIGN KEY (`NroContrato`) REFERENCES `Contrato` (`NroContrato`);

--
-- Filtros para la tabla `Contrato`
--
ALTER TABLE `Contrato`
  ADD CONSTRAINT `Contrato_ibfk_1` FOREIGN KEY (`NroContrato`) REFERENCES `Compra` (`NroContrato`),
  ADD CONSTRAINT `Contrato_ibfk_2` FOREIGN KEY (`NroContrato`) REFERENCES `Alquiler` (`NroContrato`);

--
-- Filtros para la tabla `ContratosClientes`
--
ALTER TABLE `ContratosClientes`
  ADD CONSTRAINT `ContratosClientes_ibfk_1` FOREIGN KEY (`CI`) REFERENCES `Cliente` (`CI`),
  ADD CONSTRAINT `ContratosClientes_ibfk_2` FOREIGN KEY (`NroContrato`) REFERENCES `Contrato` (`NroContrato`);

--
-- Filtros para la tabla `ContratosInmubles`
--
ALTER TABLE `ContratosInmubles`
  ADD CONSTRAINT `ContratosInmubles_ibfk_1` FOREIGN KEY (`NroContrato`) REFERENCES `Contrato` (`NroContrato`),
  ADD CONSTRAINT `ContratosInmubles_ibfk_2` FOREIGN KEY (`NroPadron`) REFERENCES `Inmueble` (`NroPadron`);

--
-- Filtros para la tabla `Habitable`
--
ALTER TABLE `Habitable`
  ADD CONSTRAINT `Habitable_ibfk_1` FOREIGN KEY (`NroPadron`) REFERENCES `Inmueble` (`NroPadron`);

--
-- Filtros para la tabla `Inmueble`
--
ALTER TABLE `Inmueble`
  ADD CONSTRAINT `Inmueble_ibfk_1` FOREIGN KEY (`NroPadron`) REFERENCES `Terreno` (`NroPadron`),
  ADD CONSTRAINT `Inmueble_ibfk_2` FOREIGN KEY (`NroPadron`) REFERENCES `Habitable` (`NroPadron`);

--
-- Filtros para la tabla `InmueblesClientes`
--
ALTER TABLE `InmueblesClientes`
  ADD CONSTRAINT `InmueblesClientes_ibfk_1` FOREIGN KEY (`CI`) REFERENCES `Cliente` (`CI`),
  ADD CONSTRAINT `InmueblesClientes_ibfk_2` FOREIGN KEY (`NroPadron`) REFERENCES `Inmueble` (`NroPadron`);

--
-- Filtros para la tabla `Terreno`
--
ALTER TABLE `Terreno`
  ADD CONSTRAINT `Terreno_ibfk_1` FOREIGN KEY (`NroPadron`) REFERENCES `Inmueble` (`NroPadron`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
