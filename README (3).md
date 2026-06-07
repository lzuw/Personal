# Manual de Usuario — FitZone

## 1. Inicio

Acceder a `https://fitzone.onrender.com` desde un navegador moderno (Chrome, Firefox, Edge).

> *(Aquí va una captura de la página principal del sistema)*

## 2. Registro de usuario nuevo

1. Click en **"Unirme"** en la barra superior.
2. Completar el formulario:
   - Nombre y apellidos
   - Correo electrónico (debe ser único)
   - Contraseña (mínimo 8 caracteres)
   - Teléfono
   - Fecha de nacimiento
3. Click en **"Crear cuenta"**.
4. Se inicia sesión automáticamente y se redirige al dashboard.

## 3. Iniciar sesión

1. Click en **"Iniciar sesión"**.
2. Ingresar correo y contraseña.
3. El sistema redirige al dashboard según el rol.

---

## 4. Para Miembros

### 4.1 Ver mi membresía

En el dashboard, el panel principal muestra:
- Plan activo y fecha de vencimiento
- Días restantes (barra de progreso)
- Clases reservadas esta semana

### 4.2 Explorar el horario de clases

1. Click en **"Horario"** en el menú superior (no requiere login).
2. Filtrar por día de la semana o tipo de clase.
3. Cada tarjeta muestra: nombre, entrenador, hora, sala y cupos disponibles.

### 4.3 Reservar una clase

1. En el horario, click sobre la clase deseada.
2. Verificar los detalles (fecha, hora, cupos).
3. Click en **"Reservar mi lugar"**.
4. Confirmar en el diálogo emergente.
5. Se muestra confirmación con el detalle de la reserva.

> **Requisito:** Se necesita tener una membresía activa para poder reservar clases.

### 4.4 Ver y cancelar mis reservas

1. En el dashboard, click en **"Mis reservas"**.
2. Se muestra el listado de reservas: próximas, completadas y canceladas.
3. Para cancelar, click en el botón **"Cancelar"** (disponible con ≥ 2 horas de anticipación).

---

## 5. Para Entrenadores

### 5.1 Ver mis clases asignadas

1. Click en **"Mis clases"** en el menú lateral.
2. Muestra todas las clases asignadas por día de la semana.

### 5.2 Registrar asistencia

1. Click sobre una clase del día actual.
2. Se muestra la lista de miembros con reserva confirmada.
3. Marcar cada miembro como **"Asistió"** o **"No asistió"**.
4. Click en **"Guardar asistencia"**.

---

## 6. Para Recepcionistas

### 6.1 Inscribir un miembro en un plan

1. Ir a **"Membresías" → "Nueva inscripción"**.
2. Buscar el miembro por nombre o correo.
3. Seleccionar el plan (Básico, Premium, Anual, etc.).
4. Registrar el método de pago.
5. Confirmar. El sistema calcula automáticamente la fecha de vencimiento.

### 6.2 Renovar membresía

1. En **"Membresías"**, buscar al miembro.
2. Click en **"Renovar"** en su fila.
3. Confirmar el pago y el plan.
4. El sistema actualiza la fecha de vencimiento desde hoy.

---

## 7. Para Administradores

### 7.1 Gestionar usuarios

`/admin/usuarios` — lista todos los usuarios, edita roles, activa/desactiva cuentas.

### 7.2 Gestionar planes

`/admin/planes` — CRUD de planes de membresía (precio, duración, beneficios).

### 7.3 Gestionar clases

`/admin/clases` — crear clases, asignar entrenadores, definir horarios y cupos.

### 7.4 Inventario de equipos

`/admin/equipos` — CRUD de equipos, registro de mantenimientos.

### 7.5 Reportes

`/admin/reportes` — ingresos mensuales, membresías por plan, asistencia por clase.

---

## 8. Soporte

📧 soporte@fitzone.com
📱 +506 8888-0000
🕐 Lunes a Viernes, 7:00 a.m. a 9:00 p.m.
