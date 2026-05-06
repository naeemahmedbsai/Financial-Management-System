# Financial Management System

## Description

This is a Java-based Financial Management System that allows users to manage income, expenses, view transactions, and check account balance using a MySQL database.

## Group Members

* Naeem Ahmed – 023-25-0225 – Section B (AI)
* Muhammad Aslam – 023-25-0223 – Section B (AI)

## Purpose

The purpose of this system is to help users track and manage their financial activities efficiently.

## Modules

* models (Account, Transaction, Income, Expense)
* dao (database operations)
* service (business logic)
* util (database connection)
* ui (Main and MainGUI)

## OOP Concepts Used

* Encapsulation (private variables with getters/setters)
* Inheritance (Transaction → Income, Expense)
* Polymorphism (method overriding getDetails())
* Abstraction (AccountOperations interface)
* Exception Handling (try-catch blocks)

## How to Run

1. Install JDK 8 or higher
2. Place mysql-connector-j-9.7.0.jar in project folder
3. Compile:
   javac -cp ".;mysql-connector-j-9.7.0.jar" Main.java MainGUI.java dao/*.java models/   *.java service/*.java util/*.java
4. Run:
   java -cp ".;mysql-connector-j-9.7.0.jar" MainGUI
 
## Database

* MySQL required
* Import the provided SQL file before running the project

## Video Demo

https://youtu.be/SkslpubJYUs

## GitHub Repository

https://github.com/naeemahmedbsai/Financial-Management-System
