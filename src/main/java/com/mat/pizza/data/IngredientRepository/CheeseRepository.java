package com.mat.pizza.data.IngredientRepository;

import com.mat.pizza.Model.Ingredient.Cheese;
import org.springframework.data.repository.CrudRepository;


public interface CheeseRepository extends CrudRepository<Cheese,Long> {
}
