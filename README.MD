# 🏫 School Manager API

> A study project built with **Spring Boot** to practice backend development with real-world concepts: authentication, role-based authorization, and modular entity design.

---

## 📌 About the Project

**School Manager** is a RESTful API designed to manage the core operations of a school environment. Built as a **study initiative** to deepen knowledge in:

- Spring Boot + Spring Security
- JWT-based stateless authentication
- Role-based access control (RBAC) with `@PreAuthorize`
- Clean modular architecture
- JPA/Hibernate entity relationships

---

## 🧱 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17+ |
| Framework | Spring Boot 3.x |
| Security | Spring Security + JWT |
| ORM | Spring Data JPA / Hibernate |
| Database | PostgreSQL |
| Build Tool | Maven |
| Utilities | Lombok |

---

## 🔐 Authentication & Authorization

Authentication is handled via **JWT tokens** with a stateless session strategy. Each request must include a valid `Bearer` token in the `Authorization` header.

```http
Authorization: Bearer <your_token_here>
```

### Roles & Permissions

| Role | Description |
|---|---|
| `ADMIN` | Full access to all modules |
| `SECRETARY` | Can manage and view students; read-only on other modules |
| `TEACHER` | Read-only access |

> `Student` is **not** a system user — students don't log in, don't have passwords, and don't hold any role. They are managed by Admins and Secretaries.

## 🔭 Roadmap

| Module | Status |
|---|---|
| User + Auth | ✅ Done |
| Admin | ✅ Done |
| Teacher | ✅ Done |
| Secretary | ✅ Done |
| Student | ✅ Done |
| Classroom (Turma) | 📋 Planned |
| Subject (Disciplina) | 📋 Planned |
| Enrollment (Matrícula) | 📋 Planned |
| Attendance (Presença) | 📋 Planned |

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- PostgreSQL running locally

### Clone & configure

```bash
git clone https://github.com/majudlorenzoni/school-manager.git
cd school-manager
```

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/school_manager
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

api.security.token.secret=your_jwt_secret_here
```

### Run

```bash
./mvnw spring-boot:run
```

API available at `http://localhost:8080`.

### Quick start

```http
POST /auth/register
{ "login": "admin@school.com", "password": "admin123", "name": "Admin", "cpf": "000.000.000-00", "role": "ADMIN" }

POST /auth/login
{ "login": "admin@school.com", "password": "admin123" }
```

Use the returned token in all subsequent requests:
```http
Authorization: Bearer <token>
```

---

## 👨‍💻 Author

Built with purpose and curiosity as a hands-on learning experience in backend development with Java and Spring Boot.

## 📄 License

[MIT](LICENSE)