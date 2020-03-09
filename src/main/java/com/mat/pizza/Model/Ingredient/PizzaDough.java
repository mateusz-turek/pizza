package com.mat.pizza.Model.Ingredient;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PizzaDough {

    private final Type dough;

    public enum Type{
        THICK, THIN, TRADITIONAL
    }


}
