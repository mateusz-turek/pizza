package com.mat.pizza.Configuration;

import com.mat.pizza.Model.Ingredient.Cheese;
import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import com.mat.pizza.Model.Ingredient.Sauce;
import com.mat.pizza.data.IngredientRepository.CheeseRepositoryImplementation;
import com.mat.pizza.data.IngredientRepository.MeatRepositoryImplementation;
import com.mat.pizza.data.IngredientRepository.PizzaDoughRepositoryImplementation;
import com.mat.pizza.data.IngredientRepository.SauceRepositoryImplementation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@org.springframework.context.annotation.Profile("dev")
@Configuration
public class Profile {

    @Bean
    public CommandLineRunner checkOrCreateIngredients(MeatRepositoryImplementation meatRepositoryImplementation,
                                                      CheeseRepositoryImplementation cheeseRepositoryImplementation,
                                                      SauceRepositoryImplementation sauceRepositoryImplementation,
                                                      PizzaDoughRepositoryImplementation pizzaDoughRepositoryImplementation){
        return args -> {
            System.out.println("========================checking ingredient tables====================");
            if(meatRepositoryImplementation.count()==0) {
                Meat pork = new Meat();
                pork.setMeatType("Pork");
                meatRepositoryImplementation.save(pork);
                Meat chicken = new Meat();
                chicken.setMeatType("Chicken");
                meatRepositoryImplementation.save(chicken);
                Meat salami = new Meat();
                salami.setMeatType("Salami");
                meatRepositoryImplementation.save(salami);
            }
            if (cheeseRepositoryImplementation.count()==0) {
                Cheese cheddar = new Cheese();
                cheddar.setCheeseType("Cheddar");
                cheeseRepositoryImplementation.save(cheddar);
                Cheese gouda = new Cheese();
                gouda.setCheeseType("Gouda");
                cheeseRepositoryImplementation.save(gouda);
            }
            if (sauceRepositoryImplementation.count()==0) {
                Sauce spicy = new Sauce();
                spicy.setSauceType("Spicy");
                sauceRepositoryImplementation.save(spicy);
                Sauce mild = new Sauce();
                mild.setSauceType("Mild");
                sauceRepositoryImplementation.save(mild);
            }
            if (pizzaDoughRepositoryImplementation.count()==0) {
                PizzaDough pizzaDough1 = new PizzaDough();
                pizzaDough1.setDough(PizzaDough.Type.THICK);
                pizzaDoughRepositoryImplementation.save(pizzaDough1);
                PizzaDough pizzaDough2 = new PizzaDough();
                pizzaDough2.setDough(PizzaDough.Type.TRADITIONAL);
                pizzaDoughRepositoryImplementation.save(pizzaDough2);
                PizzaDough pizzaDough3 = new PizzaDough();
                pizzaDough3.setDough(PizzaDough.Type.THIN);
                pizzaDoughRepositoryImplementation.save(pizzaDough3);
            }
        };
    }
}
