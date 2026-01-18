# Portfolio Argentina Programa - Backend

Este es el backend para la aplicación de Portfolio del curso "Argentina Programa". Proporciona una API RESTful para gestionar los datos del portafolio, incluyendo información personal, experiencia laboral, educación, proyectos y habilidades.

## 🚀 Tecnologías Utilizadas

El proyecto está construido utilizando las siguientes tecnologías y herramientas:

| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| **Java** | 21 LTS | Lenguaje de programación principal |
| **Spring Boot** | 3.5.0 | Framework para el desarrollo de la aplicación |
| **Spring Data JPA** | 3.x | Para la persistencia y acceso a datos |
| **Spring Security** | 6.x | Para la seguridad, autenticación y autorización |
| **JWT (jjwt)** | 0.12.6 | Para la autenticación segura y sin estado |
| **MS SQL Server** | - | Base de datos relacional |
| **Lombok** | - | Librería para reducir el código repetitivo |
| **SpringDoc OpenAPI** | 2.8.0 | Para la documentación interactiva de la API |
| **Maven** | 3.9+ | Herramienta de gestión de dependencias |

## ✨ Novedades Spring Boot 3.5

Este proyecto fue actualizado a Spring Boot 3.5.0 con las siguientes mejoras:

- **Jakarta EE 10**: Migración completa de `javax.*` a `jakarta.*`
- **Spring Security 6**: Nueva configuración con `SecurityFilterChain` (sin `WebSecurityConfigurerAdapter`)
- **Java 17 LTS**: Compatibilidad con la última versión LTS de Java
- **Inyección por Constructor**: Uso de `@RequiredArgsConstructor` de Lombok

## 📋 Funcionalidades Principales

La API ofrece endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las siguientes entidades:

*   **Persona**: Gestión del perfil de usuario e información personal.
*   **Experiencia**: Historial de experiencia laboral.
*   **Estudios**: Información académica y educativa.
*   **Proyecto**: Proyectos realizados y destacados.
*   **Skill**: Habilidades técnicas y blandas.

Además, cuenta con un sistema de autenticación basado en **JWT** para proteger los endpoints de modificación.

## 🛠️ Configuración y Ejecución

### Requisitos Previos

*   Java JDK 17+ instalado (recomendado 17 LTS)
*   Maven 3.9+ instalado
*   SQL Server instalado y en ejecución

### Variables de Entorno

Crea un archivo `.env` en la raíz del proyecto con las siguientes variables:

```properties
DB_URL=jdbc:sqlserver://localhost:1433;databaseName=portfolio;encrypt=true;trustServerCertificate=true
DB_USERNAME=sa
DB_PASSWORD=tu_password
JWT_SECRET=ClaveSecretaMuyLargaParaJWTQueDebeSerAlMenos256BitsDeSeguridad
JWT_EXPIRATION=86400
ALLOWED_ORIGINS=http://localhost:4200
```

### Pasos para ejecutar

1.  **Clonar el repositorio**:
    ```bash
    git clone <url-del-repositorio>
    cd Argentina-Programa-Backend
    ```

2.  **Configurar la Base de Datos**:
    Asegúrate de tener una base de datos creada en SQL Server y actualiza las credenciales en el archivo `.env`.

3.  **Ejecutar la aplicación**:
    ```bash
    # Con Maven Wrapper (recomendado)
    ./mvnw spring-boot:run
    
    # O con Maven instalado
    mvn spring-boot:run
    ```

4.  **Acceder a la API**:
    Una vez iniciada, la aplicación estará disponible por defecto en `http://localhost:8080`.
    
    Documentación Swagger: `http://localhost:8080/swagger-ui.html`

## 📂 Estructura del Proyecto

El código fuente se encuentra organizado en los siguientes paquetes principales dentro de `com.PorfolioArgPrograma.Porfolio`:

```
src/main/java/com/PorfolioArgPrograma/Porfolio/
├── Config/           # Clases de configuración (Cors, Swagger, Env)
├── Controller/       # Controladores REST que exponen los endpoints
├── Dto/              # Objetos de Transferencia de Datos
├── Entity/           # Entidades JPA que mapean a las tablas
├── Exception/        # Manejo global de excepciones
├── Repository/       # Interfaces para el acceso a datos
├── Security/
│   ├── Controller/   # Controlador de autenticación
│   ├── Dto/          # DTOs de seguridad
│   ├── Entity/       # Entidades de usuario y rol
│   ├── Enums/        # Enumeraciones de roles
│   ├── Jwt/          # Componentes JWT
│   ├── Repository/   # Repositorios de seguridad
│   └── Service/      # Servicios de seguridad
└── Service/          # Lógica de negocio
```

## 🔐 Endpoints de Autenticación

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/auth/login` | Autenticación y obtención de token JWT |
| POST | `/auth/nuevo` | Registro de nuevo administrador |

## 📝 Endpoints Principales

Todos los endpoints GET son públicos. Los métodos POST, PUT, DELETE requieren autenticación con rol ADMIN.

| Recurso | Endpoints |
|---------|-----------|
| Persona | `/persona/lista/all`, `/persona/detalle/{id}`, `/persona/crear`, `/persona/actualizar/{id}`, `/persona/eliminar/{id}` |
| Experiencia | `/experiencia/lista`, `/experiencia/crear`, `/experiencia/actualizar/{id}`, `/experiencia/eliminar/{id}` |
| Estudios | `/estudios/lista`, `/estudios/crear`, `/estudios/actualizar/{id}`, `/estudios/eliminar/{id}` |
| Proyectos | `/proyecto/lista`, `/proyecto/crear`, `/proyecto/actualizar/{id}`, `/proyecto/eliminar/{id}` |
| Skills | `/skill/lista`, `/skill/crear`, `/skill/actualizar/{id}`, `/skill/eliminar/{id}` |

## 📄 Licencia

Este proyecto fue desarrollado como parte del programa educativo "Argentina Programa".

---

⭐ Desarrollado con Spring Boot 3.5 y mucho ☕
