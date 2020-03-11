package com.mat.pizza.data.IngredientRepository;

import com.mat.pizza.Model.Ingredient.PizzaDough;
import org.springframework.data.repository.CrudRepository;

public interface PizzaDoughRepository extends CrudRepository<PizzaDough,Long> {
}
