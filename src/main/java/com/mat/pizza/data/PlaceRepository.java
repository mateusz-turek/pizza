package com.mat.pizza.data;

import com.mat.pizza.Model.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaceRepository extends CrudRepository<Place,Long> {

    List<Place> findPlacesByCity (String city);
}
