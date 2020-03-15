package com.mat.pizza.data;

import com.mat.pizza.Model.Place;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface PlaceRepository extends CrudRepository<Place,Long> {

    List<Place> findPlacesByCity (String city);

    List<Place> findAllByCityOrderByDateOfOrderDesc(String city,org.springframework.data.domain.Pageable pageable);
   // List<Place> getAll(org.springframework.data.domain.Pageable pageable);
}
