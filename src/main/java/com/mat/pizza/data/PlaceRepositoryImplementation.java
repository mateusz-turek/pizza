package com.mat.pizza.data;

import com.mat.pizza.Model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
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

    public List<Place> findPlacesByDateOfOrders(String city, org.springframework.data.domain.Pageable pageable){
        return (List<Place>) placeRepository.findAllByCityOrderByDateOfOrderDesc(city, pageable);
    }
}
