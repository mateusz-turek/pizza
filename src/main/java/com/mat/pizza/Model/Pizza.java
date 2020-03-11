package com.mat.pizza.Model;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class Pizza {

    private  Long id;

    private Ingredients ingredients;
}
