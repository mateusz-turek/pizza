package com.mat.pizza.Model.Ingredient;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cheese {

    private final Type cheeseType;

    public enum Type{
        GOUDA, CHEDDAR
    }
}
