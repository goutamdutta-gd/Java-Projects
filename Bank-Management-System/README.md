# Bank Management System

A console-based Bank Management System built using Core Java.

## Features

. Create a new bank account
. Automatically generated account number
. PIN-based authentication
. Deposit money
. Withdraw money
. Check account balance
. View transaction history
. View personal account details
. Three PIN attempts for authentication
. Basic amount validation
. Insufficient balance checking
. Money transfer between accounts
. Logout

## Technologies Used

. Java
. Core Java Collections
. HashMap
. ArrayList
. Scanner

## Java Concepts Practiced

. Classes and Objects
. Constructors
. Encapsulation
. Methods
. HashMap
. ArrayList
. Loops
. Switch statements
. Conditional statements
. Basic input validation

## How It Works

When a user creates an account, the system automatically generates an account number and stores the Account object in a HashMap.

Each Account object contains:

. Account number
. Name
. Phone number
. PIN
. Balance
. Transaction history

Transaction history is maintained using an ArrayList inside each Account object.

## Current Limitations

. Data is stored only in memory
. Accounts are lost when the program terminates
. No database is currently used
. The application is console-based

## Future Improvements

. Change PIN
. File handling for data persistence
. Database integration
. PostgreSQL
. Spring Boot backend
. REST APIs
. Authentication and authorization

## Project Status

Version 1 - Core Java Console Application
