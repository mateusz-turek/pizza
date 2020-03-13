package com.mat.pizza.Controller;


import com.mat.pizza.Model.RegisterForm;
import com.mat.pizza.data.UserRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepositoryImplementation userRepositoryImplementation;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepositoryImplementation userRepositoryImplementation, PasswordEncoder passwordEncoder) {
        this.userRepositoryImplementation = userRepositoryImplementation;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(){
        return "registerForm";
    }

    @PostMapping
    public String processRegistration(RegisterForm form){
        userRepositoryImplementation.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
