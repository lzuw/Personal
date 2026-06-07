# Modelo Relacional — FitZone

Descripción textual de cada tabla con sus columnas, tipos y relaciones.

---

## Tabla: `rol`

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| nombre | VARCHAR(50) | NO | | | ADMIN, ENTRENADOR, RECEPCIONISTA, MIEMBRO |

---

## Tabla: `usuario`

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| correo | VARCHAR(150) | NO | | | UNIQUE |
| password | VARCHAR(60) | NO | | | BCrypt hash |
| activo | BOOLEAN | NO | | | default true |
| rol_id | BIGINT | NO | | ✅ rol(id) | Rol asignado |
| fecha_registro | DATETIME | NO | | | default NOW() |

---

## Tabla: `miembro`

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| usuario_id | BIGINT | NO | | ✅ usuario(id) | UNIQUE, 1:1 con usuario |
| nombre | VARCHAR(100) | NO | | | |
| apellidos | VARCHAR(100) | NO | | | |
| telefono | VARCHAR(20) | SÍ | | | |
| fecha_nacimiento | DATE | SÍ | | | |
| cedula | VARCHAR(20) | SÍ | | | Documento de identidad |
| foto_url | VARCHAR(255) | SÍ | | | URL de foto de perfil |

---

## Tabla: `entrenador`

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| usuario_id | BIGINT | NO | | ✅ usuario(id) | UNIQUE, 1:1 con usuario |
| nombre | VARCHAR(100) | NO | | | |
| apellidos | VARCHAR(100) | NO | | | |
| especialidad | VARCHAR(100) | SÍ | | | Yoga, Spinning, Musculación, etc. |
| certificacion | VARCHAR(255) | SÍ | | | Descripción de certificaciones |
| activo | BOOLEAN | NO | | | default true |

---

## Tabla: `plan`

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| nombre | VARCHAR(100) | NO | | | Ej: Básico, Premium, Anual |
| descripcion | TEXT | SÍ | | | Beneficios incluidos |
| precio | DECIMAL(10,2) | NO | | | Precio del plan |
| duracion_dias | INT | NO | | | Vigencia en días (30, 90, 365) |
| clases_incluidas | INT | SÍ | | | NULL = clases ilimitadas |
| activo | BOOLEAN | NO | | | default true |

---

## Tabla: `membresia` (CRUD principal)

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| miembro_id | BIGINT | NO | | ✅ miembro(id) | |
| plan_id | BIGINT | NO | | ✅ plan(id) | |
| fecha_inicio | DATE | NO | | | |
| fecha_fin | DATE | NO | | | Calculada: inicio + duracion_dias |
| estado | VARCHAR(20) | NO | | | ACTIVA, VENCIDA, SUSPENDIDA |
| precio_pagado | DECIMAL(10,2) | NO | | | Precio al momento de inscripción |
| metodo_pago | VARCHAR(50) | NO | | | Efectivo, Tarjeta, Transferencia |
| fecha_creacion | DATETIME | NO | | | default NOW() |
| observaciones | TEXT | SÍ | | | Notas de la recepcionista |

---

## Tabla: `clase`

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| nombre | VARCHAR(100) | NO | | | Ej: Yoga Avanzado, Spinning Matutino |
| tipo | VARCHAR(50) | NO | | | Yoga, Spinning, Funcional, Musculación |
| descripcion | TEXT | SÍ | | | |
| entrenador_id | BIGINT | NO | | ✅ entrenador(id) | |
| dia_semana | VARCHAR(20) | NO | | | Lunes, Martes, ... |
| hora_inicio | TIME | NO | | | |
| hora_fin | TIME | NO | | | |
| sala | VARCHAR(50) | SÍ | | | Sala A, Sala B, Área al Aire Libre |
| cupo_maximo | INT | NO | | | Máximo de participantes |
| activa | BOOLEAN | NO | | | default true |

---

## Tabla: `reserva` (transaccional)

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| miembro_id | BIGINT | NO | | ✅ miembro(id) | |
| clase_id | BIGINT | NO | | ✅ clase(id) | |
| fecha_clase | DATE | NO | | | Fecha específica de la sesión |
| estado | VARCHAR(20) | NO | | | CONFIRMADA, COMPLETADA, AUSENTE, CANCELADA |
| fecha_reserva | DATETIME | NO | | | Cuándo se hizo la reserva — default NOW() |
| observaciones | TEXT | SÍ | | | Notas del entrenador |

---

## Tabla: `equipo`

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| nombre | VARCHAR(100) | NO | | | Ej: Caminadora NordicTrack X22i |
| categoria | VARCHAR(50) | NO | | | Cardio, Fuerza, Estiramiento, Accesorios |
| cantidad | INT | NO | | | Unidades disponibles |
| estado | VARCHAR(30) | NO | | | DISPONIBLE, EN_MANTENIMIENTO, DADO_DE_BAJA |
| fecha_adquisicion | DATE | SÍ | | | |
| costo_adquisicion | DECIMAL(10,2) | SÍ | | | |
| activo | BOOLEAN | NO | | | default true (soft delete) |

---

## Tabla: `mantenimiento` (transaccional secundario)

| Columna | Tipo | Nulo | PK | FK | Descripción |
|---|---|---|---|---|---|
| id | BIGINT | NO | ✅ | | Llave primaria |
| equipo_id | BIGINT | NO | | ✅ equipo(id) | |
| tipo | VARCHAR(50) | NO | | | Preventivo, Correctivo, Limpieza |
| descripcion | TEXT | SÍ | | | Descripción del trabajo realizado |
| fecha_inicio | DATE | NO | | | |
| fecha_fin | DATE | SÍ | | | NULL si aún en proceso |
| costo | DECIMAL(10,2) | SÍ | | | |
| tecnico | VARCHAR(100) | SÍ | | | Nombre del técnico responsable |
| estado | VARCHAR(20) | NO | | | EN_PROCESO, COMPLETADO |
