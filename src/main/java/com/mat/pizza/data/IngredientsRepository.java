package com.mat.pizza.data;

import com.mat.pizza.Model.Ingredients;
import org.springframework.data.repository.CrudRepository;

public interface IngredientsRepository extends CrudRepository<Ingredients,Long> {
}
