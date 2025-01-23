package com.tutorial.article.service;

import com.mongodb.client.model.Sorts;
import com.tutorial.article.entity.*;
import com.tutorial.article.repository.BooksRepository;
import com.tutorial.article.repository.IssueDetailsRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AggregationService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private BooksRepository booksRepository;

    // Aggregation for Books: Count total books
    public long getTotalBooks() {
        return booksRepository.count();
    }

    // Aggregation for IssueDetails: Get total issues per user
    public List<UserBookInfo> getTotalIssuesPerUser() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("user.id")
                        .count().as("totalBooksBorrowed"),
                Aggregation.lookup("users", "_id", "_id", "userInfo"),
                Aggregation.unwind("userInfo"),
                Aggregation.project()
                        .andExclude("_id")
                        .and("$_id").as("userId")
                        .and("userInfo.name").as("userName")
                        .and("totalBooksBorrowed").as("totalBooksBorrowed"),
                Aggregation.sort(Sort.by(Sort.Direction.DESC, "totalBooksBorrowed"))
        );

        AggregationResults<UserBookInfo> result = mongoTemplate.aggregate(
                aggregation,
                "issueDetails",
                UserBookInfo.class
        );
        return result.getMappedResults();
    }

    //Aggregation to get the author aliases
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
}

