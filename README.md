# 📚 Library Management System - Spring Boot REST API

An elegant and complete Spring Boot project demonstrating RESTful API development, environment profiles, exception handling, logging, and monitoring.

<img width="699" height="622" alt="image" src="https://github.com/user-attachments/assets/49553907-aaf6-4c0b-8805-48d2347dfd61" />

---

## 🚀 Features
- Add, fetch, borrow, return, and delete books
- RESTful endpoints with JSON responses
- Data persistence via Spring Data JPA
- Swagger UI documentation at `/swagger-ui/index.html`
- Spring Boot Actuator for health monitoring
- Environment-specific profiles: **H2 (Dev)**, **PostgreSQL (Prod)**

---

## 🛠️ Tech Stack
- Java 17  
- Spring Boot 3.5.4  
- Spring Data JPA  
- PostgreSQL / H2 Database  
- Springdoc OpenAPI (Swagger)  
- Maven  

---

## ⚙️ Setup & Run

### 1️⃣ Clone the repo
```bash
git clone https://github.com/your-username/librarymanagement.git
cd librarymanagement
```

### 2️⃣ Build the project
```bash
./mvnw clean install
```

### 3️⃣ Run (Dev profile, H2)
```bash
./mvnw spring-boot:run
```

### 4️⃣ Run (Prod profile, PostgreSQL)
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

---

## 🔑 API Endpoints

| Method | Endpoint                 | Description              |
|--------|--------------------------|--------------------------|
| GET    | `/api/books`             | Fetch all books          |
| GET    | `/api/books/{id}`        | Fetch a book by ID       |
| POST   | `/api/books`             | Add a new book           |
| PUT    | `/api/books/{id}/borrow` | Borrow a book            |
| PUT    | `/api/books/{id}/return` | Return a borrowed book   |
| DELETE | `/api/books/{id}`        | Delete a book            |

---

## 🧪 Testing
- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)  
- Use **Postman** or **curl** to test endpoints  

Example `POST /api/books` request:
```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

---

## 🩺 Monitoring
- Health endpoint → [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)  
- Info endpoint → [http://localhost:8080/actuator/info](http://localhost:8080/actuator/info)  

---

## 👨‍💻 Author
Built for academic assignment by **Diksha**  
# librarymanagementsystem
# librarymanagement
