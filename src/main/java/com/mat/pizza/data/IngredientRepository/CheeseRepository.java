package com.mat.pizza.data.IngredientRepository;

import com.mat.pizza.Model.Ingredient.Cheese;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CheeseRepository extends CrudRepository<Cheese,Long> {

    Cheese findCheeseById (Long id);
    Cheese findCheeseByCheeseType(String type);
}
