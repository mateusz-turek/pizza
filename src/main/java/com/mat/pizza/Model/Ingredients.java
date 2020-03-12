package com.mat.pizza.Model;

import com.mat.pizza.Model.Ingredient.Cheese;
import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import com.mat.pizza.Model.Ingredient.Sauce;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "INGREDIENTS")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGREDIENTS_ID")
    private Long id;

    @Column(name = "USER_COMPOSITION")
    private String compositionName;

    @OneToOne()
    @JoinColumn(name = "PIZZA_DOUGH_ID")
    private PizzaDough pizzaDough;

    @OneToOne()
    @JoinColumn(name = "SAUCE_ID")
    private Sauce sauce;

    @OneToOne()
    @JoinColumn(name = "CHEESE_ID")
    private Cheese cheese;

    @OneToOne()
    @JoinColumn(name = "MEAT_ID")
    private Meat meat;

}
