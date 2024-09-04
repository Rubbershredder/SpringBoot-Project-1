
# Spring Boot MongoDB Project

## Overview

This project is a Spring Boot application that interacts with a MongoDB database. It provides RESTful endpoints to retrieve and post data, with Atlas Search implemented for enhanced querying capabilities.

## Features

- **CRUD Operations**: 
  - Retrieve data from MongoDB.
  - Post data to MongoDB.
  
- **Atlas Search**:
  - Advanced search capabilities integrated with MongoDB Atlas for faster and more accurate search results.

## Technologies Used

- **Java 11/17**
- **Spring Boot** 
- **MongoDB (Atlas)**
- **Maven**
- **Atlas Search**

## Endpoints

### 1. Get All Posts
```
GET /posts
```
Retrieves all posts stored in the MongoDB database.

**Example Response:**
```json
[
  {
    "profile": "developer",
    "desc": "Software engineer who can work on enterprise projects using spring boot and mongodb and react",
    "exp": 1,
    "techs": ["java", "jee", "spring", "springboot", "microservices"]
  },
  ...
]
```

### 2. Get Posts by Technology
```
GET /posts/{tech}
```
Retrieves posts filtered by a specific technology (e.g., `mongodb`, `java`, etc.).

**Example Response for `/posts/mongodb`:**
```json
[
  {
    "profile": "developer",
    "desc": "Software engineer who can work on enterprise projects using spring boot and mongodb and react",
    "exp": 1,
    "techs": ["java", "jee", "spring", "springboot", "microservices"]
  }
]
```

### 3. Post a New Profile
```
POST /posts
```
Adds a new profile to the MongoDB database.

**Example Request Body:**
```json
{
  "profile": "Java Expert",
  "desc": "Associate consultant for Cloud AWS, PCF, Azure, Redhat",
  "exp": 10,
  "techs": ["java", "jee", "design patterns", "springboot", "cloud", "microservices"]
}
```

## Setup and Installation

### Prerequisites

- Java 11/17
- Maven
- MongoDB Atlas account

### Steps

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/your-repo-name.git
    cd your-repo-name
    ```

2. **Configure MongoDB**:
   - Set up a MongoDB Atlas cluster.
   - Update `application.properties` with your MongoDB URI.

    ```properties
    spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<dbname>?retryWrites=true&w=majority
    ```

3. **Build the Project**:
    ```bash
    mvn clean install
    ```

4. **Run the Application**:
    ```bash
    mvn spring-boot:run
    ```

5. **Access the Endpoints**:
   - Open your browser and navigate to `http://localhost:8080/posts`.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
