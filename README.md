# DemoAcademico — Lab 03

## Cómo ejecutar
```
mvnw.cmd clean compile
mvnw.cmd spring-boot:run
```
Requiere Java 21. Al iniciar se siembran estudiantes, 3 programas, 10 asignaturas y 20 grupos (`app.seed.*` en `application.yaml`).

## URLs
- Swagger UI: http://localhost:8080/swagger-ui.html
- Consola H2: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:demoacademico`)

## Estructura (por módulos)
`common` (api, exception, controller) · `estudiantes` · `programas` · `asignaturas` · `grupos` · `matriculas` · `config`

## Ports creados
- `estudiantes.port.EstudianteQueryPort` — `Estudiante obtenerPorId(Long id)`
- `grupos.port.GrupoQueryPort` — `Grupo obtenerPorId(Long id)`

`matriculas` usa solo estos Ports (no importa repositorios de otros módulos).

## Reglas de matrícula
Existencia (404), no duplicar (400), no superar `cupoMax` (400).
