SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `portfolio` DEFAULT CHARACTER SET utf8 ;
USE `portfolio` ;

CREATE TABLE IF NOT EXISTS `portfolio`.`sobre_mi` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(60) NULL,
  `fecha_de_nacimiento` DATE NULL,
  `descripcion` VARCHAR(400) NULL,
  `url_foto` VARCHAR(75) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`experiencia` (
  `id` INT NOT NULL,
  `nombre_empresa` VARCHAR(100) NULL,
  `puesto_trabajo` VARCHAR(100) NULL,
  `fecha_inicio` DATE NULL,
  `fecha_fin` DATE NULL,
  `descripcion` VARCHAR(300) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Persona_id`),
  INDEX `fk_experiencia_Persona_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_experiencia_Persona`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `portfolio`.`sobre_mi` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`educacion` (
  `id` INT NOT NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Persona_id`),
  INDEX `fk_educacion_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_educacion_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `portfolio`.`sobre_mi` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`universidad` (
  `id` INT NOT NULL,
  `name_universidad` VARCHAR(60) NULL,
  `name_carrera` VARCHAR(60) NULL,
  `fecha_inicio` DATE NULL,
  `fecha_fin` DATE NULL,
  `historial_academico` VARCHAR(75) NULL,
  `educacion_id` INT NOT NULL,
  `educacion_Persona_id` INT NOT NULL,
  PRIMARY KEY (`educacion_id`, `educacion_Persona_id`, `id`),
  CONSTRAINT `fk_Universidad_educacion1`
    FOREIGN KEY (`educacion_id` , `educacion_Persona_id`)
    REFERENCES `portfolio`.`educacion` (`id` , `Persona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`cursos` (
  `id` INT NOT NULL,
  `name_curso` VARCHAR(100) NULL,
  `url_curso` VARCHAR(100) NULL,
  `url_certificado` VARCHAR(100) NULL,
  `educacion_id` INT NOT NULL,
  `educacion_Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `educacion_id`, `educacion_Persona_id`),
  INDEX `fk_Curso_educacion1_idx` (`educacion_id` ASC, `educacion_Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Curso_educacion1`
    FOREIGN KEY (`educacion_id` , `educacion_Persona_id`)
    REFERENCES `portfolio`.`educacion` (`id` , `Persona_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`mis_habilidades` (
  `id` INT NOT NULL,
  `lenguaje` VARCHAR(45) NULL,
  `porcentaje` VARCHAR(10) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Persona_id`),
  INDEX `fk_misHabilidades_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_misHabilidades_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `portfolio`.`sobre_mi` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`proyectos` (
  `id` INT NOT NULL,
  `name_proyectos` VARCHAR(100) NULL,
  `url_proyectos` VARCHAR(100) NULL,
  `descripcion` VARCHAR(300) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Persona_id`),
  INDEX `fk_proyectos_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_proyectos_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `portfolio`.`sobre_mi` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`mensajes` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(60) NULL,
  `apellido` VARCHAR(60) NULL,
  `celular` VARCHAR(60) NULL,
  `email` VARCHAR(60) NULL,
  `mensaje` VARCHAR(300) NULL,
  `fecha` DATE NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Persona_id`),
  INDEX `fk_Mensajes_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_Mensajes_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `portfolio`.`sobre_mi` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`redes_sociales` (
  `id` INT NOT NULL,
  `instagram` VARCHAR(75) NULL,
  `linkedin` VARCHAR(75) NULL,
  `facebook` VARCHAR(75) NULL,
  `Persona_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Persona_id`),
  INDEX `fk_RedesSociales_Persona1_idx` (`Persona_id` ASC) VISIBLE,
  CONSTRAINT `fk_RedesSociales_Persona1`
    FOREIGN KEY (`Persona_id`)
    REFERENCES `portfolio`.`sobre_mi` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`user` (
  `id` INT NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `nombre` VARCHAR(60) NULL,
  `nombre_usuario` VARCHAR(60) NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `portfolio`.`usuario_rol` (
  `usuario_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`usuario_id`, `user_id`),
  INDEX `fk_usuario_rol_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_rol_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `portfolio`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `portfolio`.`rol` (
  `id` INT NOT NULL,
  `rol_nombre` VARCHAR(45) NULL,
  `usuario_rol_usuario_id` INT NOT NULL,
  `usuario_rol_user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `usuario_rol_usuario_id`, `usuario_rol_user_id`),
  INDEX `fk_rol_usuario_rol1_idx` (`usuario_rol_usuario_id` ASC, `usuario_rol_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_rol_usuario_rol1`
    FOREIGN KEY (`usuario_rol_usuario_id` , `usuario_rol_user_id`)
    REFERENCES `portfolio`.`usuario_rol` (`usuario_id` , `user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;