-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 30-06-2023 a las 14:06:45
-- Versión del servidor: 8.0.33
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `portfolio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

DROP TABLE IF EXISTS `cursos`;
CREATE TABLE IF NOT EXISTS `cursos` (
  `id` int NOT NULL,
  `name_curso` varchar(100) DEFAULT NULL,
  `url_curso` varchar(100) DEFAULT NULL,
  `url_certificado` varchar(100) DEFAULT NULL,
  `educacion_id` int NOT NULL,
  `educacion_Persona_id` int NOT NULL,
  PRIMARY KEY (`id`,`educacion_id`,`educacion_Persona_id`),
  KEY `fk_Curso_educacion1_idx` (`educacion_id`,`educacion_Persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id`, `name_curso`, `url_curso`, `url_certificado`, `educacion_id`, `educacion_Persona_id`) VALUES
(1, 'Universidad HTML - Aprende HTML desde Cero hasta Experto', 'https://www.udemy.com/course/universidad-html-aprende-html-desde-cero-hasta-experto-css-html5', '/assets/pdf/Universidad HTML - Aprende HTML desde Cero hasta Experto.pdf', 1, 1),
(2, 'Universidad CSS - Aprende CSS desde Cero hasta Experto', 'https://www.udemy.com/course/universidad-css-aprende-css-desde-cero-flexbox-responsive-web-desing', '/assets/pdf/Universidad CSS - Aprende CSS desde Cero hasta Experto.pdf', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos_seq`
--

DROP TABLE IF EXISTS `cursos_seq`;
CREATE TABLE IF NOT EXISTS `cursos_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `cursos_seq`
--

INSERT INTO `cursos_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `educacion`
--

