package com.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.CreatedTour;
import com.service.CreatedTourService;

@CrossOrigin
@RestController
@RequestMapping("/tour")
public class TourController {
    
    private CreatedTourService createdTourService;

    @Autowired
    public TourController(CreatedTourService createdTourService) {
        this.createdTourService = createdTourService;
    }

    @GetMapping("/all")
    public Iterable<CreatedTour> getAllCreatedTours() {
        return createdTourService.getAllCreatedTours();
    }

    // create tour
    @PostMapping("/create")
    public CreatedTour createTour(@RequestBody Map<String, Object> tourData) {
        String name = (String) tourData.get("name");
        String description = (String) tourData.get("description");
        String location = (String) tourData.get("location");
        double price = (double) tourData.get("price");
        List<Date> availableDates = (List<Date>) tourData.get("availableDates");
        int maximumCapacity = (int) tourData.get("maximumCapacity");
        String guideId = (String) tourData.get("guideId");

        return createdTourService.createTour(name, description, location, price, availableDates, maximumCapacity, guideId);
    }


}
