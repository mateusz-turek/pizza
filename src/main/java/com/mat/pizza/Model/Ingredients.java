package com.mat.pizza.Model;

import com.mat.pizza.Model.Ingredient.Cheese;
import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import com.mat.pizza.Model.Ingredient.Sauce;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Ingredients {


    final private PizzaDough pizzaDough;
    final private Sauce sauce;
    final private Cheese cheese;
    final private Meat meat;

}
