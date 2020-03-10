package com.mat.pizza.Model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Place {

    @NotBlank(message = "sample note")
    private String name;
    @NotBlank(message = "sample note")
    private String street;
    @NotBlank(message = "sample note")
    private String city;
    @NotBlank(message = "sample note")
    private String state;
    @NotBlank(message = "sample note")
    private String zipCode;
    @CreditCardNumber(message = "sample note")
    private String ccNumber;
    @Pattern(regexp = "^([0-9][0-9])([/])([2-9][0-9])$", message = "sample message")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "sample message")
    private String ccCVV;
}
