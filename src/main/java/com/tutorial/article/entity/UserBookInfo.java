package com.tutorial.article.entity;

public class UserBookInfo {
    private String userId;
    private String userName;
    private long totalBooksBorrowed;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTotalBooksBorrowed() {
        return totalBooksBorrowed;
    }

    public void setTotalBooksBorrowed(long totalBooksBorrowed) {
        this.totalBooksBorrowed = totalBooksBorrowed;
    }
}

