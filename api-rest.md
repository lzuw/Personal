# 🎙️ Guión de Defensa — FitZone

Guía de lo que se dirá en cada slide. Adaptarlo al estilo de cada integrante.

---

## Slide 1 — Portada

> "Buenas [días/tardes], somos el equipo FitZone. Nuestro proyecto es un sistema web para la gestión integral de gimnasios, desarrollado con Java Spring Boot y MySQL."

---

## Slide 2 — Problema y cliente objetivo

> "El problema que identificamos es que muchos gimnasios pequeños y medianos en Costa Rica llevan el control de membresías y horarios en hojas de Excel o de forma manual. Esto genera errores, pérdida de información y una mala experiencia para los miembros. Nuestro cliente objetivo son gimnasios con entre 50 y 500 miembros activos."

---

## Slide 3 — Solución propuesta

> "FitZone es un sistema web que digitaliza tres procesos clave: la gestión de membresías, la reserva de clases grupales y el control del inventario de equipos. Los roles del sistema son: miembro, entrenador, recepcionista y administrador."

---

## Slide 4 — Tecnologías

> "Usamos Java 21 con Spring Boot 3, que es el stack requerido por el curso. Para el frontend usamos Thymeleaf con Bootstrap 5. La base de datos es MySQL 8. Toda la seguridad la maneja Spring Security con roles diferenciados."

---

## Slide 5 — Arquitectura

> "El código está organizado en cuatro capas: Controller, Service, Repository y Entity. Esto sigue el patrón MVC que vimos en clase. La capa Service es donde vive toda la lógica de negocio — por ejemplo, aquí validamos que el miembro tenga membresía activa antes de permitir una reserva."

---

## Slide 6 — Diagrama ER

> "La base de datos tiene 10 tablas. Las entidades principales son miembro, clase, membresía y reserva. La tabla 'reserva' es nuestra tabla transaccional, que conecta a un miembro con una clase en una fecha específica. Aquí también guardamos el estado: confirmada, completada, ausente o cancelada."

---

## Slides 7-10 — Demo en vivo

**Flujo a demostrar:**
1. Login como miembro → ver dashboard con membresía activa
2. Ver horario de clases (público, sin login)
3. Reservar una clase → confirmación
4. Login como recepcionista → renovar membresía de un miembro
5. Login como entrenador → registrar asistencia de su clase

---

## Slide 11 — Demo API REST

> "Además de la interfaz web, implementamos dos endpoints REST. Aquí en Postman pueden ver el GET /api/clases que devuelve el horario con cupos disponibles — este es público. Y el POST /api/reservas que permite crear una reserva desde una app móvil — este requiere autenticación."

---

## Slide 12 — Repositorio GitHub

> "Todo el código está en GitHub. Aquí pueden ver la estructura de carpetas, los commits de cada integrante y la carpeta docs con toda la documentación del proyecto organizada por avance."

---

## Slide 13 — Aprendizajes y trabajo futuro

> "Como aprendizajes principales: aprendimos a aplicar correctamente la arquitectura MVC en capas, a configurar Spring Security con roles, y a gestionar transacciones con @Transactional. Como trabajo futuro, identificamos: notificaciones por correo cuando la membresía está próxima a vencer, app móvil consumiendo la API REST, y reportes exportables a PDF."

---

## Slide 14 — Cierre

> "Eso es todo de nuestra parte. Muchas gracias. Quedamos abiertos a preguntas."

---

## ❓ Preguntas frecuentes y respuestas preparadas

**¿Por qué eligieron Spring Boot?**
> "Porque es el framework requerido por el curso, tiene una curva de aprendizaje manejable y la integración con JPA y Security es muy fluida. Además tiene buena documentación y comunidad activa."

**¿Cómo validan que la clase no esté llena?**
> "En el ReservaService, antes de crear la reserva, hacemos una consulta al repository para contar cuántas reservas en estado CONFIRMADA o COMPLETADA tiene esa clase en esa fecha. Si ese número es igual al cupo máximo de la clase, lanzamos una excepción ClaseLlenaException que el Controller convierte en un mensaje de error para el usuario."

**¿Cómo calculan la fecha de vencimiento de la membresía?**
> "Al crear una membresía, tomamos la fecha de inicio y le sumamos los días del plan. Eso lo hace el MembresiaService con LocalDate.plusDays(plan.getDuracionDias()). La fecha se guarda directamente en la tabla membresía."

**¿Qué pasa si el deploy de Render se cae?**
> "Tenemos el sistema corriendo localmente y capturas de todas las funcionalidades como respaldo."
