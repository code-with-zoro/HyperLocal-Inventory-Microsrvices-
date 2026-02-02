# HyperLocal Inventory System

A **microservices-based backend system** designed for **hyperlocal product discovery**, where users can search for products available near their location.  
The project demonstrates **real-world backend architecture** using Spring Boot, Spring Cloud, and secure JWT-based authentication.

---

## Project Overview

The **HyperLocal Inventory System** simulates how modern hyperlocal platforms (delivery apps, local marketplaces, etc.) manage:

- User authentication
- Location-aware product discovery
- Secure request routing
- Scalable service communication

The system follows a **microservices architecture**, ensuring scalability, fault isolation, and clean separation of concerns.

---

## Architecture

The system is built using the following core components:

###  Services
- **API Gateway**
  - Single entry point for all client requests
  - Routes requests dynamically using service discovery
  - Applies JWT authentication filter

- **Eureka Server**
  - Central service registry
  - Enables dynamic service discovery
  - Removes hardcoded service URLs

- **User Auth Service**
  - Handles user login and authentication
  - Generates and validates JWT tokens
  - Manages secure access to protected APIs

- **Inventory Service**
  - Manages vendor products
  - Stores and retrieves product information

- **Location Service**
  - Handles user and vendor location data
  - Supports proximity-based operations

- **Search Service**
  - Performs optimized product search
  - Filters results based on distance and availability

---

##  Security

- JWT-based stateless authentication
- Token validation at:
  - API Gateway
  - Individual services (defense in depth)
- No server-side session storage
- Sensitive configuration handled using **environment variables**

---

##  Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Cloud Gateway
- Netflix Eureka

### Database
- MongoDB
  - Service-specific collections
  - Auto-index creation enabled

### Configuration & Tooling
- Environment-variable-based configuration
- Git & GitHub
- Docker-ready project structure (planned)

---

## 📁 Project Structure

```text
HyperLocal-Inventory/
│
├── api-gateway/
├── eureka-server/
├── user-auth-service/
├── inventory-service/
├── location-service/
├── search-service/
│
├── .gitignore
├── .env.example
└── README.md
