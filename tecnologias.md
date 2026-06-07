# API REST — FitZone

Documentación de los endpoints REST. La colección Postman está en [`postman/`](../../postman/).

## Base URL

- **Local:** `http://localhost:8080`
- **Producción:** `https://fitzone.onrender.com`

## Autenticación

Los endpoints `/api/**` que requieren autenticación usan Basic Auth.

```
Authorization: Basic dXN1YXJpbzpwYXNzd29yZA==
```

> Los endpoints de consulta pública (horario de clases) no requieren autenticación.

---

## Endpoints

### `GET /api/clases`

Lista todas las clases activas con información de cupos disponibles.

**Request:**
```http
GET /api/clases HTTP/1.1
```

**Parámetros opcionales:**
| Parámetro | Tipo | Descripción |
|---|---|---|
| `dia` | String | Filtrar por día (Lunes, Martes, ...) |
| `tipo` | String | Filtrar por tipo (Yoga, Spinning, Funcional, ...) |

**Response 200 OK:**
```json
[
  {
    "id": 1,
    "nombre": "Yoga Avanzado",
    "tipo": "Yoga",
    "descripcion": "Clase de yoga nivel avanzado para mejorar flexibilidad y concentración.",
    "entrenador": "Sofía Ramírez",
    "diaSemana": "Lunes",
    "horaInicio": "07:00",
    "horaFin": "08:00",
    "sala": "Sala A",
    "cupoMaximo": 15,
    "cuposDisponibles": 8
  },
  {
    "id": 2,
    "nombre": "Spinning Matutino",
    "tipo": "Spinning",
    "descripcion": "Clase de ciclismo indoor de alta intensidad.",
    "entrenador": "Carlos Mora",
    "diaSemana": "Martes",
    "horaInicio": "06:00",
    "horaFin": "07:00",
    "sala": "Sala B",
    "cupoMaximo": 20,
    "cuposDisponibles": 0
  }
]
```

**Errores:**
- `500 Internal Server Error` — error inesperado en el servidor.

---

### `POST /api/reservas`

Crea una nueva reserva de clase para el miembro autenticado.

**Request:**
```http
POST /api/reservas HTTP/1.1
Content-Type: application/json
Authorization: Basic dXN1YXJpbzpwYXNzd29yZA==

{
  "claseId": 1,
  "fechaClase": "2025-10-06"
}
```

**Response 201 Created:**
```json
{
  "id": 35,
  "miembroId": 12,
  "claseId": 1,
  "nombreClase": "Yoga Avanzado",
  "fechaClase": "2025-10-06",
  "horaInicio": "07:00",
  "sala": "Sala A",
  "estado": "CONFIRMADA",
  "fechaReserva": "2025-10-01T09:14:22"
}
```

**Errores:**
- `400 Bad Request` — datos inválidos en el body (claseId o fecha faltantes/inválidos).
- `401 Unauthorized` — no se envió token / credenciales inválidas.
- `403 Forbidden` — el miembro no tiene membresía activa.
- `409 Conflict` — la clase está llena o el miembro ya tiene reserva en esa fecha/clase.

---

## Pruebas

Importar `postman/fitzone-api.postman_collection.json` en Postman para probar todos los endpoints con ejemplos preconfigurados.

## Status codes usados

| Código | Significado |
|---|---|
| 200 | OK |
| 201 | Created (POST exitoso) |
| 400 | Bad Request (datos inválidos) |
| 401 | Unauthorized (auth faltante) |
| 403 | Forbidden (sin permisos o membresía inactiva) |
| 404 | Not Found |
| 409 | Conflict (cupo lleno o reserva duplicada) |
| 500 | Internal Server Error |
