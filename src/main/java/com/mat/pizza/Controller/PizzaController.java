package com.mat.pizza.Controller;

import com.mat.pizza.Model.Ingredient.Cheese;
import com.mat.pizza.Model.Ingredient.Meat;
import com.mat.pizza.Model.Ingredient.PizzaDough;
import com.mat.pizza.Model.Ingredient.Sauce;
import com.mat.pizza.Model.Ingredients;
import com.mat.pizza.Model.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/pizza")
public class PizzaController {

    @GetMapping
    public String menu(Model model) {

        PizzaDough.Type [] doughs = PizzaDough.Type.values();
        Sauce.Type [] sauces = Sauce.Type.values();
        Cheese.Type[] cheeses = Cheese.Type.values();
        Meat.Type[] meats = Meat.Type.values();

        model.addAttribute("pizzaDough", doughs);
        model.addAttribute("sauces", sauces);
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("meats", meats);

        return "design";
    }

    @PostMapping()
    public String processDesign(PizzaDough pizzaDough, Sauce sauce, Cheese cheese, Meat meat) {
         Pizza pizza = new Pizza (new Ingredients(pizzaDough,sauce,cheese,meat));
        log.info(String.valueOf(pizza));
        return "redirect:/order/place";
    }


}
