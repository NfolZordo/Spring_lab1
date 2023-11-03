package com.example.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class Customer {
    private String name;
    private Shop shop;

    @Autowired
    public Customer(Shop shop) {
        this.shop = shop;
    }
    public Customer (){}

    public Customer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    @Value("${customer.name}")
    public void setName(String name) {
        this.name = name;
    }
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
    @PostConstruct
    public void init() {
        System.out.println("--- Customer bean is being initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("--- Customer bean is being destroyed.");
    }
}
