package com.mat.pizza.Model.Ingredient;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Sauce {

    private final Type sauce;

    public enum Type{
        Spicy, Mild
    }
}
