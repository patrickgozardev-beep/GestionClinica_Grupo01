# 🧠 Sistema Automatizado de Gestión de Turnos y Control de Aforo

## 📋 Descripción del proyecto
El **Sistema Automatizado de Gestión de Turnos y Control de Aforo** es una plataforma diseñada para optimizar el uso de espacios en centros educativos, como gimnasios, bibliotecas o laboratorios.  
Permite a los usuarios **reservar turnos** y controla en **tiempo real el aforo disponible**, garantizando que no se supere la capacidad máxima establecida.  
Cuando el cupo se llena, el sistema **bloquea nuevas reservas** y puede enviar **notificaciones automáticas** tanto a usuarios como a administradores.

Este proyecto combina buenas prácticas de desarrollo web, arquitectura cliente-servidor y seguridad con JWT, aplicando principios modernos de diseño y gestión de datos.

---

## 🚀 Funcionalidades principales
- Registro y autenticación de usuarios (roles: usuario y administrador).
- Configuración de espacios, horarios y capacidad máxima.
- Sistema de reservas con validación de aforo en tiempo real.
- Bloqueo automático de reservas cuando se supera el límite de capacidad.
- Notificaciones y alertas automáticas (por correo o dentro del sistema).
- Panel administrativo con reportes y visualización en tiempo real.

---

## 🏗️ Tecnologías por utilizar
### Backend
- **Java (Spring Boot)** o **C# (.NET Core)**  
- **MySQL / PostgreSQL / SQL Server** como base de datos  
- **JWT** para autenticación y seguridad  
- **SMTP** para notificaciones automáticas por correo  

### Frontend
- **React**
- Interfaz moderna, responsiva y enfocada en la usabilidad.

---

## 🧩 Arquitectura del sistema
El sistema sigue una arquitectura **Cliente-Servidor** basada en API REST:
- **Frontend:** Aplicación web SPA (Single Page Application) que consume los servicios del backend.  
- **Backend:** API REST encargada de la lógica de negocio, validaciones, autenticación y control del aforo.  
- **Base de datos:** Motor relacional que gestiona la información de usuarios, espacios, horarios y reservas.

---

## 👥 Integrantes del equipo

| STEVE PATRICK GOZAR RAMIREZ       | 
| JUAN YUCEFF SALAZAR PURIZACA      |
| JUAN LUIS SANTA CRUZ PORTOCARRERO | 
| JENNIFER LUZMILA SANTA MARIA CHOY | 

