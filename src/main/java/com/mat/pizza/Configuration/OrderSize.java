package com.mat.pizza.Configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("page")
@Data
public class OrderSize {

    private int size;


}
