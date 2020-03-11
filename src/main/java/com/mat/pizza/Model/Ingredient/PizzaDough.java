package com.mat.pizza.Model.Ingredient;

import com.mat.pizza.Model.Ingredients;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class PizzaDough {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Type dough;

    public enum Type{
        THICK, THIN, TRADITIONAL
    }


}
