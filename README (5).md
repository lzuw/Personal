# 🎤 Presentación de Defensa Final

Slides para la defensa del proyecto FitZone (Avance 4).

## 📄 Archivos en esta carpeta

| Archivo | Contenido |
|---|---|
| `presentacion.pdf` | PDF final de la presentación |
| `presentacion.pptx` | Versión editable PowerPoint |
| `guion-defensa.md` | Guión con lo que se dirá en cada slide |

## 🎯 Estructura recomendada (10-15 min)

| Slide | Contenido | Tiempo |
|---|---|---|
| 1 | Portada (FitZone, equipo, curso) | 30s |
| 2 | Problema y cliente objetivo | 1 min |
| 3 | Solución propuesta | 1 min |
| 4 | Tecnologías utilizadas | 1 min |
| 5 | Arquitectura por capas (diagrama) | 2 min |
| 6 | Diagrama ER (modelo de datos) | 1 min |
| 7-10 | Demo en vivo: módulos clave (login, membresías, reserva de clases, asistencia) | 4-5 min |
| 11 | Demo API REST con Postman | 1-2 min |
| 12 | Muestra del repositorio GitHub | 1 min |
| 13 | Aprendizajes y trabajo futuro | 1 min |
| 14 | Gracias / preguntas | — |

## 🎤 Distribución sugerida entre integrantes

Cada miembro presenta su parte del código y responde preguntas sobre ella:

| Integrante | Sección |
|---|---|
| Integrante 1 | Arquitectura + Seguridad (Spring Security, roles) |
| Integrante 2 | CRUD principal (Membresías: listado, formularios, renovación) |
| Integrante 3 | Módulo transaccional (Reservas de clases + Asistencia) + API REST |

## 💡 Consejos para la defensa

- Practicar la demo varias veces antes del día.
- Tener el sistema corriendo localmente Y desplegado en Render (por si falla la red).
- Tener Postman abierto con la colección lista y la solicitud pre-configurada.
- Cada uno debe poder explicar SU código sin leer.
- Llevar plan B: capturas de pantalla del sistema funcionando por si el deploy se cae.
- Preparar respuesta para: "¿Por qué eligieron Spring Boot?" y "¿Cómo se valida el cupo de la clase?"

## 📋 Checklist antes de la defensa

- [ ] Sistema desplegado en Render.com y funcionando
- [ ] Repositorio GitHub actualizado con todos los avances
- [ ] Datos de prueba cargados en la BD de producción
- [ ] Colección Postman con ejemplo de `GET /api/clases` y `POST /api/reservas`
- [ ] Presentación PDF en USB y en Drive como respaldo
- [ ] Cada integrante praticó su sección al menos 2 veces
