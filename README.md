# StickIt! API

A clean and production-ready REST API built with Spring Boot, focused on correct architecture, clear responsibilities, and frontend integration readiness.

---

## 🚀 Overview

StickIt API is a backend service for managing notes, designed with professional backend practices in mind.  
The project emphasizes clean architecture, validation, error handling, and proper HTTP semantics.

---

## 🛠 Technologies

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA
- Hibernate ORM  
- H2 Database (in-memory)  
- Bean Validation (Jakarta Validation)  
- Maven  

---

## 🧱 Architecture & Design Principles

- Layered architecture  
  - Controller (HTTP layer)  
  - Service (business logic)  
  - Repository (data access)  

- Clear separation of concerns  
- No business logic inside controllers  
- No direct entity exposure to the API  

---

## 📦 Data Transfer Objects (DTOs)

The API uses DTOs to isolate the domain model from external contracts:

- Request DTOs for input validation  
- Response DTOs for controlled output  
- Different DTOs for different operations (Create vs Update)  

This ensures:

- Safer API evolution  
- Better validation control  
- No accidental data exposure  

---

## ✅ Validation

- Bean Validation annotations  
- Context-aware validation  
- Mandatory fields enforced only where appropriate (e.g. create vs update)  

---

## ❗ Global Error Handling

- Centralized exception handling using `@ControllerAdvice`  
- Consistent JSON error responses  
- Proper HTTP status codes (400, 404, etc.)  

Example error response format:

```
{
  "timestamp": "2026-01-01T12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Note not found",
  "path": "/notes/99"
}
```

---

## 🔐 CORS Ready

CORS configuration prepared for frontend integration, allowing clean communication with a separate frontend application.

