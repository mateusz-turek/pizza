package com.mat.pizza.Model.Ingredient;

import com.mat.pizza.Model.Ingredients;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Sauce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sauceType;
}
