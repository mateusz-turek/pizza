package com.mat.pizza.Model;

import java.util.Objects;

public class Pizza {

    private final Long id;
    private final String name;
    private final PizzaDough pizzaDough;

    public static enum  PizzaDough{
        THIN, FAT, TRADITIONAL
    }

    public Pizza(Long id, String name, PizzaDough pizzaDough) {
        this.id = id;
        this.name = name;
        this.pizzaDough = pizzaDough;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PizzaDough getPizzaDough() {
        return pizzaDough;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pizzaDough=" + pizzaDough +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id) &&
                Objects.equals(name, pizza.name) &&
                pizzaDough == pizza.pizzaDough;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pizzaDough);
    }
}
