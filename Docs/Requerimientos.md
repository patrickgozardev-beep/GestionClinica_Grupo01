# 📋 Documento de Requerimientos del Sistema  
## Sistema Automatizado de Gestión de Turnos y Control de Aforo

---

## 🎯 1. Objetivos del sistema
- Permitir la reserva de espacios con control automático de aforo.
- Reducir filas o aglomeraciones mediante la digitalización de turnos.
- Notificar a usuarios y administradores sobre cambios o alertas.
- Proveer a los administradores un panel centralizado con estadísticas y reportes.
- Escalar el sistema fácilmente para más espacios o sedes.

---

## ⚙️ 2. Requerimientos funcionales

### 2.1 Módulo de usuarios
- **RF-01:** El sistema debe permitir el registro de usuarios mediante un formulario con campos obligatorios: nombre, correo, teléfono y contraseña.  
- **RF-02:** Debe incluir autenticación con validación por correo y soporte para inicio de sesión social (Google o Facebook).  
- **RF-03:** Los usuarios podrán actualizar sus datos personales y cambiar contraseña.  
- **RF-04:** El sistema debe asignar roles: *usuario común* y *administrador*, con permisos diferenciados.

### 2.2 Módulo de espacios
- **RF-05:** El administrador puede crear y configurar espacios con su capacidad máxima, ubicación y descripción.  
- **RF-06:** Cada espacio puede tener horarios asociados y un estado (activo/inactivo).  
- **RF-07:** El sistema debe mostrar visualmente el aforo ocupado, libre y total en cada espacio.

### 2.3 Módulo de horarios
- **RF-08:** Los administradores podrán definir horarios recurrentes o específicos.  
- **RF-09:** Los usuarios solo podrán visualizar y reservar horarios disponibles.  
- **RF-10:** Los horarios pasados o llenos deben ocultarse automáticamente.

### 2.4 Módulo de reservas
- **RF-11:** Los usuarios pueden reservar un turno seleccionando espacio, fecha y hora.  
- **RF-12:** El sistema validará la disponibilidad antes de confirmar la reserva.  
- **RF-13:** Al alcanzar la capacidad máxima, el sistema bloqueará nuevas reservas y mostrará el mensaje “Aforo completo”.  
- **RF-14:** Los usuarios pueden cancelar sus reservas; el sistema liberará automáticamente el cupo.  
- **RF-15:** Los administradores podrán ver, editar o eliminar reservas desde el panel.

### 2.5 Control de aforo
- **RF-16:** El sistema debe actualizar el aforo en tiempo real según las reservas activas.  
- **RF-17:** Al llegar al 90% de capacidad, enviará una alerta preventiva al administrador.  
- **RF-18:** Si se detectan inconsistencias (por ejemplo, cancelaciones masivas), el sistema generará registros de auditoría.

### 2.6 Notificaciones y alertas
- **RF-19:** Los usuarios recibirán confirmaciones y recordatorios automáticos por correo electrónico.  
- **RF-20:** Los administradores recibirán alertas en tiempo real sobre sobreaforos o anomalías.  
- **RF-21:** Las notificaciones deberán ser configurables (correo o notificación interna).  

### 2.7 Panel administrativo
- **RF-22:** El sistema debe ofrecer un dashboard con datos clave:  
  - Total de usuarios registrados.  
  - Espacios activos/inactivos.  
  - Horarios y reservas actuales.  
  - Estado de aforo en tiempo real.  
- **RF-23:** Debe incluir filtros de búsqueda (por fecha, usuario o espacio).  
- **RF-24:** Los reportes podrán exportarse a PDF o Excel.

---

## 🧰 3. Requerimientos no funcionales

### 3.1 Rendimiento
- **RNF-01:** Las operaciones de reserva deben ejecutarse en menos de 2 segundos.  
- **RNF-02:** El sistema debe soportar al menos 200 usuarios simultáneos.

