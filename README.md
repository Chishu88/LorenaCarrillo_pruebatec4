### LorenaCarrillo_pruebatec4

# Travel Agency Management System
This document presents an overview of the Travel Agency Management System developed using Spring Boot and Java. The system enables the management of hotels and flights, as well as the booking of reservations for them.

## Project Description
The system has been developed using Spring Boot and Java for the backend, with integration of Spring Security for endpoint security. It utilizes JPA for data persistence and MySQL as the relational database. Additionally, examples of HTTP requests using Postman are provided to facilitate understanding and integration of the system.

## Key Features
Hotel Management: allows retrieving a list of registered hotels, searching for available hotels within a specific date range and destination, and making hotel room reservations.
Flight Management: enables retrieving a list of registered flights, searching for available flights within a specific date range and origin/destination, and making flight reservations.
CRUD (Create, Read, Update, Delete) operations on the database for both hotels and flights.
Authentication for travel agency employees who wish to perform operations for database management.

## User Stories - Hotels
Retrieve a list of all registered hotels

Method: **GET**
Path: /agency/hotels
Retrieve a list of all available hotels within a specific date range and destination

Method: **GET**
Path: /agency/hotels?dateFrom=dd/mm/yyyy&dateTo=dd/mm/yyyy&destination="destination_name"
Make a hotel reservation

Method: **POST**
Path: /agency/hotel-booking/new
Example request (JSON):

## User Stories - Flights
Retrieve a list of all registered flights

Method: **GET**
Path: /agency/flights
Retrieve a list of all available flights within a specific date range and selected origin/destination

Method: **GET**
Path: /agency/flights?dateFrom=dd/mm/yyyy&dateTo=dd/mm/yyyy&origin="origin_city"&destination="destination_city"
Make a flight reservation

Method: **POST**
Path: /agency/flight-booking/new
Example request (JSON)

## CRUD Operations

Hotel Operations
Create: **POST** /agency/hotels/new

Update: **PUT** /agency/hotels/edit/{id}

Delete: **DELETE** /agency/hotels/delete/{id}

Get hotel by ID: **GET** /agency/hotels/{id}

Get all hotels: **GET** /agency/hotels

Flight Operations
Create: **POST** /agency/flights/new
Update: **PUT** /agency/flights/edit/{id}
Delete: **DELETE** /agency/flights/delete/{id}
Get flight by ID: **GET** /agency/flights/{id}
Get all flights: **GET** /agency/flights


Acces to Swagger: [Link](http://localhost:8080/doc/swagger-ui/index.html)
