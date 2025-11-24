# Portfolio Argentina Programa - Backend

Este es el backend para la aplicación de Portfolio del curso "Argentina Programa". Proporciona una API RESTful para gestionar los datos del portafolio, incluyendo información personal, experiencia laboral, educación, proyectos y habilidades.

## 🚀 Tecnologías Utilizadas

El proyecto está construido utilizando las siguientes tecnologías y herramientas:

*   **Java 17**: Lenguaje de programación principal.
*   **Spring Boot 2.7.18**: Framework para el desarrollo de la aplicación.
*   **Spring Data JPA**: Para la persistencia y acceso a datos.
*   **Spring Security**: Para la seguridad, autenticación y autorización.
*   **JWT (JSON Web Token)**: Para la autenticación segura y sin estado.
*   **MS SQL Server**: Base de datos relacional.
*   **Lombok**: Librería para reducir el código repetitivo (boilerplate).
*   **Swagger (SpringDoc OpenAPI)**: Para la documentación interactiva de la API.
*   **Maven**: Herramienta de gestión de dependencias y construcción.

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

*   Java JDK 17 instalado.
*   Maven instalado.
*   SQL Server instalado y en ejecución.

### Pasos para ejecutar

1.  **Clonar el repositorio**:
    ```bash
    git clone <url-del-repositorio>
    ```

2.  **Configurar la Base de Datos**:
    Asegúrate de tener una base de datos creada en SQL Server y actualiza las credenciales en el archivo de configuración (`src/main/resources/application.properties` o `.env` si corresponde).

3.  **Ejecutar la aplicación**:
    Puedes ejecutar el proyecto utilizando Maven:
    ```bash
    mvn spring-boot:run
    ```

4.  **Acceder a la API**:
    Una vez iniciada, la aplicación estará disponible por defecto en `http://localhost:8080`.
    Puedes ver la documentación de Swagger en `http://localhost:8080/swagger-ui.html` (o la ruta configurada).

## 📂 Estructura del Proyecto

El código fuente se encuentra organizado en los siguientes paquetes principales dentro de `com.PorfolioArgPrograma.Porfolio`:

*   `Config`: Clases de configuración (Cors, Swagger, etc.).
*   `Controller`: Controladores REST que exponen los endpoints.
*   `Dto`: Objetos de Transferencia de Datos.
*   `Entity`: Entidades JPA que mapean a las tablas de la base de datos.
*   `Repository`: Interfaces para el acceso a datos.
*   `Security`: Configuración de seguridad y JWT.
*   `Service`: Lógica de negocio.
