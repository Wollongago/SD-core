package com.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class CreatedTour {
    @Id
    private String id;

    private String name;
    private String description;
    private String location;
    private double price;
    private List<Date> availableDates;
    private int maximumCapacity;
    private String guideId;

    public CreatedTour() {}

    public CreatedTour(String name, String description, String location, double price, List<Date> availableDates, int maximumCapacity, String guideId) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.availableDates = availableDates;
        this.maximumCapacity = maximumCapacity;
        this.guideId = guideId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Date> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<Date> availableDates) {
        this.availableDates = availableDates;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }
}
