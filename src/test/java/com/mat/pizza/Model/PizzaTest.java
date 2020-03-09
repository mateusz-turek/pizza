package com.mat.pizza.Model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PizzaTest {

    @Test
     void pizzaObjectTest() {
        Pizza pizza1 = new Pizza(1L,"Sample Name", Pizza.PizzaDough.FAT);
        Pizza pizza2 = new Pizza(2L,"Sample Name", Pizza.PizzaDough.THIN);
        Pizza pizza3 = new Pizza(3L,"Sample Name", Pizza.PizzaDough.TRADITIONAL);

        Assert.assertEquals(new Pizza(1L,"Sample Name", Pizza.PizzaDough.FAT),pizza1);
        Assert.assertEquals(new Pizza(2L,"Sample Name", Pizza.PizzaDough.THIN),pizza2);
        Assert.assertEquals(new Pizza(3L,"Sample Name", Pizza.PizzaDough.TRADITIONAL),pizza3);

    }

}