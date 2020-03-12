package com.mat.pizza.data;

import com.mat.pizza.Model.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository  extends CrudRepository<Pizza,Long> {


}
