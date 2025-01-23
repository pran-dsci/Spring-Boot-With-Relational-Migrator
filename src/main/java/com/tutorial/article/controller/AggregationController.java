package com.tutorial.article.controller;

import com.tutorial.article.entity.*;
import com.tutorial.article.service.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aggregation")
public class AggregationController {

    @Autowired
    private AggregationService aggregationService;

    // Endpoint: Get total books
    @GetMapping("/books/total")
    public long getTotalBooks() {
        return aggregationService.getTotalBooks();
    }

    // Endpoint: Get total issues per user
    @GetMapping("/issue-details/total-issued")
    public List<UserBookInfo> getTotalIssuesPerUser() {
        return aggregationService.getTotalIssuesPerUser();
    }

    @GetMapping("/author-aliases")
    public List<AuthorAlias> getAuthorAliases() {
        return aggregationService.getAuthorAliases();
    }

    @GetMapping("/book-reviews-for-specific-date-range")
    public  List<ReviewsEntity> getBookReview(){
        return aggregationService.getBookReviews();
    }

}

