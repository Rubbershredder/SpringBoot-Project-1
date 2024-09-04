# Job Listing Application

## Overview
This Spring Boot application provides RESTful APIs for managing job listings. It connects to a MongoDB database to store and retrieve job postings, allowing users to:

- Add new job posts
- Retrieve all job posts
- Search for job posts based on text criteria

## Prerequisites
- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher
- MongoDB Atlas cluster with Atlas Search enabled
  - The application uses the `$search` aggregation stage, which requires MongoDB Atlas Search
- An IDE like IntelliJ IDEA or Eclipse (optional but recommended)

## Project Structure
```
JobListingApplication
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.JobSearch.JobListing
│   │   │       ├── Controller
│   │   │       │   └── PostController.java
│   │   │       ├── Model
│   │   │       │   └── Post.java
│   │   │       ├── Repo
│   │   │       │   ├── PostRepo.java
│   │   │       │   ├── SearchRepo.java
│   │   │       │   └── SearchRepoImpl.java
│   │   │       └── JobListingApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test
└── pom.xml
```

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/job-listing-application.git
cd job-listing-application
```

### 2. Configure MongoDB Atlas
1. Create a MongoDB Atlas Account: Sign up at [MongoDB Atlas](https://www.mongodb.com/cloud/atlas/register).
2. Create a Cluster: Set up a free-tier cluster.
3. Enable Atlas Search: Atlas Search is enabled by default on new clusters.
4. Whitelist Your IP Address: Go to Network Access and add your IP address.
5. Create a Database User: Go to Database Access and create a user with read/write permissions.
6. Note Your Connection String: You'll need this to connect your application to MongoDB Atlas.

### 3. Update Application Properties
In `src/main/resources/application.properties`, update the MongoDB connection details:

```properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/Cluster1?retryWrites=true&w=majority
```
Replace `<username>`, `<password>`, and `<cluster-url>` with your MongoDB Atlas credentials.

### 4. Build the Project
```bash
mvn clean install
```

### 5. Run the Application
```bash
mvn spring-boot:run
```
Alternatively, you can run the `JobListingApplication` class directly from your IDE.

## API Endpoints

### 1. Get All Posts
- **URL**: `/posts`
- **Method**: GET
- **Description**: Retrieves all job posts from the database.
- **Sample Request**:
  ```bash
  curl -X GET http://localhost:8080/posts
  ```

### 2. Add a New Post
- **URL**: `/post`
- **Method**: POST
- **Description**: Adds a new job post to the database.
- **Request Body**:
  ```json
  {
    "profile": "Software Engineer",
    "desc": "Looking for an experienced Java developer.",
    "exp": 3,
    "techs": ["Java", "Spring Boot", "MongoDB"]
  }
  ```
- **Sample Request**:
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{
    "profile": "Software Engineer",
    "desc": "Looking for an experienced Java developer.",
    "exp": 3,
    "techs": ["Java", "Spring Boot", "MongoDB"]
  }' http://localhost:8080/post
  ```

### 3. Search Posts
- **URL**: `/posts/{text}`
- **Method**: GET
- **Description**: Searches for job posts that match the given text in desc, profile, or techs.
- **Sample Request**:
  ```bash
  curl -X GET http://localhost:8080/posts/java
  ```

## Code Explanation

### Model
`Post.java`: Represents the job post entity with fields for profile, description, experience, and technologies.

### Repository
- `PostRepo.java`: Extends `MongoRepository<Post, String>` for CRUD operations.
- `SearchRepo.java`: Custom repository interface for search functionality.
- `SearchRepoImpl.java`: Implements `SearchRepo` using MongoDB's aggregation framework for text search.

### Controller
`PostController.java`: Provides endpoints for retrieving, adding, and searching job posts.

## Important Notes
- Atlas Search Requirement: The `$search` aggregation stage is only available with MongoDB Atlas Search enabled.
- Package Structure: Ensure all classes are within the base package `com.JobSearch.JobListing` or its sub-packages.

## Troubleshooting
- MongoDB Connection Issues: Verify connection string, IP whitelist, and cluster status.
- Dependency Injection Issues: Check component annotations and dependencies in `pom.xml`.

## Dependencies
Main dependencies include:
- Spring Boot Starter Data MongoDB
- Spring Boot Starter Web
- MongoDB Driver Sync

Ensure these are included in your `pom.xml`.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
