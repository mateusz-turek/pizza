package com.mat.pizza.Model.Ingredient;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Meat {

    private final Type meatType;

    public enum Type{
        SALAMI, CHICKEN, PORK
    }
}
