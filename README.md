API REST - Gestión de Partidos Políticos 🏛️

API REST desarrollada con Spring Boot para la gestión eficiente de partidos políticos. Este proyecto sirve como caso de estudio para la aplicación de principios SOLID, Clean Code, arquitectura hexagonal simplificada y DevOps básico.

🚀 Características Principales

✅ CRUD completo de Partidos Políticos.

✅ Base de Datos Dual: H2 (Memoria) para desarrollo rápido y PostgreSQL para producción/Docker.

✅ Validaciones robustas con Bean Validation (@Valid).

✅ Manejo centralizado de excepciones (@ControllerAdvice).

✅ DTOs para desacoplamiento y seguridad de datos.

✅ Logging estructurado con SLF4J.

✅ Tests unitarios y de integración con JUnit 5 y Mockito.

✅ Dockerizado con Docker Compose para despliegue inmediato.

🛠️ Tecnologías Utilizadas

Tecnología

Versión

Propósito

Spring Boot

3.3.0

Framework principal backend

Spring Data JPA

3.3.0

Capa de persistencia y ORM

PostgreSQL

15

Motor de base de datos (Docker)

H2 Database

Latest

Base de datos en memoria (Local/Tests)

Lombok

Latest

Reducción de código boilerplate

JUnit 5

5.9+

Framework de Testing

Mockito

5.3+

Mocking de dependencias

Docker

Latest

Contenedorización

📋 Requisitos Previos

Java 17 o superior.

Maven 3.6+.

Docker y Docker Compose (Opcional, recomendado).

Postman (para pruebas de endpoints).

📁 Estructura del Proyecto

politica/
├── src/
│   ├── main/
│   │   ├── java/com/udc/politica/
│   │   │   ├── controller/      # Capa de presentación (REST)
│   │   │   ├── service/         # Lógica de negocio (Interfaces)
│   │   │   │   └── impl/        # Implementación de servicios
│   │   │   ├── repository/      # Acceso a datos (JPA)
│   │   │   ├── model/           # Entidades JPA (DB)
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── mapper/          # Conversores DTO-Entity
│   │   │   └── exception/       # Manejo global de errores
│   │   └── resources/
│   │       └── application.properties
│   └── test/                    # Tests unitarios e integración
├── Dockerfile
├── docker-compose.yml
└── pom.xml


⚡ Inicio Rápido

Opción 1: Con Docker (Recomendado 🐳)

Esta opción levanta la API y una base de datos PostgreSQL real automáticamente.

Clonar el repositorio:

git clone [https://github.com/TU_USUARIO/politica.git](https://github.com/TU_USUARIO/politica.git)
cd politica


Compilar y Levantar servicios:

mvn clean package -DskipTests
docker-compose up --build


La API estará disponible en: http://localhost:8080

Opción 2: Ejecución Local (Sin Docker)

Esta opción utiliza la base de datos H2 en memoria configurada por defecto, ideal para pruebas rápidas sin instalar nada extra.

Ejecutar directamente con Maven:

mvn spring-boot:run


La consola H2 estará disponible en: http://localhost:8080/h2-console

📡 Endpoints de la API

Método

Endpoint

Descripción

POST

/api/partidos

Crear un nuevo partido

GET

/api/partidos

Listar todos los partidos

GET

/api/partidos/{id}

Obtener detalle de un partido

PUT

/api/partidos/{id}

Actualizar información

DELETE

/api/partidos/{id}

Eliminar un partido

Ejemplo de JSON (Body para POST/PUT)

{
  "nombre": "Partido Innovación",
  "eslogan": "Futuro Seguro",
  "pais": "Colombia",
  "presidente": "Juan Pérez",
  "secretario": "Ana Gómez",
  "tesorero": "Carlos Ruiz",
  "numPresidentes": 0,
  "numGobernadores": 5,
  "numAlcaldes": 20,
  "numConcejales": 150,
  "numCongresistas": 12
}


🧪 Ejecución de Tests

El proyecto incluye una suite de pruebas para garantizar la calidad del código.

# Ejecutar todos los tests
mvn test

# Generar reporte de cobertura (Jacoco)
mvn clean test jacoco:report


El reporte HTML se genera en: target/site/jacoco/index.html

🏗️ Arquitectura y Principios SOLID

Este proyecto se adhiere estrictamente a buenas prácticas de ingeniería de software:

Single Responsibility Principle (SRP):

Controller: Solo maneja peticiones HTTP y mapeo.

Service: Solo contiene lógica de negocio.

Repository: Solo interactúa con la BD.

Mapper: Solo convierte objetos.

Open/Closed Principle (OCP):

Uso de interfaces (PartidoService) permitiendo nuevas implementaciones sin modificar el código cliente (Controlador).

Dependency Inversion Principle (DIP):

El Controlador depende de la abstracción (PartidoService), no de la implementación concreta (PartidoServiceImpl).

🔧 Solución de Problemas

Error: "Connection refused" (PostgreSQL):

Si usas Docker, asegúrate de correr docker-compose up.

Si corres local sin Docker, la app usará H2 automáticamente para evitar este error.

Error: "Port 8080 already in use":

Cambia el puerto en application.properties: server.port=8081 o mata el proceso que ocupa el puerto.

🤝 Contribuir

Haz un Fork del proyecto.

Crea una rama (git checkout -b feature/nueva-funcionalidad).

Commit tus cambios (git commit -am 'Agregar nueva funcionalidad').

Push a la rama (git push origin feature/nueva-funcionalidad).

Abre un Pull Request.

📄 Licencia

Este proyecto está bajo la Licencia MIT.
