API REST - Gestión de Partidos Políticos 🏛️
API REST desarrollada con Spring Boot para la gestión de partidos políticos, aplicando principios SOLID, Clean Code y buenas prácticas de arquitectura de software.
Características

✅ CRUD completo de Partidos Políticos
✅ Validaciones robustas con Bean Validation
✅ Manejo centralizado de excepciones
✅ DTOs para separación de capas
✅ Logging estructurado
✅ Documentación completa
✅ Tests unitarios y de integración
✅ Dockerizado con Docker Compose
✅ Base de datos PostgreSQL

📋 Requisitos Previos

Java 17 o superior
Maven 3.6+
Docker y Docker Compose
PostgreSQL 15 (si no usas Docker)
Postman (para pruebas)

🛠️ Tecnologías Utilizadas
TecnologíaVersiónPropósitoSpring Boot3.3.0Framework principalSpring Data JPA3.3.0PersistenciaPostgreSQL15Base de datosLombokLatestReducción de código boilerplateJUnit 55.9+TestingMockito5.3+Mocking en testsDockerLatestContenedorización
📁 Estructura del Proyecto
politica/
├── src/
│   ├── main/
│   │   ├── java/com/udc/politica/
│   │   │   ├── controller/          # Capa de presentación
│   │   │   ├── service/              # Lógica de negocio
│   │   │   │   └── impl/
│   │   │   ├── repository/           # Acceso a datos
│   │   │   ├── model/                # Entidades JPA
│   │   │   ├── dto/                  # Data Transfer Objects
│   │   │   ├── mapper/               # Conversores DTO-Entity
│   │   │   └── exception/            # Manejo de excepciones
│   │   └── resources/
│   │       └── application.properties
│   └── test/                         # Tests unitarios
├── Dockerfile
├── docker-compose.yml
└── pom.xml

Inicio Rápido
Opción 1: Con Docker (Recomendado)
bash# 1. Clonar el repositorio
git clone <tu-repositorio>
cd politica

# 2. Compilar el proyecto
mvn clean package -DskipTests

# 3. Levantar los servicios
docker-compose up --build

# La API estará disponible en: http://localhost:8080
Opción 2: Sin Docker
bash# 1. Configurar PostgreSQL localmente
# Crear base de datos: politicadb

# 2. Compilar y ejecutar
mvn clean install
mvn spring-boot:run
📡 Endpoints de la API
Crear Partido Político
httpPOST /api/partidos
Content-Type: application/json

{
  "nombre": "Partido Innovación",
  "eslogan": "Futuro Seguro",
  "pais": "Colombia",
  "presidente": "Juan Pérez",
  "numPresidentes": 0,
  "numGobernadores": 5,
  "numAlcaldes": 20
}
Listar Todos los Partidos
httpGET /api/partidos
Obtener Partido por ID
httpGET /api/partidos/{id}
Actualizar Partido
httpPUT /api/partidos/{id}
Content-Type: application/json

{
  "nombre": "Partido Innovación Actualizado",
  "eslogan": "Nuevo Eslogan",
  "pais": "Colombia"
}
Eliminar Partido
httpDELETE /api/partidos/{id}
🧪 Ejecutar Tests
bash# Tests unitarios
mvn test

# Tests con reporte de cobertura
mvn clean test jacoco:report

# El reporte se genera en: target/site/jacoco/index.html
🏗️ Principios SOLID Aplicados
1. Single Responsibility Principle (SRP)

Cada clase tiene una única responsabilidad
Controller → Manejo de peticiones HTTP
Service → Lógica de negocio
Repository → Acceso a datos
Mapper → Conversión entre capas

2. Open/Closed Principle (OCP)

Uso de interfaces (PartidoService)
Extensible sin modificar código existente

3. Liskov Substitution Principle (LSP)

Las implementaciones pueden sustituir interfaces sin romper la aplicación

4. Interface Segregation Principle (ISP)

Interfaces específicas y cohesivas
No se obliga a implementar métodos innecesarios

5. Dependency Inversion Principle (DIP)

Inyección de dependencias por constructor
Dependencia de abstracciones, no de implementaciones concretas

Buenas Prácticas Implementadas
Arquitectura en Capas
Presentación (Controller) 
    ↓
Negocio (Service) 
    ↓
Persistencia (Repository) 
    ↓
Base de Datos
Separación de Responsabilidades

DTOs: Exponen solo datos necesarios al cliente
Entities: Representan el modelo de dominio
Mappers: Convierten entre DTOs y Entities

Manejo de Excepciones

GlobalExceptionHandler centraliza el manejo de errores
Respuestas consistentes con códigos HTTP apropiados
Mensajes de error descriptivos

Validaciones

Validaciones declarativas con @Valid
Mensajes personalizados
Validación en la capa de presentación

Logging

Uso de SLF4J con Logback
Logs en puntos estratégicos
Niveles apropiados (INFO, ERROR, DEBUG)

Seguridad

Usuario no-root en Docker
Variables de entorno para credenciales
Validación de entrada de datos
Manejo seguro de excepciones

Monitoreo
La aplicación incluye Spring Boot Actuator:
bash# Health check
GET http://localhost:8080/actuator/health

# Métricas
GET http://localhost:8080/actuator/metrics
Solución de Problemas
Error: "Cannot connect to database"
bash# Verificar que PostgreSQL esté corriendo
docker-compose ps

# Ver logs
docker-compose logs db
Error: "Port 8080 already in use"
bash# Cambiar puerto en application.properties
server.port=8081
Tests fallan
bash# Limpiar y recompilar
mvn clean install -U
📝 Documentación Adicional

Guía de Spring Boot
JPA Documentation
Docker Best Practices

Contribuir

Fork el proyecto
Crea una rama (git checkout -b feature/nueva-funcionalidad)
Commit tus cambios (git commit -am 'Agregar nueva funcionalidad')
Push a la rama (git push origin feature/nueva-funcionalidad)
Abre un Pull Request

📄 Licencia
Este proyecto está bajo la Licencia MIT.
