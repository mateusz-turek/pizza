package com.mat.pizza.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mat.pizza.JsonMapper.ToJson;
import com.mat.pizza.Model.Ingredient.Cheese;
import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import com.mat.pizza.Model.Ingredient.Sauce;
import com.mat.pizza.Model.Ingredients;
import com.mat.pizza.Model.Pizza;
import com.mat.pizza.data.IngredientRepository.*;
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

    @Autowired
    public PizzaController(ToJson toJson, CheeseRepositoryImplementation cheeseRepositoryImplementation,
                           MeatRepositoryImplementation meatRepositoryImplementation,
                           SauceRepositoryImplementation sauceRepositoryImplementation,
                           PizzaDoughRepositoryImplementation pizzaDoughRepositoryImplementation) {
        this.toJson = toJson;
        this.cheeseRepositoryImplementation = cheeseRepositoryImplementation;
        this.meatRepositoryImplementation = meatRepositoryImplementation;
        this.sauceRepositoryImplementation = sauceRepositoryImplementation;
        this.pizzaDoughRepositoryImplementation = pizzaDoughRepositoryImplementation;
    }

    @GetMapping
    public String menu(Model model) {

        model.addAttribute("pizzaDough", pizzaDoughRepositoryImplementation.findAll());
        model.addAttribute("sauces", sauceRepositoryImplementation.findAll());
        model.addAttribute("cheeses", cheeseRepositoryImplementation.findAll());
        model.addAttribute("meats", meatRepositoryImplementation.findAll());
        return "design";
    }

    @PostMapping()
    public String processDesign(String doughType, String sauceType, String cheeseType,
                                String meatType) throws JsonProcessingException {

         Ingredients ingredients = new Ingredients(toJson.objectMapper
                 .readValue(toJson.parse(doughType),PizzaDough.class),
                 toJson.objectMapper.readValue(toJson.parse(sauceType), Sauce.class),
                 toJson.objectMapper.readValue(toJson.parse(cheeseType), Cheese.class),
                 toJson.objectMapper.readValue(toJson.parse(meatType), Meat.class));

         Pizza pizza = new Pizza();
         pizza.setIngredients(ingredients);

         log.info(pizza.toString());

        return "redirect:/order/place";
    }

}


