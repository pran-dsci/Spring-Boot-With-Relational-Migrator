package com.tutorial.article.entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDateTime;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;



import java.util.*;
import jakarta.annotation.Generated;

/**
 * Generated by MongoDB Relational Migrator
 * https://www.mongodb.com/products/relational-migrator
 * Collection: issueDetails
 * Language: Java
 * Template: Spring Data
 * Generated on 2025-01-22
 */
@JsonTypeName("issueDetails")
@Generated(value = "com.mongodb.migrator.application.codegen.config.java.JavaSpringCodegenConfig", date = "2025-01-22T20:18:00.222415+05:30[Asia/Kolkata]", comments = "Generator version: 7.9.0")
@Document("issueDetails")
public class IssueDetailsEntity {

  @BsonProperty("_id")
  private Integer id;

  @BsonProperty("borrowDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime borrowDate;

  @BsonProperty("dueDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime dueDate;

  @BsonProperty("recordType")
  private String recordType;

  @BsonProperty("returned")
  private Boolean returned;

  @BsonProperty("returnedDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime returnedDate;

  @BsonProperty("expirationDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime expirationDate;

  @BsonProperty("books")
  private IssueDetailsBooksEntity books;

  @BsonProperty("user")
  private IssueDetailsUserEntity user;

  @BsonProperty
  private int totalBooksBorrowed;

  public int getTotalBooksBorrowed() {
    return totalBooksBorrowed;
  }

  public void setTotalBooksBorrowed(int totalBooksBorrowed) {
    this.totalBooksBorrowed = totalBooksBorrowed;
  }

  public IssueDetailsEntity id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @JsonProperty("_id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public IssueDetailsEntity borrowDate(LocalDateTime borrowDate) {
    this.borrowDate = borrowDate;
    return this;
  }

  /**
   * Get borrowDate
   * @return borrowDate
   */
  
  @JsonProperty("borrowDate")
  public LocalDateTime getBorrowDate() {
    return borrowDate;
  }

  public void setBorrowDate(LocalDateTime borrowDate) {
    this.borrowDate = borrowDate;
  }

  public IssueDetailsEntity dueDate(LocalDateTime dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  /**
   * Get dueDate
   * @return dueDate
   */
  
  @JsonProperty("dueDate")
  public LocalDateTime getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDateTime dueDate) {
    this.dueDate = dueDate;
  }

  public IssueDetailsEntity recordType(String recordType) {
    this.recordType = recordType;
    return this;
  }

  /**
   * Get recordType
   * @return recordType
   */
  
  @JsonProperty("recordType")
  public String getRecordType() {
    return recordType;
  }

  public void setRecordType(String recordType) {
    this.recordType = recordType;
  }

  public IssueDetailsEntity returned(Boolean returned) {
    this.returned = returned;
    return this;
  }

  /**
   * Get returned
   * @return returned
   */
  
  @JsonProperty("returned")
  public Boolean getReturned() {
    return returned;
  }

  public void setReturned(Boolean returned) {
    this.returned = returned;
  }

  public IssueDetailsEntity returnedDate(LocalDateTime returnedDate) {
    this.returnedDate = returnedDate;
    return this;
  }

  /**
   * Get returnedDate
   * @return returnedDate
   */
  
  @JsonProperty("returnedDate")
  public LocalDateTime getReturnedDate() {
    return returnedDate;
  }

  public void setReturnedDate(LocalDateTime returnedDate) {
    this.returnedDate = returnedDate;
  }

  public IssueDetailsEntity expirationDate(LocalDateTime expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Get expirationDate
   * @return expirationDate
   */
  
  @JsonProperty("expirationDate")
  public LocalDateTime getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDateTime expirationDate) {
    this.expirationDate = expirationDate;
  }

  public IssueDetailsEntity books(IssueDetailsBooksEntity books) {
    this.books = books;
    return this;
  }

  /**
   * Get books
   * @return books
   */
  
  @JsonProperty("books")
  public IssueDetailsBooksEntity getBooks() {
    return books;
  }

  public void setBooks(IssueDetailsBooksEntity books) {
    this.books = books;
  }

  public IssueDetailsEntity user(IssueDetailsUserEntity user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   */
  
  @JsonProperty("user")
  public IssueDetailsUserEntity getUser() {
    return user;
  }

  public void setUser(IssueDetailsUserEntity user) {
    this.user = user;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueDetailsEntity issueDetails = (IssueDetailsEntity) o;
    return Objects.equals(this.id, issueDetails.id) &&
        Objects.equals(this.borrowDate, issueDetails.borrowDate) &&
        Objects.equals(this.dueDate, issueDetails.dueDate) &&
        Objects.equals(this.recordType, issueDetails.recordType) &&
        Objects.equals(this.returned, issueDetails.returned) &&
        Objects.equals(this.returnedDate, issueDetails.returnedDate) &&
        Objects.equals(this.expirationDate, issueDetails.expirationDate) &&
        Objects.equals(this.books, issueDetails.books) &&
        Objects.equals(this.user, issueDetails.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, borrowDate, dueDate, recordType, returned, returnedDate, expirationDate, books, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueDetailsEntity {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    borrowDate: ").append(toIndentedString(borrowDate)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    recordType: ").append(toIndentedString(recordType)).append("\n");
    sb.append("    returned: ").append(toIndentedString(returned)).append("\n");
    sb.append("    returnedDate: ").append(toIndentedString(returnedDate)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("    books: ").append(toIndentedString(books)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

