package com.mat.pizza.data.IngredientRepository;

import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.Sauce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SauceRepositoryImplementation {

    private SauceRepository sauceRepository;

    @Autowired
    public SauceRepositoryImplementation(SauceRepository sauceRepository) {
        this.sauceRepository = sauceRepository;
    }

    public void save (Sauce sauce){
        sauceRepository.save(sauce);
    }

    public Iterable<Sauce> findAll(){
        return sauceRepository.findAll();
    }
}
