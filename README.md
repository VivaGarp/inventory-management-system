# Inventory Management System

Full-stack web application for managing product inventory using Angular, Spring Boot, and MySQL.

The application provides a REST API for product management and an Angular interface for performing CRUD operations.

## Features

- List products
- Add new products
- Edit existing products
- Delete products
- Product data validation
- Global validation error handling
- MySQL persistence
- REST API integration between Angular and Spring Boot
- Backend unit tests

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

### Database

- MySQL 8.4

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
│   ├── angular.json
│   └── package.json
│
├── .gitignore
└── README.md
```

## REST API

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

## Requirements

Before running the project, make sure you have installed:

- Java 21
- Node.js
- npm
- MySQL

## Installation

### Clone the repository

```bash
git clone https://github.com/VivaGarp/inventory-management-system.git
cd inventory-management-system

### Backend

From the project root:

```powershell
cd backend
.\mvnw.cmd spring-boot:run

http://localhost:8080/inventario-app

### Frontend

Open another terminal from the project root:

```powershell
cd frontend
npm ci
npm start

http://localhost:4200

## Build

### Backend

```powershell
cd backend
.\mvnw.cmd clean package

### Frontend

```powershell
cd frontend
npm run build

## Author

Eduardo Ivan De la Paz Sanchez