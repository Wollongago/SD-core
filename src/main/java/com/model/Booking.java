package com.model;

import java.util.Date;

public class Booking {
    private String id;
    private String tourId;
    private String userId;
    private Date date;
  
    public Booking() {}
  
    public Booking(String id, String tourId, String userId, Date date) {
      this.id = id;
      this.tourId = tourId;
      this.userId = userId;
      this.date = date;
    }
  
    public String getId() {
      return id;
    }
  
    public void setId(String id) {
      this.id = id;
    }
  
    public String getTourId() {
      return tourId;
    }
  
    public void setTourId(String tourId) {
      this.tourId = tourId;
    }
  
    public String getUserId() {
      return userId;
    }
  
    public void setUserId(String userId) {
      this.userId = userId;
    }
  
    public Date getDate() {
      return date;
    }
  
    public void setDate(Date date) {
      this.date = date;
    }
  }
  
