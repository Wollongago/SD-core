package com.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.model.CreatedTour;

@RepositoryRestResource(path="createdtours")
public interface CreatedTourRepository extends MongoRepository<CreatedTour, String> {
    //findByTourGuideId
    @Query(value = "{'tourGuideId':?0}", fields = "{'password':0}")
    List<CreatedTour> findByTourGuideId(String tourGuideId);
}