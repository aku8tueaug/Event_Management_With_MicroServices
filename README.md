# Event Management – BackEnd System

The Tickets App is a backend system for an event management platform. 
It allows users to register for events and enables organizers to create and manage them. 
The application follows a clean microservices architecture for modularity and scalability.

## Overview

This project includes separate services to handle:

- User registration and management
- Event creation, update, and deletion
- Event registration workflow (user-event linking)

Services communicate via REST APIs and are backed by MongoDB and PostgreSQL databases.

## Features

- User registration and login functionality
- Organizer event creation and management (CRUD)
- Event listing and user registration to events
- Clean codebase using layered architecture
- Microservices architecture for modular deployment
- RESTful APIs for inter-service communication
- Docker-based setup for databases and environment isolation

## Tech Stack

- Java 17
- Spring Boot
- MongoDB
- PostgreSQL
- Docker
- Maven
- REST APIs

## Prerequisites

- Java 17 or later
- Maven
- Docker and Docker Compose

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/aku8tueaug/Event_Management_With_MicroServices.git
cd Event_Management_With_MicroServices
