This project is a simple **Java console-based application** that demonstrates **CRUD operations (Create, Read, Update, Delete)** on a **MySQL database** using **JDBC**.  
It manages student records such as **ID, Name, and Marks** through a **menu-driven interface**.

## Features

- Create a `STUDENT` table in MySQL
- Insert multiple student records
- Update student marks using student ID
- Display all student records
- Delete the student table
- Menu-driven console interface

---

## Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- MySQL Connector/J
- VS Code (or any Java IDE)

---

## Database Structure

**Database Name:** `mydb`  
**Table Name:** `STUDENT`

| Column | Data Type |
|------|-----------|
| id | int (Primary Key) |
| name | varchar(50) |
| marks | int |

---

## How to Run the Project

1. Install **MySQL** and create a database:
   ```sql
   CREATE DATABASE mydb;
2. Download and add MySQL Connector/J to your project classpath.
3. Update database credentials in the code if required:
Connection connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/mydb",
    "root",
    "your_password"
);
4. Compile and run the program:

javac crud.java
java crud
