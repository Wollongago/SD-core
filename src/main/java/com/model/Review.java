package com.model;

public class Review {
    private String reviewerName;
    private String comment;
  
    public Review(String reviewerName, String comment) {
      this.reviewerName = reviewerName;
      this.comment = comment;
    }
  
    public String getReviewerName() {
      return reviewerName;
    }
  
    public void setReviewerName(String reviewerName) {
      this.reviewerName = reviewerName;
    }
  
    public String getComment() {
      return comment;
    }
  
    public void setComment(String comment) {
      this.comment = comment;
    }
  }
  