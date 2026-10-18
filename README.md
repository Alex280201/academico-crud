# Proyecto Académico — Gestión de Estudiantes y PokéAPI

## Descripción

Aplicación web desarrollada con Java y Spring Boot, conectada a una base de datos PostgreSQL. El proyecto permite consultar estudiantes mediante tarjetas y explorar información de Pokémon utilizando la PokéAPI.

## Tecnologías utilizadas

- Java
- Spring Boot
- PostgreSQL
- HTML, CSS y JavaScript
- IntelliJ IDEA
- Postman para probar los endpoints de la API
- Playwright para pruebas automatizadas de interfaz, si se incluye la carpeta `pruebas/`

## Funcionalidades

- Visualización de estudiantes mediante tarjetas adaptables a diferentes tamaños de pantalla.
- Consulta de información de Pokémon a través de la PokéAPI.
- Vista de detalle de un Pokémon seleccionado.
- API REST para consultar los estudiantes registrados.
- Cambio de idioma, si está implementado en la versión entregada.
- Pruebas automatizadas de interfaz, si están incluidas.

## Requisitos

- JDK compatible con la versión de Java configurada en `pom.xml`.
- Maven, o el Maven Wrapper si está incluido.
- PostgreSQL.
- IntelliJ IDEA.
- Conexión a Internet para consultar la PokéAPI.

## Configuración

1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Crear una base de datos PostgreSQL llamada `Academico`.
4. Configurar las variables de entorno de conexión a PostgreSQL, incluida `DB_PASSWORD`, según la configuración de la aplicación.
5. Ejecutar la aplicación Spring Boot desde IntelliJ IDEA.

No publicar contraseñas ni credenciales reales en el repositorio.

## URLs locales

Con la aplicación ejecutándose en el puerto 8080:

| Recurso | URL |
|---|---|
| Página de estudiantes | `http://localhost:8080/pagina1.html` |
| Página de Pokémon | `http://localhost:8080/pagina2.html` |
| Detalle de Pikachu | `http://localhost:8080/detalle.html?id=25` |
| API de estudiantes | `http://localhost:8080/api/estudiantes` |

Estas direcciones funcionan localmente en la computadora donde se ejecuta la aplicación. No constituyen un enlace público.

## Pruebas

La API puede comprobarse con Postman utilizando los endpoints definidos por el proyecto.

Si se incluyen las pruebas de Playwright, consulta las instrucciones de la carpeta `pruebas/` para instalar las dependencias y ejecutar las pruebas automatizadas.

## Autor

Proyecto académico desarrollado como parte de las actividades de aprendizaje de programación y desarrollo web.


# Academic Project — Student Management and PokéAPI

## Description

A web application developed using Java and Spring Boot, connected to a PostgreSQL database. The project allows users to view students through cards and explore Pokémon information using the PokéAPI.

## Technologies Used

- Java
- Spring Boot
- PostgreSQL
- HTML, CSS, and JavaScript
- IntelliJ IDEA
- Postman for testing API endpoints
- Playwright for automated UI testing, if the `pruebas/` folder is included

## Features

- Displaying students using responsive cards that adapt to different screen sizes.
- Retrieving Pokémon information through the PokéAPI.
- Viewing detailed information about a selected Pokémon.
- REST API for retrieving registered student records.
- Language switching, if implemented in the submitted version.
- Automated UI testing, if included in the project.

## Requirements

- A JDK compatible with the Java version specified in `pom.xml`.
- Maven, or the Maven Wrapper if included.
- PostgreSQL.
- IntelliJ IDEA.
- An Internet connection to access the PokéAPI.

## Setup

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Create a PostgreSQL database named `Academico`.
4. Configure the PostgreSQL connection environment variables, including `DB_PASSWORD`, according to the application's configuration.
5. Run the Spring Boot application from IntelliJ IDEA.

Do not publish passwords or actual credentials in the repository.

## Local URLs

With the application running on port 8080:

| Resource | URL |
|---|---|
| Student Page | `http://localhost:8080/pagina1.html` |
| Pokémon Page | `http://localhost:8080/pagina2.html` |
| Pikachu Details | `http://localhost:8080/detalle.html?id=25` |
| Student API | `http://localhost:8080/api/estudiantes` |

These URLs work locally on the computer where the application is running. They are not public links.

## Testing

The API can be tested using Postman and the endpoints defined in the project.

If Playwright tests are included, refer to the instructions in the `pruebas/` folder to install the dependencies and run the automated tests.

## Author

Academic project developed as part of programming and web development coursework.