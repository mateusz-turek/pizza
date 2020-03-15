package com.mat.pizza.Controller;

import com.mat.pizza.Configuration.OrderSize;
import com.mat.pizza.data.PlaceRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Pageable;

@Controller
@RequestMapping("/panel")
public class AdminController {

    private PlaceRepositoryImplementation placeRepositoryImplementation;

    private OrderSize orderSize;

    @Autowired
    public AdminController(PlaceRepositoryImplementation placeRepositoryImplementation, OrderSize orderSize) {
        this.placeRepositoryImplementation = placeRepositoryImplementation;
        this.orderSize = orderSize;
    }

    @GetMapping()
    public String helloAdmin(Model model){

        org.springframework.data.domain.Pageable pageable1 = PageRequest.of(0,orderSize.getSize());

        model.addAttribute("orders",
                placeRepositoryImplementation.findPlacesByDateOfOrders("Warsaw",pageable1));

        return "panel";
    }
}
