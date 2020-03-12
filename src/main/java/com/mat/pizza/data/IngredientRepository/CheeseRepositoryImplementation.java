package com.mat.pizza.data.IngredientRepository;

import com.mat.pizza.Model.Ingredient.Cheese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CheeseRepositoryImplementation {

    private CheeseRepository cheeseRepository;

    @Autowired
    public CheeseRepositoryImplementation(CheeseRepository cheeseRepository) {
        this.cheeseRepository = cheeseRepository;
    }

    public void save (Cheese cheese){
        cheeseRepository.save(cheese);
    }

    public Iterable<Cheese> findAll(){
        return cheeseRepository.findAll();
    }

    public Cheese findCheeseById(Long id){
        return cheeseRepository.findCheeseById(id);
    }
    public Cheese findCheeseByType (String type){
        return cheeseRepository.findCheeseByCheeseType(type);
    }

}
