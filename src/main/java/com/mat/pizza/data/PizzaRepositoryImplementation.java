package com.mat.pizza.data;

import com.mat.pizza.Model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaRepositoryImplementation {

    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaRepositoryImplementation(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void save(Pizza pizza) {
        pizzaRepository.save(pizza);
    }
}
