package com.mat.pizza.Model;

import com.mat.pizza.Model.Ingredient.Cheese;
import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import com.mat.pizza.Model.Ingredient.Sauce;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Ingredients {

    private PizzaDough pizzaDough;

    private Sauce sauce;

    private Cheese cheese;

    private Meat meat;

}
