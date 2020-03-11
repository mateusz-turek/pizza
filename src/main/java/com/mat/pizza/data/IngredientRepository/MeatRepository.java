package com.mat.pizza.data.IngredientRepository;

import com.mat.pizza.Model.Ingredient.Meat;
import org.springframework.data.repository.CrudRepository;

public interface MeatRepository extends CrudRepository<Meat,Long> {
}
