package com.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.model.CreatedTour;
import com.repository.CreatedTourRepository;

@Service
public class CreatedTourServiceImpl implements CreatedTourService {

    @Autowired
    private CreatedTourRepository createdTourRepo;

    // create tour
    public List<CreatedTour> getAllCreatedTours() {
        return createdTourRepo.findAll();
    }

    
    public Optional<CreatedTour> getCreatedTourById(String id) {
        return createdTourRepo.findById(id);
    }


    
    public CreatedTour updateCreatedTour(String id, CreatedTour createdTour) {
        Optional<CreatedTour> existingCreatedTour = createdTourRepo.findById(id);
        if (existingCreatedTour.isPresent()) {
            createdTour.setId(id);
            return createdTourRepo.save(createdTour);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    
    public String deleteCreatedTour(String id) {
        if (createdTourRepo.existsById(id)) {
            createdTourRepo.deleteById(id);
            return createdTourRepo.existsById(id) ? "Tour deletion failed" : "Tour Deleted";
        } else {
            return "Tour Not Found";
        }
    }

    
    public List<CreatedTour> getCreatedToursByTourGuideId(String tourGuideId) {
        return createdTourRepo.findByTourGuideId(tourGuideId);
    }


    // add tour
    public CreatedTour addTour(CreatedTour createdTour) {
        return createdTourRepo.save(createdTour);
    }
    
}

