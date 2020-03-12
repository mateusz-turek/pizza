package com.mat.pizza.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mat.pizza.JsonMapper.ToJson;
import com.mat.pizza.Model.Ingredient.Cheese;
import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import com.mat.pizza.Model.Ingredient.Sauce;
import com.mat.pizza.Model.Ingredients;
import com.mat.pizza.Model.Pizza;
import com.mat.pizza.data.IngredientRepository.*;
import com.mat.pizza.data.IngredientsRepositoryImplementation;
import com.mat.pizza.data.PizzaRepositoryImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/pizza")
public class PizzaController {

    private ToJson toJson;
    private CheeseRepositoryImplementation cheeseRepositoryImplementation;
    private MeatRepositoryImplementation meatRepositoryImplementation;
    private SauceRepositoryImplementation sauceRepositoryImplementation;
    private PizzaDoughRepositoryImplementation pizzaDoughRepositoryImplementation;
    private IngredientsRepositoryImplementation ingredientsRepositoryImplementation;
    private PizzaRepositoryImplementation pizzaRepositoryImplementation;

    @Autowired
    public PizzaController(ToJson toJson,
                           CheeseRepositoryImplementation cheeseRepositoryImplementation,
                           MeatRepositoryImplementation meatRepositoryImplementation,
                           SauceRepositoryImplementation sauceRepositoryImplementation,
                           PizzaDoughRepositoryImplementation pizzaDoughRepositoryImplementation,
                           IngredientsRepositoryImplementation ingredientsRepositoryImplementation,
                           PizzaRepositoryImplementation pizzaRepositoryImplementation) {
        this.toJson = toJson;
        this.cheeseRepositoryImplementation = cheeseRepositoryImplementation;
        this.meatRepositoryImplementation = meatRepositoryImplementation;
        this.sauceRepositoryImplementation = sauceRepositoryImplementation;
        this.pizzaDoughRepositoryImplementation = pizzaDoughRepositoryImplementation;
        this.ingredientsRepositoryImplementation = ingredientsRepositoryImplementation;
        this.pizzaRepositoryImplementation = pizzaRepositoryImplementation;
    }

    @GetMapping
    public String menu(Model model) {

        model.addAttribute("pizzaDough", pizzaDoughRepositoryImplementation.findAll());
        model.addAttribute("sauces", sauceRepositoryImplementation.findAll());
        model.addAttribute("cheeses", cheeseRepositoryImplementation.findAll());
        model.addAttribute("meats", meatRepositoryImplementation.findAll());
        model.addAttribute("ingredients",ingredientsRepositoryImplementation.findAll());
        return "design";
    }

    @PostMapping()
    public String processDesign(String doughType, String sauceType, String cheeseType,
                                String meatType,
                                String compositionName) throws JsonProcessingException {

        Ingredients ingredients = new Ingredients();
        ingredients.setPizzaDough(
                toJson.objectMapper.readValue(toJson.parse(doughType), PizzaDough.class));
        ingredients.setSauce(
                toJson.objectMapper.readValue(toJson.parse(sauceType), Sauce.class));
        ingredients.setCheese(
                toJson.objectMapper.readValue(toJson.parse(cheeseType), Cheese.class));
        ingredients.setMeat(
                toJson.objectMapper.readValue(toJson.parse(meatType), Meat.class));
        ingredients.setCompositionName(compositionName);

        ingredientsRepositoryImplementation.save(ingredients);

         Pizza pizza = new Pizza();
         pizza.setIngredients(ingredients);

         pizzaRepositoryImplementation.save(pizza);

    /*
         Cheese cheese = cheeseRepositoryImplementation.findCheeseById(1L);
         Cheese cheese1 = cheeseRepositoryImplementation.findCheeseByType("Gouda");
         Cheese cheese2 = cheeseRepositoryImplementation.findCheeseByType("Cheddar");
         log.info(cheese.toString());
         log.info(cheese1.toString());
         log.info(cheese2.toString());
*/
        return "redirect:/order/place";
    }

}


