# Employee Management System

## Overview
The **Employee Management System** is a simple web application built using **Java, Struts 2, and Hibernate**. It provides essential **CRUD (Create, Read, Update, Delete)** functionalities for managing employee records efficiently.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used
- **Java:** Core programming language.
- **Struts 2:** MVC-based web application framework.
- **Hibernate:** ORM (Object-Relational Mapping) framework.
- **JSP (JavaServer Pages):** Dynamic web page creation.
- **MySQL:** Relational database system.
- **Maven:** Build automation and dependency management.
- **Jetty:** Lightweight web server for local development.
- **Bootstrap:** Front-end framework for responsive UI design.

## Prerequisites
Ensure you have the following installed before proceeding:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (Version 21 or higher)
- [Maven](https://maven.apache.org/download.cgi) (Build and dependency management)
- [MySQL](https://www.mysql.com/downloads/) (Database system)
- An IDE (e.g., [IntelliJ IDEA](https://www.jetbrains.com/idea/download/), [Eclipse](https://www.eclipse.org/downloads/))

## Setup and Installation
Follow these steps to set up the project:

1. **Clone the repository:**
   ```bash
   git clone <repository_url>
   cd EmployeeManagementSystem
   ```

2. **Configure the MySQL Database:**
   - Create a new database in MySQL:
     ```sql
     CREATE DATABASE employee_db;
     ```
   - Update database connection details in `src/main/resources/hibernate.cfg.xml`:
     ```xml
     <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/employee_db?createDatabaseIfNotExist=true</property>
     <property name="hibernate.connection.username">root</property>
     <property name="hibernate.connection.password"></property>
     ```

3. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```

4. **Run the application using Jetty Maven Plugin:**
   ```bash
   mvn jetty:run
   ```

5. **Access the application:**
   Open a web browser and visit:
   ```
   http://localhost:8080/
   ```

## Project Structure
```
EmployeeManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── action/       # Struts 2 Actions (Controller layer)
│   │   │       ├── dao/          # Data Access Objects (Database interactions)
│   │   │       ├── model/        # Hibernate Entity Models
│   │   │       ├── service/      # Business Logic Services
│   │   │       └── util/         # Utility Classes (e.g., HibernateUtil for session management)
│   │   ├── resources/
│   │   │   ├── hibernate.cfg.xml # Hibernate Configuration
│   │   │   └── struts.xml        # Struts Configuration
│   │   ├── webapp/
│   │   │   ├── WEB-INF/
│   │   │   │   ├── views/        # JSP Views
│   │   │   │   └── web.xml       # Web Application Configuration
│   │   │   └── index.jsp         # Entry Page
├── target/                       # Compiled Build Files
├── pom.xml                        # Maven Configuration
└── README.md                      # Project Documentation
```

## Configuration
- **Hibernate Configuration:**
  - File: `src/main/resources/hibernate.cfg.xml`
  - Defines database connection, dialect, and entity mappings.

- **Struts 2 Configuration:**
  - File: `src/main/resources/struts.xml`
  - Defines action mappings, result pages, and interceptors.

## Usage
The application provides the following functionalities:
- **View Employees:** Displays a list of employees.
- **Add Employee:** Allows adding a new employee.
- **Edit Employee:** Enables modifying employee details.
- **Delete Employee:** Removes an employee record.

## Contributing
Contributions are welcome! If you'd like to contribute:
1. Fork the repository.
2. Create a new branch (`feature-branch`)
3. Commit your changes.
4. Push to your fork and submit a Pull Request.

## License
This project is licensed under the [MIT License](LICENSE). Feel free to modify and use it as needed.

---
### Happy Coding! 🚀
