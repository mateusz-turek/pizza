package com.mat.pizza.Controller;

import com.mat.pizza.Model.Place;
import com.mat.pizza.Model.User;
import com.mat.pizza.data.PlaceRepositoryImplementation;
import com.mat.pizza.data.UserRepositoryImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    private PlaceRepositoryImplementation placeRepositoryImplementation;
    private UserRepositoryImplementation userRepositoryImplementation;

    @Autowired
    public OrderController(PlaceRepositoryImplementation placeRepositoryImplementation,
                           UserRepositoryImplementation userRepositoryImplementation) {
        this.placeRepositoryImplementation = placeRepositoryImplementation;
        this.userRepositoryImplementation = userRepositoryImplementation;
    }

    @GetMapping("/place")
    public String main(Model model) {
        model.addAttribute("place",new Place());
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid Place place, Errors errors,
                               Principal principal){
        if (errors.hasErrors()){
            return "orderForm";
        }
        User user = userRepositoryImplementation.findUserByName(principal.getName());
        place.setUser(user);
        placeRepositoryImplementation.save(place);
        log.info(String.valueOf(place));

      //  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //  User user1 = (User) authentication.getPrincipal();

        return "redirect:/";
    }
}
