# 🔀 Flujo de Navegación

Diagrama de cómo se conectan las pantallas del sistema FitZone.

```
                        ┌──────────────┐
                        │   HOME (/)   │
                        │   pública    │
                        └──────┬───────┘
                               │
                ┌──────────────┼──────────────┐
                ▼              ▼              ▼
         ┌──────────┐   ┌──────────┐   ┌──────────────┐
         │  /login  │   │/registro │   │  /horario    │
         └─────┬────┘   └─────┬────┘   │   pública    │
               │              │        └──────────────┘
               └──────┬───────┘
                      ▼
            ┌─────────────────────┐
            │     /dashboard       │
            │    (según rol)       │
            └─────────┬────────────┘
                      │
        ┌─────────────┼─────────────┬─────────────┐
        ▼             ▼             ▼             ▼
   ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐
   │/membresias│ │ /clases  │ │/equipos  │ │ /admin/* │
   │           │ │transacc. │ │          │ │(ADMIN)   │
   └────┬──────┘ └────┬─────┘ └──────────┘ └──────────┘
        │             │
        ▼             ▼
   ┌────────┐  ┌──────────────┐
   │CRUD    │  │/clases/      │
   │membr.  │  │ reservar     │
   └────────┘  └────┬─────────┘
                    ▼
              ┌──────────────────┐
              │ /reservas/{id}   │
              │ + confirmación   │
              └──────────────────┘
```

## Casos de uso principales

### 1. Miembro nuevo se inscribe y reserva una clase

```
HOME → /registro → (auto-login) → /dashboard →
  /membresias/nueva → (elegir plan, pagar) →
  /horario → /clases/reservar → (seleccionar clase, fecha) →
  CONFIRMACIÓN DE RESERVA
```

### 2. Entrenador registra asistencia

```
HOME → /login → /dashboard (entrenador) →
  /clases → (mi clase del día) → /clases/{id}/asistencia →
  (marcar presentes/ausentes) → GUARDAR →
  estado de reservas actualizado
```

### 3. Recepcionista renueva una membresía

```
HOME → /login (recepcionista) → /dashboard →
  /membresias → (buscar miembro) → /membresias/{id} →
  (renovar, registrar pago) → recibo generado
```

### 4. Admin genera reporte

```
HOME → /login (admin) → /dashboard →
  /admin/reportes → (filtros de fecha y plan) →
  reporte mensual de ingresos
```

## Estados de una membresía

```
   ┌────────────┐
   │  ACTIVA    │  ← inscripción o renovación
   └─────┬──────┘
         │ (vence automáticamente)
   ┌─────▼──────┐
   │  VENCIDA   │  ← fecha de fin alcanzada
   └─────┬──────┘
         │ (recepcionista renueva)
   ┌─────▼──────┐
   │  ACTIVA    │  ← nueva vigencia
   └────────────┘

   ┌─────────────┐
   │ SUSPENDIDA  │  ← admin suspende por mora
   └─────────────┘
```

## Estados de una reserva de clase

```
   ┌──────────────┐
   │  CONFIRMADA  │  ← miembro reserva
   └──────┬───────┘
          │
   ┌──────▼───────┐   ┌──────────────┐
   │  COMPLETADA  │   │  AUSENTE     │
   │ (asistió)    │   │ (no asistió) │
   └──────────────┘   └──────────────┘

   ┌──────────────┐
   │  CANCELADA   │  ← miembro cancela con anticipación
   └──────────────┘
```
