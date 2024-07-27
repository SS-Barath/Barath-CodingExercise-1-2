# Exercise 1 - Design Patterns 

## Overview
This project demonstrates various design patterns categorized into Behavioral, Creational, and Structural patterns. Each pattern is implemented in a real-world system to showcase its application.

## Behavioral Design Patterns

### 1. Strategy Pattern
#### System: Payment Processing System
- **Description**: The Strategy Pattern is used to define a family of algorithms, encapsulate each one, and make them interchangeable. This pattern allows the algorithm to vary independently from clients that use it.
- **Application**: In the Payment Processing System, different payment methods (Credit Card, PayPal, etc.) are encapsulated as strategies.

### 2. Observer Pattern
#### System: Stock Market Ticket System
- **Description**: The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- **Application**: In the Stock Market Ticket System, stock prices are observed, and changes are automatically reflected in subscribed components.

## Creational Design Patterns

### 1. Singleton Pattern
#### System: Cache Manager System
- **Description**: The Singleton Pattern ensures a class has only one instance and provides a global point of access to it.
- **Application**: In the Cache Manager System, the cache is managed as a singleton to ensure that all parts of the application access the same instance of the cache.

### 2. Prototype Pattern
#### System: Dashboard Prototype System
- **Description**: The Prototype Pattern is used to create duplicate objects while keeping performance in mind. This pattern involves implementing a prototype interface, which tells to create a clone of the current object.
- **Application**: In the Dashboard Prototype System, various dashboard configurations can be cloned to quickly create similar setups.

## Structural Design Patterns

### 1. Composite Pattern
#### System: Menu System
- **Description**: The Composite Pattern is used when we need to treat a group of objects in a similar way as a single instance of an object. The pattern composes objects into tree structures to represent part-whole hierarchies.
- **Application**: In the Menu System, menu items and submenus are managed using a composite structure to allow uniform treatment of both.

### 2. Facade Pattern
#### System: Travel Booking System
- **Description**: The Facade Pattern provides a simplified interface to a complex subsystem. It defines a higher-level interface that makes the subsystem easier to use.
- **Application**: In the Travel Booking System, a facade is used to simplify interactions with various subsystems such as flight booking, hotel reservation, and car rental services.

## Project Structure
- **Behavioral Design Patterns**
  - **Strategy Pattern**
    - Payment Processing System
  - **Observer Pattern**
    - Stock Market Ticket System
 **Creational Design Patterns**
  - **Singleton Pattern**
    - Cache Manager System
  - **Prototype Pattern**
    - Dashboard Prototype System
- **Structural Design Patterns**
  - **Composite Pattern**
    - Menu System
  - **Facade Pattern**
    - Travel Booking System

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# Exercise 2 - Virtual Classroom Manager

Welcome to the Virtual Classroom Manager! This project is a console-based application to manage virtual classrooms, students, and assignments. It provides functionalities like adding classrooms, enrolling students, scheduling and submitting assignments, and listing classrooms and students.

## Features

- Add Classroom
- Add Student
- Schedule Assignment
- Submit Assignment
- List Classrooms
- List Students in Classroom
- Remove Classroom
- View Classroom Details

## Getting Started

### Prerequisites

Ensure you have the following installed on your machine:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 11 or later)
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code)



