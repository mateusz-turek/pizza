package com.mat.pizza.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class AdminController {


    @GetMapping()
    public String helloAdmin(){
        return "panel";
    }
}
