package com.mat.pizza.Controller;

import com.mat.pizza.Model.Place;
import com.mat.pizza.data.PlaceRepositoryImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    private PlaceRepositoryImplementation placeRepositoryImplementation;

    @Autowired
    public OrderController(PlaceRepositoryImplementation placeRepositoryImplementation) {
        this.placeRepositoryImplementation = placeRepositoryImplementation;
    }

    @GetMapping("/place")
    public String main(Model model) {
        model.addAttribute("place",new Place());
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid Place place, Errors errors){
        if (errors.hasErrors()){
            return "orderForm";
        }
        placeRepositoryImplementation.save(place);
        log.info(String.valueOf(place));
        return "redirect:/";
    }
}
