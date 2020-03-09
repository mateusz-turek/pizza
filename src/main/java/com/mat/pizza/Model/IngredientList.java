package com.mat.pizza.Model;

import com.mat.pizza.Model.Ingredient.Cheese;
import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import com.mat.pizza.Model.Ingredient.Sauce;

import java.util.ArrayList;
import java.util.List;

public class IngredientList {
    private List<Ingredients> ingredients;

    public IngredientList(List<Ingredients> ingredients) {
        this.ingredients = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "IngredientList{" +
                "ingredients=" + ingredients +
                '}';
    }

    public static void main(String[] args) {
        IngredientList  ingredientList = new IngredientList(new ArrayList<>());
        ingredientList.ingredients.add(new Ingredients(new PizzaDough(PizzaDough.Type.THICK)
                        ,new Sauce(Sauce.Type.Mild), new Cheese(Cheese.Type.CHEDDAR)
                        ,new Meat(Meat.Type.CHICKEN)));
        System.out.println(ingredientList.ingredients);
    }
}
