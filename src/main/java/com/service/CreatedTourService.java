package com.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.model.CreatedTour;

public interface CreatedTourService {
    
    public List<CreatedTour> getAllCreatedTours();
    
    public Optional<CreatedTour> getCreatedTourById(String id);

    
    public CreatedTour updateCreatedTour(String id, CreatedTour createdTour);
    
    public String deleteCreatedTour(String id);
    
    public List<CreatedTour> getCreatedToursByTourGuideId(String tourGuideId);

    public CreatedTour addTour(CreatedTour createdTour);

}
