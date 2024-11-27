# ConferenceManagement

**ConferenceManagement** es un proyecto práctico desarrollado para la materia de Ingeniería de Software. Este sistema implementa una arquitectura de microservicios, utilizando tecnologías modernas como Docker, Docker Compose y Keycloak para la gestión de usuarios y seguridad.

## Autores

- Miguel Ángel Calambás Vivas
- Esteban Santiago Escandón Causaya

---

## Requisitos previos

Antes de comenzar, asegúrate de tener instalados los siguientes programas:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

---

## Configuración inicial

### Configuración de Keycloak

La primera vez que inicies el sistema, deberás configurar Keycloak:

1. **Accede a Keycloak**:
   - Una vez levantados los contenedores (ver instrucciones más abajo), abre un navegador web y accede a Keycloak en la URL: `http://localhost:9090`.

2. **Credenciales de administrador**:
   - Usuario: `admin`
   - Contraseña: `admin`

3. **Importa el archivo de configuración**:
   - En la interfaz de administración, utiliza la funcionalidad de importación para cargar el archivo de configuración del reino (`keycloak-realm-config.json`), ubicado en la carpeta `keycloak` del proyecto.

4. **Configura clientes y roles**:
   - Asegúrate de configurar correctamente los clientes, roles y usuarios necesarios para que el sistema funcione.

---

## Ejecución del proyecto

### 1. Clonar el repositorio

Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/maxskaink/ConferenceManagment-Software2.git
cd ConferenceManagement
```