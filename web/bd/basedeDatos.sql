GRANT ALL PRIVILEGES ON *.* TO 'marketplaceuser'@'localhost' IDENTIFIED BY PASSWORD '*A109EAC988A17594077E5AF1D60099FDCB0683CC' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON `marketplace`.* TO 'marketplaceuser'@'localhost' WITH GRANT OPTION;
--usuario: marketplaceuser
--password: marketplaceuser
create database marketplace;
use marketplace;
-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-03-2014 a las 06:24:35
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `marketplace`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `adjuntos`
--

CREATE TABLE IF NOT EXISTS `adjuntos` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria de los adjuntos',
  `descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'descripcion del paquete de adjuntos',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tabla de adjuntos' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivos`
--

CREATE TABLE IF NOT EXISTS `archivos` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria del archivo adjunto',
  `tipo` varchar(20) COLLATE utf8_spanish_ci NOT NULL COMMENT 'tipo de adjunto',
  `ruta` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'ruta del archivo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivosadjuntos`
--

CREATE TABLE IF NOT EXISTS `archivosadjuntos` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria de los adjuntos',
  `idAdjunto` int(11) NOT NULL COMMENT 'id del adjunto',
  `idArchivo` int(11) NOT NULL COMMENT 'id del archivo',
  PRIMARY KEY (`id`),
  KEY `fk_idAdjuntosArchivosAdjuntosAdjuntos` (`idAdjunto`),
  KEY `fk_idArchivoArchivosAdjuntosArchivo` (`idArchivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tablas de archivos adjuntos' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria de las categorias',
  `descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'descripcion de la categoria',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tabla de categorias' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menus`
--

CREATE TABLE IF NOT EXISTS `menus` (
  `id` int(11) NOT NULL COMMENT 'Id del menu',
  `idPadre` int(11) DEFAULT NULL COMMENT 'Id del menu padre',
  `descripcion` varchar(20) COLLATE utf8_spanish_ci NOT NULL COMMENT 'Descripcion de la opcion de menu',
  `enlace` varchar(50) COLLATE utf8_spanish_ci NOT NULL COMMENT 'Enlace al formulario principal',
  `estado` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Estado del menu',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE IF NOT EXISTS `ofertas` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria de las ofertas',
  `descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'descripcion de la oferta',
  `idPaquete` int(11) NOT NULL COMMENT 'id del paquete',
  `fechaInicial` date NOT NULL COMMENT 'fecha inicial de la oferta',
  `fechaFinal` date NOT NULL COMMENT 'fecha final de la oferta',
  `valor` int(11) NOT NULL COMMENT 'valor de la oferta',
  PRIMARY KEY (`id`),
  KEY `fk_idPaqueteOfertasPaquetes` (`idPaquete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tabla de ofertas' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes`
--

CREATE TABLE IF NOT EXISTS `paquetes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria de los paquetes',
  `idProveedor` int(11) NOT NULL COMMENT 'id proveedor',
  `descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'descripcion del paquete',
  `valor` double NOT NULL COMMENT 'valor del paquete',
  `estado` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'estado del paquete',
  PRIMARY KEY (`id`),
  KEY `fk_idProveedorPaquetesUsuarios` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tabla de paquetes' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetesdeservicios`
--

CREATE TABLE IF NOT EXISTS `paquetesdeservicios` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria de los paquetes de servicio',
  `idPaquete` int(11) NOT NULL COMMENT 'id Paquete',
  `idServicio` int(11) NOT NULL COMMENT 'id de los servicios',
  `estado` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'estado del paquete de servicios',
  PRIMARY KEY (`id`),
  KEY `fk_idPaquetePaquetedeServiciosPaquetes` (`idPaquete`),
  KEY `fk_idServicioPaquetesdeServicioServicios` (`idServicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tabla de paquetes de servicios' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE IF NOT EXISTS `perfiles` (
  `id` int(11) NOT NULL COMMENT 'Id del perfil',
  `descripcion` varchar(50) COLLATE utf8_spanish_ci NOT NULL COMMENT 'Descripcion del perfil',
  `estado` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Estado del perfil',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='Tabla de perfiles';

--
-- Volcado de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`id`, `descripcion`, `estado`) VALUES
(1, 'Administrador', 1),
(2, 'Usuario', 1),
(3, 'Proveedores', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE IF NOT EXISTS `permisos` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id del permiso',
  `idPerfil` int(11) NOT NULL COMMENT 'id del Perfil',
  `opciones` varchar(50) COLLATE utf8_spanish_ci NOT NULL COMMENT 'id opciones de menu separadas por el simbolo ,',
  PRIMARY KEY (`id`),
  KEY `fk_idPerfilPermisosPerfiles` (`idPerfil`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tabla de permisos' AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE IF NOT EXISTS `preguntas` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria preguntas',
  `idUsuario` int(11) NOT NULL COMMENT 'id del usuario',
  `idProveedor` int(11) NOT NULL COMMENT 'Id del proveedor',
  `pregunta` text COLLATE utf8_spanish_ci NOT NULL COMMENT 'pregunta realizada',
  `respuesta` text COLLATE utf8_spanish_ci NOT NULL COMMENT 'respuesta a la pregunta',
  `estado` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'estado de la pregunta',
  PRIMARY KEY (`id`),
  KEY `fk_idUsuarioPreguntasUsuarios` (`idUsuario`),
  KEY `kf_idProveedorPreguntasUsuarios` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tabla de preguntas' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE IF NOT EXISTS `servicios` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria',
  `idCategoria` int(11) NOT NULL COMMENT 'id de la categoria',
  `descripcion` varchar(30) COLLATE utf8_spanish_ci NOT NULL COMMENT 'descripcion del servicio',
  `idAdjunto` int(11) NOT NULL COMMENT 'id del adjunto',
  `valor` bigint(20) NOT NULL COMMENT 'valor del servicio',
  `estado` int(11) NOT NULL COMMENT 'estado del servicio',
  PRIMARY KEY (`id`),
  KEY `fk_idCategoriaServiciosCategorias` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tabla de servicios' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transacciones`
--

CREATE TABLE IF NOT EXISTS `transacciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria',
  `idUsuario` int(11) NOT NULL COMMENT 'id del usuario',
  `idPaquete` int(11) DEFAULT NULL COMMENT 'id del paquete',
  `idServicio` int(11) DEFAULT NULL COMMENT 'id del servicio',
  `idOferta` int(11) DEFAULT NULL COMMENT 'id de la oferta',
  `fechaTransaccion` date NOT NULL COMMENT 'fecha de la transaccion',
  PRIMARY KEY (`id`),
  KEY `fk_idUsuarioTransaccionesUsuarios` (`idUsuario`),
  KEY `fk_idPaqueteTransaccionesPaquete` (`idPaquete`),
  KEY `fk_idServicioTransaccionesServicios` (`idServicio`),
  KEY `fk_idOfertaTransaccionesOfertas` (`idOferta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci COMMENT='tabla de transacciones' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL,
  `primerNombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `segundoNombre` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `primerApellido` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `segundoApellido` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nickname` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `idPerfil` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_idPerfilUsuariosPerfiles` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `primerNombre`, `segundoNombre`, `primerApellido`, `segundoApellido`, `nickname`, `contrasena`, `correo`, `idPerfil`, `estado`) VALUES
(1016036869, 'sebastian', 'ricardo', 'rojas', 'narvaez', 'azulsebas', 'sebastian', 'azulsebas123@gmail.com', 1, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `archivosadjuntos`
--
ALTER TABLE `archivosadjuntos`
  ADD CONSTRAINT `fk_idAdjuntosArchivosAdjuntosAdjuntos` FOREIGN KEY (`idAdjunto`) REFERENCES `adjuntos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_idArchivoArchivosAdjuntosArchivo` FOREIGN KEY (`idArchivo`) REFERENCES `archivos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD CONSTRAINT `fk_idPaqueteOfertasPaquetes` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `paquetes`
--
ALTER TABLE `paquetes`
  ADD CONSTRAINT `fk_idProveedorPaquetesUsuarios` FOREIGN KEY (`idProveedor`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `paquetesdeservicios`
--
ALTER TABLE `paquetesdeservicios`
  ADD CONSTRAINT `fk_idPaquetePaquetedeServiciosPaquetes` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_idServicioPaquetesdeServicioServicios` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD CONSTRAINT `fk_idPerfilPermisosPerfiles` FOREIGN KEY (`idPerfil`) REFERENCES `perfiles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD CONSTRAINT `fk_idUsuarioPreguntasUsuarios` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `kf_idProveedorPreguntasUsuarios` FOREIGN KEY (`idProveedor`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD CONSTRAINT `fk_idCategoriaServiciosCategorias` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `transacciones`
--
ALTER TABLE `transacciones`
  ADD CONSTRAINT `fk_idUsuarioTransaccionesUsuarios` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_idPaqueteTransaccionesPaquete` FOREIGN KEY (`idPaquete`) REFERENCES `paquetes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_idServicioTransaccionesServicios` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_idOfertaTransaccionesOfertas` FOREIGN KEY (`idOferta`) REFERENCES `ofertas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_idPerfilUsuariosPerfiles` FOREIGN KEY (`idPerfil`) REFERENCES `perfiles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
