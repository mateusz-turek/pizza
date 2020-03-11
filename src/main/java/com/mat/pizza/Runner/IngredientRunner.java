package com.mat.pizza.Runner;

import com.mat.pizza.Model.Ingredient.Cheese;
import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import com.mat.pizza.Model.Ingredient.Sauce;
import com.mat.pizza.data.IngredientRepository.CheeseRepositoryImplementation;
import com.mat.pizza.data.IngredientRepository.MeatRepositoryImplementation;
import com.mat.pizza.data.IngredientRepository.PizzaDoughRepositoryImplementation;
import com.mat.pizza.data.IngredientRepository.SauceRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class IngredientRunner implements ApplicationRunner {

    private MeatRepositoryImplementation meatRepositoryImplementation;
    private CheeseRepositoryImplementation cheeseRepositoryImplementation;
    private SauceRepositoryImplementation sauceRepositoryImplementation;
    private PizzaDoughRepositoryImplementation pizzaDoughRepositoryImplementation;

    @Autowired
    public IngredientRunner(MeatRepositoryImplementation meatRepositoryImplementation,
                            CheeseRepositoryImplementation cheeseRepositoryImplementation,
                            SauceRepositoryImplementation sauceRepositoryImplementation,
                            PizzaDoughRepositoryImplementation pizzaDoughRepositoryImplementation) {
        this.meatRepositoryImplementation = meatRepositoryImplementation;
        this.cheeseRepositoryImplementation = cheeseRepositoryImplementation;
        this.sauceRepositoryImplementation = sauceRepositoryImplementation;
        this.pizzaDoughRepositoryImplementation = pizzaDoughRepositoryImplementation;
    }

    @Override
    public void run(ApplicationArguments args) {
        Meat pork = new Meat();
        pork.setMeatType("Pork");
        meatRepositoryImplementation.save(pork);
        Meat chicken = new Meat();
        chicken.setMeatType("Chicken");
        meatRepositoryImplementation.save(chicken);
        Meat salami = new Meat();
        salami.setMeatType("Salami");
        meatRepositoryImplementation.save(salami);

        Cheese cheddar = new Cheese();
        cheddar.setCheeseType("Cheddar");
        cheeseRepositoryImplementation.save(cheddar);
        Cheese gouda = new Cheese();
        gouda.setCheeseType("Gouda");
        cheeseRepositoryImplementation.save(gouda);

        Sauce spicy = new Sauce();
        spicy.setSauceType("Spicy");
        sauceRepositoryImplementation.save(spicy);
        Sauce mild = new Sauce();
        mild.setSauceType("Mild");
        sauceRepositoryImplementation.save(mild);

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
}
