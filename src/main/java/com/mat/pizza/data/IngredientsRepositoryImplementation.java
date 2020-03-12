package com.mat.pizza.data;

import com.mat.pizza.Model.Ingredients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientsRepositoryImplementation {

    private IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientsRepositoryImplementation(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public void save(Ingredients ingredients){
        ingredientsRepository.save(ingredients);
    }

    public Iterable<Ingredients> findAll(){
        return ingredientsRepository.findAll();
    }
}
