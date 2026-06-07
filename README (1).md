# 🗃️ Diagrama Entidad-Relación

Modelo de la base de datos del sistema FitZone.

## 📄 Archivos en esta carpeta

| Archivo | Contenido |
|---|---|
| `diagrama-er.png` | Diagrama visual (exportar desde MySQL Workbench o dbdiagram.io) |
| `modelo-relacional.md` | Descripción textual de tablas y relaciones |
| `diagrama-er.mwb` | Archivo nativo de MySQL Workbench (opcional) |

## 📊 Resumen del modelo

**10 tablas** (cumple el mínimo requerido por el enunciado):

| # | Tabla | Tipo |
|---|---|---|
| 1 | `usuario` | Entidad principal |
| 2 | `rol` | Catálogo |
| 3 | `miembro` | Entidad principal |
| 4 | `entrenador` | Entidad principal |
| 5 | `plan` | Catálogo |
| 6 | `membresia` | **CRUD principal** |
| 7 | `clase` | Entidad principal |
| 8 | `reserva` | **Transaccional** |
| 9 | `equipo` | Entidad principal |
| 10 | `mantenimiento` | Transaccional secundario |

> En el repo real, ver `diagrama-er.png` para la representación visual generada desde MySQL Workbench.

## 🔗 Relaciones principales

- `usuario` 1:1 `miembro` / `entrenador` (un usuario tiene un perfil según su rol)
- `plan` 1:N `membresia`
- `miembro` 1:N `membresia`
- `entrenador` 1:N `clase`
- `clase` 1:N `reserva`
- `miembro` 1:N `reserva`
- `equipo` 1:N `mantenimiento`

## ✅ Cumplimiento de requisitos

- ✅ **Mínimo 8 tablas:** sí (10)
- ✅ **Relaciones 1:N:** sí (miembro-membresía, clase-reserva)
- ✅ **Relaciones N:M:** sí (miembro-clase vía reserva)
- ✅ **Llaves primarias:** todas las tablas tienen PK
- ✅ **Llaves foráneas:** correctamente definidas
- ✅ **Integridad referencial:** ON DELETE CASCADE en `reserva`, ON UPDATE CASCADE en FKs
- ✅ **Tabla transaccional:** `reserva` y `membresia`
