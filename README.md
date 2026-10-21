
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