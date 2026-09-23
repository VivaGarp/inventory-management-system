# Inventory Management System

Full-stack web application for managing product inventory using Angular, Spring Boot, and MySQL.

## Features

- List products
- Add new products
- Edit existing products
- Delete products
- Store inventory data in MySQL
- REST API integration between Angular and Spring Boot

## Technologies

### Frontend
- Angular
- TypeScript
- HTML
- CSS

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

### Database
- MySQL

## REST API

```text
GET    /inventario-app
GET    /inventario-app/{id}
POST   /inventario-app
PUT    /inventario-app/{id}
DELETE /inventario-app/{id}
```

## Installation

### Prerequisites

- Java 21
- Node.js
- npm
- MySQL

### Backend

Set your MySQL password as an environment variable:

```powershell
$env:DB_PASSWORD="YOUR_MYSQL_PASSWORD"
```

Then run:

```powershell
cd backend
.\mvnw.cmd spring-boot:run
```

The API runs at:

```text
http://localhost:8080/inventario-app
```

### Frontend

```bash
cd frontend
npm ci
npm start
```

Open:

```text
http://localhost:4200
```

## Author

Eduardo Ivan De la Paz Sanchez