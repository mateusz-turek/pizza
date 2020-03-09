package com.mat.pizza.Model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Pizza {

    private final Ingredients ingredients;
}
