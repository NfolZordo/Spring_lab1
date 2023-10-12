package com.example.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Customer {
    @Value("hren")
    private String name;
    private Shop shop;

    @Autowired
    public Customer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }
    public Customer (){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
