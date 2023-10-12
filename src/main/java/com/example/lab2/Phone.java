package com.example.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Phone implements Product {

    @Value("${phone.category}")
    private String category;

    @Value("Iphone")
    private String name;

    @Value("${phone.price}")
    private double price;

//
//    @Autowired
//    public Phone(String category, String name, double price) {
//        this.category = category;
//        this.name = name;
//        this.price = price;
//    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