DROP TABLE IF EXISTS `educacion`;
CREATE TABLE IF NOT EXISTS `educacion` (
  `id` int NOT NULL,
  `Persona_id` int NOT NULL,
  PRIMARY KEY (`id`,`Persona_id`),
  KEY `fk_educacion_Persona1_idx` (`Persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `educacion`
--

INSERT INTO `educacion` (`id`, `Persona_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `educacion_seq`
--

DROP TABLE IF EXISTS `educacion_seq`;
CREATE TABLE IF NOT EXISTS `educacion_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `educacion_seq`
--

INSERT INTO `educacion_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia`
--

DROP TABLE IF EXISTS `experiencia`;
CREATE TABLE IF NOT EXISTS `experiencia` (
  `id` int NOT NULL,
  `nombre_empresa` varchar(100) DEFAULT NULL,
  `puesto_trabajo` varchar(100) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `Persona_id` int NOT NULL,
  PRIMARY KEY (`id`,`Persona_id`),
  KEY `fk_experiencia_Persona_idx` (`Persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia_seq`
--

DROP TABLE IF EXISTS `experiencia_seq`;
CREATE TABLE IF NOT EXISTS `experiencia_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `experiencia_seq`
--

INSERT INTO `experiencia_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
CREATE TABLE IF NOT EXISTS `mensajes` (
  `id` int NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apellido` varchar(60) DEFAULT NULL,
  `celular` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `mensaje` varchar(300) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `Persona_id` int NOT NULL,
  PRIMARY KEY (`id`,`Persona_id`),
  KEY `fk_Mensajes_Persona1_idx` (`Persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes_seq`
--

DROP TABLE IF EXISTS `mensajes_seq`;
CREATE TABLE IF NOT EXISTS `mensajes_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `mensajes_seq`
--

INSERT INTO `mensajes_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mis_habilidades`
--

DROP TABLE IF EXISTS `mis_habilidades`;
CREATE TABLE IF NOT EXISTS `mis_habilidades` (
  `id` int NOT NULL,
  `lenguaje` varchar(45) DEFAULT NULL,
  `porcentaje` varchar(10) DEFAULT NULL,
  `Persona_id` int NOT NULL,
  PRIMARY KEY (`id`,`Persona_id`),
  KEY `fk_misHabilidades_Persona1_idx` (`Persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `mis_habilidades`
--

INSERT INTO `mis_habilidades` (`id`, `lenguaje`, `porcentaje`, `Persona_id`) VALUES
(1, 'HTML5', '100', 1),
(2, 'CSS3', '60', 1),
(3, 'bootstrap5', '80', 1),
(4, 'JavaScript', '40', 1),
(5, 'TypeScript', '50', 1),
(6, 'python', '70', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mis_habilidades_seq`
--

DROP TABLE IF EXISTS `mis_habilidades_seq`;
CREATE TABLE IF NOT EXISTS `mis_habilidades_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `mis_habilidades_seq`
--

INSERT INTO `mis_habilidades_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
CREATE TABLE IF NOT EXISTS `proyectos` (
  `id` int NOT NULL,
  `name_proyectos` varchar(100) DEFAULT NULL,
  `url_proyectos` varchar(100) DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `Persona_id` int NOT NULL,
  PRIMARY KEY (`id`,`Persona_id`),
  KEY `fk_proyectos_Persona1_idx` (`Persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`id`, `name_proyectos`, `url_proyectos`, `descripcion`, `Persona_id`) VALUES
(1, 'practica algoritmos python', '', '', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos_seq`
--

DROP TABLE IF EXISTS `proyectos_seq`;
CREATE TABLE IF NOT EXISTS `proyectos_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `proyectos_seq`
--

INSERT INTO `proyectos_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `redes_sociales`
--

DROP TABLE IF EXISTS `redes_sociales`;
CREATE TABLE IF NOT EXISTS `redes_sociales` (
  `id` int NOT NULL,
  `instagram` varchar(75) DEFAULT NULL,
  `linkedin` varchar(75) DEFAULT NULL,
  `facebook` varchar(75) DEFAULT NULL,
  `Persona_id` int NOT NULL,
  PRIMARY KEY (`id`,`Persona_id`),
  KEY `fk_RedesSociales_Persona1_idx` (`Persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `redes_sociales`
--

INSERT INTO `redes_sociales` (`id`, `instagram`, `linkedin`, `facebook`, `Persona_id`) VALUES
(1, 'https://www.instagram.com/augusto1.ger/', 'https://www.linkedin.com/in/augusto-gervasoni-18612a191/', 'https://www.facebook.com/augustoosca', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `redes_sociales_seq`
--

DROP TABLE IF EXISTS `redes_sociales_seq`;
CREATE TABLE IF NOT EXISTS `redes_sociales_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `redes_sociales_seq`
--

INSERT INTO `redes_sociales_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `rol_nombre`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sobre_mi`
--

DROP TABLE IF EXISTS `sobre_mi`;
CREATE TABLE IF NOT EXISTS `sobre_mi` (
  `id` int NOT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `fecha_de_nacimiento` date DEFAULT NULL,
  `descripcion` varchar(400) DEFAULT NULL,
  `url_foto` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `sobre_mi`
--

INSERT INTO `sobre_mi` (`id`, `nombre`, `fecha_de_nacimiento`, `descripcion`, `url_foto`) VALUES
(1, 'Augusto Gervasoni', '2001-04-10', 'Soy un Full Stack Developer Jr', '/assets/img/cat.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sobre_mi_seq`
--

DROP TABLE IF EXISTS `sobre_mi_seq`;
CREATE TABLE IF NOT EXISTS `sobre_mi_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `sobre_mi_seq`
--

INSERT INTO `sobre_mi_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `universidad`
--

DROP TABLE IF EXISTS `universidad`;
CREATE TABLE IF NOT EXISTS `universidad` (
  `id` int NOT NULL,
  `name_universidad` varchar(60) DEFAULT NULL,
  `name_carrera` varchar(60) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `historial_academico` varchar(75) DEFAULT NULL,
  `educacion_id` int NOT NULL,
  `educacion_Persona_id` int NOT NULL,
  `name_cursos` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`educacion_id`,`educacion_Persona_id`,`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `universidad`
--

INSERT INTO `universidad` (`id`, `name_universidad`, `name_carrera`, `fecha_inicio`, `fecha_fin`, `historial_academico`, `educacion_id`, `educacion_Persona_id`, `name_cursos`) VALUES
(1, 'Universidad Autonoma de Entre Rios (UADER)', 'Licenciatura en Sistemas de Información', '2020-01-01', '2023-01-01', '/assets/pdf/historia_academica.pdf', 1, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `universidad_seq`
--

DROP TABLE IF EXISTS `universidad_seq`;
CREATE TABLE IF NOT EXISTS `universidad_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `universidad_seq`
--

INSERT INTO `universidad_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_puhr3k3l7bj71hb7hk7ktpxn0` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `email`, `nombre`, `nombre_usuario`, `password`) VALUES
(1, 'admin@admin.com', 'admin', 'admin', '$2a$10$90Hp0S62Jlnw8YlDScyJMOd2lLL0kiPU.ro0NIapQsrXmLYBwsoza'),
(2, 'user@user.com', 'user', 'user', '$2a$10$YYY966qNqUE5BGJMA4Lva.MsGsn6sZH8NsntlRVinb7WgRCXmq7HG');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
CREATE TABLE IF NOT EXISTS `usuario_rol` (
  `usuario_id` int NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`usuario_id`,`rol_id`),
  KEY `FK610kvhkwcqk2pxeewur4l7bd1` (`rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`usuario_id`, `rol_id`) VALUES
(1, 1),
(1, 2),
(2, 2);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `fk_Curso_educacion1` FOREIGN KEY (`educacion_id`,`educacion_Persona_id`) REFERENCES `educacion` (`id`, `Persona_id`);

--
-- Filtros para la tabla `educacion`
--
ALTER TABLE `educacion`
  ADD CONSTRAINT `fk_educacion_Persona1` FOREIGN KEY (`Persona_id`) REFERENCES `sobre_mi` (`id`);

--
-- Filtros para la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD CONSTRAINT `fk_experiencia_Persona` FOREIGN KEY (`Persona_id`) REFERENCES `sobre_mi` (`id`);

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `fk_Mensajes_Persona1` FOREIGN KEY (`Persona_id`) REFERENCES `sobre_mi` (`id`);

--
-- Filtros para la tabla `mis_habilidades`
--
ALTER TABLE `mis_habilidades`
  ADD CONSTRAINT `fk_misHabilidades_Persona1` FOREIGN KEY (`Persona_id`) REFERENCES `sobre_mi` (`id`);

--
-- Filtros para la tabla `proyectos`
--
ALTER TABLE `proyectos`
  ADD CONSTRAINT `fk_proyectos_Persona1` FOREIGN KEY (`Persona_id`) REFERENCES `sobre_mi` (`id`);

--
-- Filtros para la tabla `redes_sociales`
--
ALTER TABLE `redes_sociales`
  ADD CONSTRAINT `fk_RedesSociales_Persona1` FOREIGN KEY (`Persona_id`) REFERENCES `sobre_mi` (`id`);

--
-- Filtros para la tabla `universidad`
--
ALTER TABLE `universidad`
  ADD CONSTRAINT `fk_Universidad_educacion1` FOREIGN KEY (`educacion_id`,`educacion_Persona_id`) REFERENCES `educacion` (`id`, `Persona_id`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `FK610kvhkwcqk2pxeewur4l7bd1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  ADD CONSTRAINT `FKbyfgloj439r9wr9smrms9u33r` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
