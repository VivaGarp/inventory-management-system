# Inventory Management System

Full-stack web application for managing product inventory using Angular, Spring Boot, MySQL, and Docker.

The application provides a REST API for product management and an Angular interface for performing complete CRUD operations.

The project is deployed in a production-like environment using Netlify for the frontend, Render for the backend, and Aiven for MySQL database hosting.

## Live Demo / Beta

**Frontend:**  
https://inventory-management-system-eduardo.netlify.app

**Backend API:**  
https://inventory-management-system-8exx.onrender.com/inventario-app

> This is a beta deployment intended for demonstration and portfolio purposes.

## Features

- List products
- Add new products
- Edit existing products
- Delete products
- Product data validation
- Global validation error handling
- MySQL persistence
- REST API integration between Angular and Spring Boot
- CORS configuration for local and production environments
- Backend unit tests
- Dockerized backend
- Production deployment

## Technologies

### Frontend

- Angular 20
- TypeScript 5.9
- RxJS
- Angular Router
- Angular Forms
- Bootstrap 5.3.8

### Backend

- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- Hibernate 6.6
- Maven
- JUnit 5
- Mockito
- Docker

### Database

- MySQL 8.4
- Aiven

### Deployment

- Netlify — Frontend
- Render — Backend
- Aiven — Database

## Architecture

```text
                    ┌──────────────────────┐
                    │       Netlify        │
                    │      Angular 20      │
                    │      Frontend        │
                    └──────────┬───────────┘
                               │ HTTPS
                               ▼
                    ┌──────────────────────┐
                    │        Render        │
                    │   Spring Boot API    │
                    │       Java 21        │
                    │       Docker         │
                    └──────────┬───────────┘
                               │ SSL
                               ▼
                    ┌──────────────────────┐
                    │        Aiven         │
                    │       MySQL 8.4      │
                    │    inventario_db     │
                    └──────────────────────┘
```

## Project Structure

```text
inventory-management-system/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/gm/inventarios/
│   │   │   │   ├── controlador/
│   │   │   │   ├── excepcion/
│   │   │   │   ├── modelo/
│   │   │   │   ├── repositorio/
│   │   │   │   └── servicio/
│   │   │   └── resources/
│   │   └── test/
│   ├── Dockerfile
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   │   └── app/
│   │       ├── agregar-producto/
│   │       ├── editar-producto/
│   │       ├── producto-lista/
│   │       ├── model/
│   │       └── servicios/
│   ├── public/
│   │   └── _redirects
│   ├── angular.json
│   └── package.json
│
├── .gitignore
└── README.md
```

## REST API

### Production

Base URL:

```text
https://inventory-management-system-8exx.onrender.com/inventario-app
```

### Local

Base URL:

```text
http://localhost:8080/inventario-app
```

| Method | Endpoint | Description |
|---|---|---|
| GET | `/inventario-app` | List all products |
| GET | `/inventario-app/{id}` | Get a product by ID |
| POST | `/inventario-app` | Create a product |
| PUT | `/inventario-app/{id}` | Update a product |
| DELETE | `/inventario-app/{id}` | Delete a product |

### Product

Example request body:

```json
{
  "descripcion": "Laptop",
  "precio": 15000,
  "existencia": 5
}
```

## Validation

Products are validated using Jakarta Validation.

- Description is required.
- Price is required and must be greater than zero.
- Stock quantity is required and cannot be negative.

Validation errors are handled through a global exception handler and returned with HTTP status `400 Bad Request`.

## Frontend Routes

| Route | Description |
|---|---|
| `/productos` | Product list |
| `/agregar-producto` | Add product |
| `/editar-producto/:id` | Edit product |

The root route redirects to `/productos`.

## CORS

The backend allows requests from:

```text
http://localhost:4200
https://inventory-management-system-eduardo.netlify.app
```

This allows the Angular application to communicate with the Spring Boot API both during local development and after deployment.

## Testing

The backend includes unit tests for the product controller using JUnit 5 and Mockito.

Tests cover:

- Product retrieval
- Product creation
- Product update
- Product deletion
- `404 Not Found` responses

The application context is also tested with Spring Boot.

Run all backend tests with:

```powershell
cd backend
.\mvnw.cmd test
```

## Requirements

Before running the project locally, make sure you have installed:

- Java 21
- Node.js
- npm
- MySQL

## Installation

### Clone the Repository

```bash
git clone https://github.com/VivaGarp/inventory-management-system.git
cd inventory-management-system
```

## Backend

From the project root:

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

The API will be available at:

```text
http://localhost:8080/inventario-app
```

### Database Configuration

The backend uses environment variables for database configuration.

Required variables:

```text
DB_HOST
DB_PORT
DB_NAME
DB_USER
DB_PASSWORD
```

Do not commit database credentials to the repository.

## Frontend

Open another terminal from the project root:

```powershell
cd frontend
npm ci
npm start
```

The application will be available at:

```text
http://localhost:4200
```

## Build

### Backend

```powershell
cd backend
.\mvnw.cmd clean package
```

### Frontend

```powershell
cd frontend
npm run build
```

Production files are generated in:

```text
frontend/dist/inventario-app/browser
```

## Docker

The backend includes a multi-stage Dockerfile.

The first stage builds the Spring Boot application using Maven and Java 21.

The second stage runs the generated JAR using a Java 21 runtime image.

The container is configured to expose port `8080` and supports the dynamic `PORT` environment variable provided by the deployment platform.

## Deployment

### Frontend

The Angular frontend is deployed on Netlify.

Production URL:

```text
https://inventory-management-system-eduardo.netlify.app
```

### Backend

The Spring Boot backend is deployed on Render using Docker.

Production API:

```text
https://inventory-management-system-8exx.onrender.com/inventario-app
```

### Database

The production database is hosted on Aiven using MySQL 8.4.

Database credentials are managed through environment variables and are not stored in the repository.

## Author

**Eduardo Ivan De la Paz Sanchez**

GitHub:  
https://github.com/VivaGarp