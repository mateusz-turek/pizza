package com.mat.pizza.Model;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.GeneratedValue;

@Data
public class RegisterForm {

    private String name;
    private String surname;
    private String eMail;
    private String password;

    public User toUser (PasswordEncoder encoder){
        return new User(null,name,surname,eMail,encoder.encode(password));
    }
}
