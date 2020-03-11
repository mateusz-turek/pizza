package com.mat.pizza.data.IngredientRepository;

import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaDoughRepositoryImplementation {

    private PizzaDoughRepository pizzaDoughRepository;

    @Autowired
    public PizzaDoughRepositoryImplementation(PizzaDoughRepository pizzaDoughRepository) {
        this.pizzaDoughRepository = pizzaDoughRepository;
    }

    public void save (PizzaDough pizzaDough){
        pizzaDoughRepository.save(pizzaDough);
    }

    public Iterable<PizzaDough> findAll(){
        return pizzaDoughRepository.findAll();
    }
}
