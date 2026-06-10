-- ================================================================
-- BiblioTech - Seed Data
-- ================================================================
-- Ejecutar DESPUES de schema.sql

USE bibliotecadb;

-- Roles
INSERT INTO rol (nombre) VALUES ('ADMIN'), ('BIBLIOTECARIO'), ('LECTOR');

-- Categorias
INSERT INTO categoria (nombre) VALUES ('Novela'), ('Ciencia'), ('Historia'), ('Infantil'), ('Tecnologia');

-- Usuarios de prueba (passwords cifrados con BCrypt; representacion abreviada)
-- En el proyecto real: usar BCryptPasswordEncoder.encode("admin123") en runtime
INSERT INTO usuario (correo, password, rol_id) VALUES
('admin@bibliotech.com',   '$2a$10$EXAMPLEHASHFORADMIN1234567890ABCD', 1),
('biblio@bibliotech.com',  '$2a$10$EXAMPLEHASHFORBIBLIO123456789012AB', 2),
('lector@bibliotech.com',  '$2a$10$EXAMPLEHASHFORLECTOR123456789012AB', 3);

-- Lector y bibliotecario asociados
INSERT INTO lector (usuario_id, carnet, nombre, apellidos, telefono) VALUES
(3, 'SOC-0001', 'Juan', 'Lector Demo', '88880000');

INSERT INTO bibliotecario (usuario_id, nombre, codigo_empleado, turno) VALUES
(2, 'Maria Bibliotecaria', 'EMP-12345', 'Manana');

-- Autores
INSERT INTO autor (nombre, nacionalidad) VALUES
('Gabriel Garcia Marquez', 'Colombiana'),
('Isaac Asimov',           'Estadounidense'),
('Yuval Noah Harari',      'Israeli'),
('Robert C. Martin',       'Estadounidense');

-- Libros (catalogo)
INSERT INTO libro (titulo, isbn, editorial, anio_publicacion, categoria_id, ejemplares_total, ejemplares_disponibles, fecha_ingreso) VALUES
('Cien anos de soledad', '9780307474728', 'Sudamericana',   1967, 1, 3, 2, '2023-01-15'),
('Yo, Robot',            '9788497596817', 'Edhasa',         1950, 2, 2, 2, '2023-02-10'),
('Sapiens',              '9788499926223', 'Debate',         2011, 3, 4, 3, '2023-03-05'),
('Clean Code',           '9780132350884', 'Prentice Hall',  2008, 5, 2, 1, '2023-04-20');

-- Relacion libro-autor (N:M)
INSERT INTO libro_autor (libro_id, autor_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);

-- Prestamos (tabla transaccional)
INSERT INTO prestamo (libro_id, lector_id, bibliotecario_id, fecha_prestamo, fecha_devolucion_esperada, fecha_devolucion_real, estado) VALUES
(1, 1, 1, '2025-09-01', '2025-09-15', NULL,         'ACTIVO'),
(4, 1, 1, '2025-08-20', '2025-09-03', NULL,         'VENCIDO'),
(3, 1, 1, '2025-07-10', '2025-07-24', '2025-07-22', 'DEVUELTO');

-- Multa de un prestamo vencido (3 dias x 500 colones = 1500)
INSERT INTO multa (prestamo_id, dias_retraso, monto, pagada) VALUES
(2, 3, 1500.00, FALSE);

-- Verificar
SELECT 'Tablas creadas:' AS info;
SHOW TABLES;