### 3.2 Escalabilidad
- **RNF-03:** Debe poder ampliarse fácilmente para nuevos espacios o módulos (por ejemplo, control por QR).  
- **RNF-04:** La arquitectura debe estar desacoplada entre frontend y backend.

### 3.3 Seguridad
- **RNF-05:** Las contraseñas deben almacenarse en formato encriptado (bcrypt).  
- **RNF-06:** Todo el tráfico debe ir sobre HTTPS.  
- **RNF-07:** Implementar control de roles y validación JWT en cada endpoint.  

### 3.4 Usabilidad
- **RNF-08:** La interfaz debe ser responsiva y compatible con móviles y escritorio.  
- **RNF-09:** Debe ser intuitiva y mostrar mensajes claros de error o confirmación.

### 3.5 Mantenibilidad
- **RNF-10:** El código debe seguir estándares (nombres consistentes, documentación interna).  
- **RNF-11:** Se deben incluir pruebas unitarias para las funciones críticas.

---

## 🧩 4. Historias de Usuario

### Historia 1 – Registro y autenticación
**Como** usuario nuevo,  
**quiero** poder registrarme e iniciar sesión de forma segura,  
**para** acceder al sistema y reservar turnos.  
✅ **Criterios de aceptación:**  
- El registro requiere nombre, correo, teléfono y contraseña.  
- Se valida el correo electrónico antes de activar la cuenta.  
- La autenticación debe usar tokens JWT para mantener la sesión activa.

---

### Historia 2 – Creación y gestión de espacios
**Como** administrador,  
**quiero** registrar los espacios disponibles y su capacidad,  
**para** controlar cuántas personas pueden ingresar por horario.  
✅ **Criterios de aceptación:**  
- Puedo agregar nombre, descripción, capacidad máxima y ubicación.  
- El sistema muestra el aforo ocupado y disponible.  
- Se pueden activar o desactivar espacios temporalmente.

---

### Historia 3 – Configuración de horarios
**Como** administrador,  
**quiero** definir los horarios de uso de cada espacio,  
**para** que los usuarios puedan reservar solo en los períodos válidos.  
✅ **Criterios de aceptación:**  
- Se permite definir horarios recurrentes o únicos.  
- Los horarios pasados no deben mostrarse.  
- Si un horario se llena, se marca como “No disponible”.

---

### Historia 4 – Reserva de turnos
**Como** usuario,  
**quiero** reservar un turno en un espacio,  
**para** asegurar mi lugar y evitar sobreaforo.  
✅ **Criterios de aceptación:**  
- Solo puedo reservar en horarios activos y con aforo disponible.  
- Recibo confirmación por correo electrónico.  
- Si cancelo mi reserva, el cupo se libera automáticamente.  

---

### Historia 5 – Control y visualización del aforo
**Como** administrador,  
**quiero** ver el aforo en tiempo real de cada espacio,  
**para** actuar rápidamente si se supera la capacidad o hay alertas.  
✅ **Criterios de aceptación:**  
- El sistema muestra gráficos con el porcentaje de ocupación.  
- Se emiten alertas al 90% y 100% de capacidad.  
- Las actualizaciones se reflejan automáticamente sin recargar la página.

---

### Historia 6 – Notificaciones y recordatorios
**Como** usuario,  
**quiero** recibir notificaciones antes de mi turno,  
**para** no olvidar mi reserva y llegar a tiempo.  
✅ **Criterios de aceptación:**  
- Se envían notificaciones automáticas (correo o push).  
- Los mensajes incluyen fecha, hora y ubicación del espacio reservado.  
- Si se cancela el turno, el sistema avisa automáticamente.

---

### Historia 7 – Reportes y estadísticas
**Como** administrador,  
**quiero** ver reportes de uso de los espacios,  
**para** analizar la demanda y optimizar horarios.  
✅ **Criterios de aceptación:**  
- Los reportes pueden filtrarse por espacio, fecha o usuario.  
- Se pueden exportar en PDF o Excel.  
- Muestran porcentajes de ocupación y número de reservas completadas.
