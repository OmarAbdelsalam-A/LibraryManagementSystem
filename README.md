# Library Management System

## Overview

This project is a RESTful API for managing a library system. The system allows for managing books, patrons, and borrowing records. It includes features like validation, error handling, caching, logging, and transaction management. The project is built using Spring Boot and follows a layered architecture with entities, repositories, services, and controllers.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Validation and Error Handling](#validation-and-error-handling)
- [Security](#security)
- [Caching](#caching)
- [Logging and AOP](#logging-and-aop)
- [Transaction Management](#transaction-management)
- [Testing](#testing)

## Features

- **Manage Books**: Add, update, delete, and retrieve books.
- **Manage Patrons**: Add, update, delete, and retrieve patrons.
- **Borrowing Records**: Track the borrowing and returning of books by patrons.
- **Validation**: Ensures data integrity and proper input through annotations.
- **Error Handling**: Global exception handling for meaningful error responses.
- **Security**: Basic authentication to protect the API.
- **Caching**: Uses Spring’s caching mechanism to improve performance.
- **Logging**: Logs method calls and exceptions using Aspect-Oriented Programming (AOP).
- **Transaction Management**: Ensures data integrity through transaction management.

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/OmarAbdelsalam-A/LibraryManagementSystem.git
cd LibraryManagementSystem
```

### 2. Configure the Application

By default, the application uses an in-memory H2 database. If you want to use MySQL or PostgreSQL, update the `application.properties` file in `src/main/resources/` with your database connection details.

### 3. Build and Run the Application

You can build and run the application using Maven:

```bash
mvn clean install
mvn spring-boot:run
```

### 4. Access the Application

The application will be running on `http://localhost:8080`. You can access the H2 console at `http://localhost:8080/h2-console`.

## API Endpoints

### Book Management

- **GET /api/books**: Retrieve a list of all books.
- **GET /api/books/{id}**: Retrieve details of a specific book by ID.
- **POST /api/books**: Add a new book to the library.
- **PUT /api/books/{id}**: Update an existing book's information.
- **DELETE /api/books/{id}**: Remove a book from the library.

### Patron Management

- **GET /api/patrons**: Retrieve a list of all patrons.
- **GET /api/patrons/{id}**: Retrieve details of a specific patron by ID.
- **POST /api/patrons**: Add a new patron to the system.
- **PUT /api/patrons/{id}**: Update an existing patron's information.
- **DELETE /api/patrons/{id}**: Remove a patron from the system.

### Borrowing Management

- **POST /api/borrow/{bookId}/patron/{patronId}**: Allow a patron to borrow a book.
- **PUT /api/return/{bookId}/patron/{patronId}**: Record the return of a borrowed book by a patron.

## Validation and Error Handling

- **Input Validation**: The API uses Jakarta Bean Validation to validate incoming data.
- **Error Handling**: Custom error messages are returned for invalid requests, with appropriate HTTP status codes.

## Security

- **Basic Authentication**: The API is secured with basic authentication. You can change the credentials in `SecurityConfig.java`.
- **Username**: `user`
- **Password**: `password`

## Caching

- **Caching**: The API uses Spring’s caching abstraction to cache frequently accessed data, improving the system’s performance.

## Logging and AOP

- **Logging**: Method calls in the service layer are logged using Aspect-Oriented Programming (AOP).

## Transaction Management

- **Transaction Management**: The API uses Spring’s `@Transactional` annotation to ensure data integrity during critical operations.

## Testing

Unit tests are included to validate the functionality of the service layer. To run the tests, use:

```bash
mvn test
```