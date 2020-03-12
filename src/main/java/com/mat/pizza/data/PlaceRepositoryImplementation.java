package com.mat.pizza.data;

import com.mat.pizza.Model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceRepositoryImplementation {

    private PlaceRepository placeRepository;

    @Autowired
    public PlaceRepositoryImplementation(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public void save(Place place) {
        placeRepository.save(place);
    }

    public List<Place> findByCity(String city ){
       return placeRepository.findPlacesByCity(city);
    }
}
