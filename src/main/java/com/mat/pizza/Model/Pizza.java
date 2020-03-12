package com.mat.pizza.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private  Long id;

    @OneToOne()
    @JoinColumn(name = "INGREDIENTS_ID")
    private Ingredients ingredients;
}
