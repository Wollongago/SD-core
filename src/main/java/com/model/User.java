package com.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "users")
public class User {

  @Id
  private String id;

  public String name;
  public String email;
  
  @JsonIgnore
  private String password;
  
  private boolean isTourProvider;

  // For tourists
  private List<TourBooking> bookings;

  // For tour guides
  private List<CreatedTour> createdTours;

  public User() {
  }

  public User(String name, String email, String password, boolean isTourProvider) {
    super();
    this.name = name;
    this.email = email;
    this.password = password;
    this.isTourProvider = isTourProvider;
    if (isTourProvider) {
      this.createdTours = new ArrayList<CreatedTour>();
    } else {
      this.bookings = new ArrayList<TourBooking>();
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isTourProvider() {
    return isTourProvider;
  }

  public void setTourGuide(boolean isTourProvider) {
    this.isTourProvider = isTourProvider;
    if (isTourProvider) {
      this.createdTours = new ArrayList<CreatedTour>();
    } else {
      this.bookings = new ArrayList<TourBooking>();
    }
  }

  public List<TourBooking> getBookings() {
    return bookings;
  }

  public void setBookings(List<TourBooking> bookings) {
    this.bookings = bookings;
  }

  public List<CreatedTour> getCreatedTours() {
    return createdTours;
  }

  public void setCreatedTours(List<CreatedTour> createdTours) {
    this.createdTours = createdTours;
  }
}
