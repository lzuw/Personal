-- ================================================================
-- BiblioTech - Schema
-- Proyecto Final SC-403 - Universidad Fidelitas
-- ================================================================

CREATE DATABASE IF NOT EXISTS bibliotecadb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE bibliotecadb;

-- ================================================================
-- Tabla: rol
-- ================================================================
CREATE TABLE IF NOT EXISTS rol (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- ================================================================
-- Tabla: usuario
-- ================================================================
CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    correo VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    rol_id BIGINT NOT NULL,
    fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (rol_id) REFERENCES rol(id) ON UPDATE CASCADE
);

-- ================================================================
-- Tabla: lector (socio de la biblioteca)
-- ================================================================
CREATE TABLE IF NOT EXISTS lector (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL UNIQUE,
    carnet VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- ================================================================
-- Tabla: bibliotecario
-- ================================================================
CREATE TABLE IF NOT EXISTS bibliotecario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    codigo_empleado VARCHAR(50) NOT NULL UNIQUE,
    turno VARCHAR(20),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- ================================================================
-- Tabla: categoria
-- ================================================================
CREATE TABLE IF NOT EXISTS categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- ================================================================
-- Tabla: autor
-- ================================================================
CREATE TABLE IF NOT EXISTS autor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    nacionalidad VARCHAR(80)
);

-- ================================================================
-- Tabla: libro
-- ================================================================
CREATE TABLE IF NOT EXISTS libro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    editorial VARCHAR(100),
    anio_publicacion INT,
    categoria_id BIGINT NOT NULL,
    ejemplares_total INT NOT NULL DEFAULT 1,
    ejemplares_disponibles INT NOT NULL DEFAULT 1,
    fecha_ingreso DATE,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id) ON UPDATE CASCADE
);

-- ================================================================
-- Tabla: libro_autor (N:M)
-- ================================================================
CREATE TABLE IF NOT EXISTS libro_autor (
    libro_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    PRIMARY KEY (libro_id, autor_id),
    FOREIGN KEY (libro_id) REFERENCES libro(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (autor_id) REFERENCES autor(id) ON UPDATE CASCADE
);

-- ================================================================
-- Tabla: prestamo (transaccional)
-- ================================================================
CREATE TABLE IF NOT EXISTS prestamo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    libro_id BIGINT NOT NULL,
    lector_id BIGINT NOT NULL,
    bibliotecario_id BIGINT NOT NULL,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion_esperada DATE NOT NULL,
    fecha_devolucion_real DATE,
    estado VARCHAR(20) NOT NULL DEFAULT 'ACTIVO',
    observaciones TEXT,
    fecha_creacion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (libro_id) REFERENCES libro(id) ON UPDATE CASCADE,
    FOREIGN KEY (lector_id) REFERENCES lector(id) ON UPDATE CASCADE,
    FOREIGN KEY (bibliotecario_id) REFERENCES bibliotecario(id) ON UPDATE CASCADE
);

-- ================================================================
-- Tabla: multa (transaccional, derivada del prestamo)
-- ================================================================
CREATE TABLE IF NOT EXISTS multa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    prestamo_id BIGINT NOT NULL UNIQUE,
    dias_retraso INT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    pagada BOOLEAN NOT NULL DEFAULT FALSE,
    fecha_emision DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (prestamo_id) REFERENCES prestamo(id) ON UPDATE CASCADE
);
