# Spring Boot CRUD Application with MongoDB’s Relational Migrator

This project demonstrates how to build a Spring Boot CRUD application by leveraging MongoDB’s Relational Migrator. The guide covers the process of migrating data from a relational database (Postgres) to MongoDB and generating the necessary application code to create a fully functional Spring Boot application.

## Overview

MongoDB’s Relational Migrator allows you to seamlessly migrate data from a relational database (like Postgres) to MongoDB, offering powerful features such as:

- **Data Migration:** Migrate relational data to MongoDB without downtime.
- **Code Generation:** Automatically generate Spring Boot boilerplate code for CRUD operations.
- **SQL-to-MongoDB Query Conversion:** Convert your existing relational SQL queries into MongoDB queries.
- **Aggregation Pipelines:** Utilize MongoDB’s aggregation framework to simplify complex queries.

This project illustrates how to modernize a legacy application that uses relational databases, using MongoDB as the new backend.

## Prerequisites

Before you begin, ensure you have the following:

- **Java 21 or above** installed.
- **MongoDB Atlas cluster:** A free MongoDB Atlas cluster to store your data.
- **Postgres Database Schema:** A relational database schema (Postgres) to migrate to MongoDB.
- **IDE of your choice** (e.g., IntelliJ IDEA).
- **MongoDB Relational Migrator:** Download the tool from MongoDB's official site.
- **PgAdmin** or any PostgreSQL client for managing the database.

## Getting Started

### 1. Install MongoDB Relational Migrator
Follow the instructions on the [MongoDB Tools download page](https://www.mongodb.com/try/download/database-tools) to install the Relational Migrator.

### 2. Download and Setup Postgres Schema
Download the SQL schema script for the Postgres database. The schema includes a sample library management system with 9 tables. Use PgAdmin to upload and explore the schema.

### 3. Migrate Data Using Relational Migrator
Once the data is ready in Postgres, use MongoDB Relational Migrator to migrate the data into MongoDB Atlas. The tool offers two migration strategies:
- **Continuous Migration:** Real-time migration with zero-downtime.
- **Snapshot Migration:** One-time point-in-time migration.

### 4. Generate Application Code
After the migration is complete, use the code generation feature of Relational Migrator to automatically generate Spring Boot application code for CRUD operations. Select Java and Spring Data as your framework.

### 5. Set Up Spring Boot Application
Clone or download the generated code. Then, create a new Spring Boot project using the Spring Initializr, and copy the generated code files into your project. You'll need to implement business logic in service layers and define RESTful APIs in controllers.

### 6. Implement Aggregation Pipelines
Use MongoDB’s aggregation framework to simplify queries. For example, a query to find all books reviewed within a specific date range or to get author aliases can be easily translated into MongoDB aggregation queries.

## Key Features

- **Data Migration:** Migrate data from relational databases (Postgres) to MongoDB.
- **Automatic Code Generation:** Generate Spring Boot CRUD code based on migrated data.
- **MongoDB Aggregation Framework:** Perform complex queries with ease.
- **Query Conversion:** Convert SQL queries to MongoDB queries automatically.

## Example Usage

Here are a few examples of MongoDB queries that replace complex SQL queries:

### Find Books Reviewed Within a Date Range:
```java
public List<ReviewsEntity> getBookReviews() {
    Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("timestamp")
                    .gte(new java.util.Date(1640995200000L))
                    .lte(new java.util.Date(1735603200000L))),
            Aggregation.lookup("books", "_id.bookId", "_id", "book"),
            Aggregation.unwind("book"),
            Aggregation.project()
                    .and("timestamp").as("timestamp")
                    .and("book.title").as("bookTitle")
                    .and("rating").as("rating")
                    .and("text").as("text"),
            Aggregation.sort(Sort.by(Sort.Direction.ASC, "timestamp"))
    );

    AggregationResults<ReviewsEntity> result = mongoTemplate.aggregate(
            aggregation,
            "reviews",
            ReviewsEntity.class
    );
    return result.getMappedResults();
}
```

### Get Author Aliases:
```java
public List<AuthorAlias> getAuthorAliases() {
    Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.project()
                    .andInclude("name", "authorAliases")
                    .andExclude("_id")
    );
    AggregationResults<AuthorAlias> result = mongoTemplate.aggregate(
            aggregation,
            "authors",
            AuthorAlias.class
    );
    return result.getMappedResults();
}
```

## Contributing

You can fork this project, make changes, and submit pull requests. If you encounter issues or have feature requests, please open an issue on this repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
