#  Blog Platform Backend

A robust, secure RESTful Blog Platform backend built with **Spring Boot**, ready for production and scalable blog projects.

---

##  Features

-  **JWT Authentication**: Secure register/login with token-based authentication.  
-  **Role-Based Access**: USER and ADMIN roles with fine-tuned authorization.  
-  **Blog Posts CRUD**: Users can create, read, update, or delete their own blog posts.  
-  **Comments**: Authenticated users can comment on posts. Everyone can read.  
-  **Public & Private APIs**: Public endpoints for viewing; private endpoints for create/update/delete.  
-  **Personal Blog Lists**: Every user manages their own list of blog posts!  
-  **Pagination & Filtering**: Efficient endpoints for large data sets.  
-  **Fully Layered Architecture**: Controllers, services, repositories, and DTOs neatly separated.  
-  **Spring Data JPA + PostgreSQL**: Real-world database integration.  
-  **Validation & Exception Handling**: Defensive coding with clear API responses.  
-  **API Documentation**: Swagger/OpenAPI integrated.

---

##  Tech Stack

- Spring Boot (Latest)  
- Spring Security (JWT)  
- Spring Data JPA  
- PostgreSQL  
- Javax Validation  
- Swagger / OpenAPI  
- JUnit & Mockito

---

##  Security

- Passwords hashed with **BCrypt**  
- JWT for stateless and scalable session management  
- Fine-grained **method-level authorization**  
- Only post/comment owners or admins can modify/delete

---

## 🧩 Folder Structure
    src/main/java/com/example/blogplatform/
     ├── config/        # Application and security configurations      
     ├── controller/    # REST API controllers
     ├── dto/           # Data Transfer Objects
     ├── entity/        # JPA Entities
     ├── exception/     # Custom exceptions and handlers
     ├── repository/    # Spring Data JPA Repositories
     ├── security/      # JWT filters, services, and models
     ├── service/       # Business logic layer
     ├── util/          # Helpers and utilities
