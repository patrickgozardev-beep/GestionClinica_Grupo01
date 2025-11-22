CREATE DATABASE IF NOT EXISTS GestionClinicaG1
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

USE GestionClinicaG1;

-- =========================
-- TABLA: roles
-- =========================s
DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
  id tinyint unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(50) NOT NULL,
  descripcion varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY nombre (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO roles VALUES
(1,'administrador','Acceso total al sistema'),
(2,'doctor','Profesional que atiende citas'),
(3,'paciente','Usuario que agenda y recibe citas');

-- =========================
-- TABLA: usuarios
-- =========================
DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  rol_id tinyint unsigned NOT NULL,
  nombre varchar(150) NOT NULL,
  email varchar(255) NOT NULL,
  telefono varchar(30) DEFAULT NULL,
  password_hash varchar(255) NOT NULL,
  email_verificado tinyint(1) DEFAULT 0,
  activo tinyint(1) DEFAULT 1,
  creado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  actualizado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY email (email),
  KEY idx_rol (rol_id),
  CONSTRAINT usuarios_ibfk_1 FOREIGN KEY (rol_id) REFERENCES roles (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- =========================
-- TABLA: especialidades
-- =========================
DROP TABLE IF EXISTS especialidades;
CREATE TABLE especialidades (
  id int unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  descripcion varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY nombre (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO especialidades VALUES
(1,'Odontología',NULL),
(2,'Cardiología',NULL),
(3,'Pediatría',NULL),
(4,'Medicina General',NULL),
(5,'Nutrición',NULL);

-- =========================
-- TABLA: configuracion
-- =========================
DROP TABLE IF EXISTS configuracion;
CREATE TABLE configuracion (
  id int unsigned NOT NULL DEFAULT 1,
  umbral_alerta_aforo tinyint unsigned DEFAULT 90,
  max_usuarios_concurrentes int DEFAULT 200,
  tiempo_expiracion_reserva_segundos int DEFAULT 120,
  creado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  actualizado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO configuracion VALUES
(1, 90, 200, 120, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- =========================
-- TABLA: pacientes_detalles
-- =========================
DROP TABLE IF EXISTS pacientes_detalles;
CREATE TABLE pacientes_detalles (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  usuario_id bigint unsigned NOT NULL,
  fecha_nacimiento date DEFAULT NULL,
  sexo enum('masculino','femenino','otro') DEFAULT NULL,
  direccion varchar(255) DEFAULT NULL,
  documento_tipo enum('dni','ce','pasaporte') DEFAULT NULL,
  documento_numero varchar(50) DEFAULT NULL,
  historial_medico text,
  creado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  actualizado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY usuario_id (usuario_id),
  CONSTRAINT pacientes_detalles_ibfk_1 FOREIGN KEY (usuario_id) REFERENCES usuarios (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- =========================
-- TABLA: doctores_detalles
-- =========================
DROP TABLE IF EXISTS doctores_detalles;
CREATE TABLE doctores_detalles (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  usuario_id bigint unsigned NOT NULL,
  especialidad_id int unsigned NOT NULL,
  numero_colegiatura varchar(50) DEFAULT NULL,
  experiencia_anios int DEFAULT NULL,
  creado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  actualizado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY usuario_id (usuario_id),
  KEY especialidad_id (especialidad_id),
  CONSTRAINT doctores_detalles_ibfk_1 FOREIGN KEY (usuario_id) REFERENCES usuarios (id) ON DELETE CASCADE,
  CONSTRAINT doctores_detalles_ibfk_2 FOREIGN KEY (especialidad_id) REFERENCES especialidades (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- =========================
-- TABLA: espacios
-- =========================
DROP TABLE IF EXISTS espacios;
CREATE TABLE espacios (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(150) NOT NULL,
  descripcion text,
  ubicacion varchar(255) DEFAULT NULL,
  especialidad_id int unsigned NOT NULL,
  capacidad int unsigned NOT NULL,
  estado enum('activo','inactivo') DEFAULT 'activo',
  creado_por bigint unsigned DEFAULT NULL,
  creado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  actualizado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY especialidad_id (especialidad_id),
  KEY creado_por (creado_por),
  CONSTRAINT espacios_ibfk_1 FOREIGN KEY (especialidad_id) REFERENCES especialidades (id),
  CONSTRAINT espacios_ibfk_2 FOREIGN KEY (creado_por) REFERENCES usuarios (id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- =========================
-- TABLA: plantillas_horarios
-- =========================
DROP TABLE IF EXISTS plantillas_horarios;
CREATE TABLE plantillas_horarios (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  espacio_id bigint unsigned NOT NULL,
  nombre varchar(150) DEFAULT NULL,
  tipo enum('recurrente','puntual') NOT NULL DEFAULT 'recurrente',
  dias_semana varchar(20) DEFAULT NULL,
  hora_inicio time NOT NULL,
  hora_fin time NOT NULL,
  fecha_inicio date DEFAULT NULL,
  fecha_fin date DEFAULT NULL,
  intervalo_minutos int DEFAULT 30,
  activo tinyint(1) DEFAULT 1,
  creado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY espacio_id (espacio_id),
  CONSTRAINT plantillas_horarios_ibfk_1 FOREIGN KEY (espacio_id) REFERENCES espacios (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- =========================
-- TABLA: horarios_slots
-- =========================
DROP TABLE IF EXISTS horarios_slots;
CREATE TABLE horarios_slots (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  espacio_id bigint unsigned NOT NULL,
  plantilla_id bigint unsigned DEFAULT NULL,
  fecha date NOT NULL,
  hora_inicio time NOT NULL,
  hora_fin time NOT NULL,
  capacidad int unsigned NOT NULL,
  contador_actual int unsigned DEFAULT 0,
  estado enum('disponible','lleno','cerrado') DEFAULT 'disponible',
  creado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  actualizado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY uq_slot (espacio_id, fecha, hora_inicio),
  KEY plantilla_id (plantilla_id),
  CONSTRAINT horarios_slots_ibfk_1 FOREIGN KEY (espacio_id) REFERENCES espacios (id) ON DELETE CASCADE,
  CONSTRAINT horarios_slots_ibfk_2 FOREIGN KEY (plantilla_id) REFERENCES plantillas_horarios (id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- =========================
-- TABLA: reservas
-- =========================
DROP TABLE IF EXISTS reservas;
CREATE TABLE reservas (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  paciente_id bigint unsigned NOT NULL,
  doctor_id bigint unsigned NOT NULL,
  slot_id bigint unsigned NOT NULL,
  estado enum('confirmada','cancelada','asistida','no_show') DEFAULT 'confirmada',
  motivo_cancelacion varchar(255) DEFAULT NULL,
  creada_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  actualizada_en timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE KEY uq_paciente_slot (paciente_id, slot_id),
  KEY doctor_id (doctor_id),
  KEY slot_id (slot_id),
  CONSTRAINT reservas_ibfk_1 FOREIGN KEY (paciente_id) REFERENCES usuarios (id) ON DELETE CASCADE,
  CONSTRAINT reservas_ibfk_2 FOREIGN KEY (doctor_id) REFERENCES usuarios (id) ON DELETE RESTRICT,
  CONSTRAINT reservas_ibfk_3 FOREIGN KEY (slot_id) REFERENCES horarios_slots (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- =========================
-- TABLA: notificaciones
-- =========================
DROP TABLE IF EXISTS notificaciones;
CREATE TABLE notificaciones (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  usuario_id bigint unsigned DEFAULT NULL,
  slot_id bigint unsigned DEFAULT NULL,
  tipo varchar(100) NOT NULL,
  mensaje text,
  canal enum('email','interna') DEFAULT 'email',
  entregado tinyint(1) DEFAULT 0,
  creado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY usuario_id (usuario_id),
  KEY slot_id (slot_id),
  CONSTRAINT notificaciones_ibfk_1 FOREIGN KEY (usuario_id) REFERENCES usuarios (id) ON DELETE SET NULL,
  CONSTRAINT notificaciones_ibfk_2 FOREIGN KEY (slot_id) REFERENCES horarios_slots (id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- =========================
-- TABLA: auditoria
-- =========================
DROP TABLE IF EXISTS auditoria;
CREATE TABLE auditoria (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  usuario_actor_id bigint unsigned DEFAULT NULL,
  accion varchar(100) NOT NULL,
  recurso varchar(50) DEFAULT NULL,
  recurso_id bigint unsigned DEFAULT NULL,
  detalles json DEFAULT NULL,
  creado_en timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY usuario_actor_id (usuario_actor_id),
  CONSTRAINT auditoria_ibfk_1 FOREIGN KEY (usuario_actor_id) REFERENCES usuarios (id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
