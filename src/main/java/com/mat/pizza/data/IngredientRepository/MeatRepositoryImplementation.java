package com.mat.pizza.data.IngredientRepository;

import com.mat.pizza.Model.Ingredient.Meat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MeatRepositoryImplementation  {

    private MeatRepository meatRepository;

    @Autowired
    public MeatRepositoryImplementation(MeatRepository meatRepository) {
        this.meatRepository = meatRepository;
    }

    public void save (Meat meat){
        meatRepository.save(meat);
    }

    public Iterable<Meat> findAll(){
       return meatRepository.findAll();
    }
}
