# NexTask 🚀

A robust, scalable, and highly decoupled Task Management API built with **Java** and **Spring Boot**, strictly adhering to **Clean Architecture** principles.

## 🎯 Objective
This project was born out of the desire to put into practice the **Clean Architecture** concepts I have been studying. The main goal is to build a real-world application that demonstrates advanced software design patterns, completely decoupling business rules from frameworks, databases, and external UI concerns.

## 🏗️ Architecture (Clean Architecture)
This project is divided into two main layers to respect the **Dependency Rule** (dependencies must point inward toward the domain):

### 1. Core (Domain & Application Rules)
The heart of the application. It contains 100% pure Java code with zero framework dependencies (no Spring annotations).
* **Entities & Enums:** Enterprise business rules and pure state.
* **Exceptions:** Domain-specific exceptions (e.g., preventing invalid state transitions).
* **Gateways (Interfaces):** Contracts defining how the core interacts with the outside world (Dependency Inversion).
* **Use Cases:** Application business rules orchestrating the entities.

### 2. Infrastructure (Adapters & Delivery)
The outermost layer responsible for interacting with the external world (Web, Database, and Frameworks).
* **Presentation:** REST Controllers defining the API endpoints.
* **DTOs & Mappers:** Translating data between the Web, the Domain, and the Database.
* **Persistence:** JPA Entities, Spring Data Repositories, and Flyway Migrations.
* **Gateways (Impl):** Concrete implementations of the core interfaces.
* **Exception Handling:** Global `@ControllerAdvice` to intercept domain exceptions and return standardized, elegant JSON error responses.
* **Beans:** Spring `@Configuration` classes bridging the pure Java Use Cases with the Spring IoC Container.

## 💻 Technologies & Tools
* **Java 17+**
* **Spring Boot 3** (Web, Data JPA)
* **PostgreSQL** (Relational Database)
* **Flyway** (Database Migrations)
* **Docker & Docker Compose** (Containerization)
* **Maven** (Dependency Management)

## 🚀 Getting Started

### Prerequisites
* Java 17 or higher installed.
* Docker and Docker Compose installed.

### Running the Application

1. **Start the Database via Docker:**
```bash
docker-compose up -d
```

2. **Run the Application:**
```bash
./mvnw spring-boot:run
```
*Flyway will automatically execute the migrations and create the tables upon startup.*

## 📌 Main Features & Endpoints
* **Create Task:** `POST /tasks`
* **List All Tasks:** `GET /tasks` (Ordered by ID automatically)
* **Update Task Status:** `PUT /tasks/{id}/status`
    * *Includes strict domain validation (e.g., a task cannot jump directly from `PENDING` to `DONE`). Invalid transitions are caught by the Global Exception Handler, returning a clear `400 Bad Request`.*

## 🤝 Contributing
Contributions, issues, and feature requests are welcome! Feel free to check the issues page.

## 📝 License
This project is MIT licensed.