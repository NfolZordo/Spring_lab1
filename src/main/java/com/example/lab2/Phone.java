package com.example.lab2;

import lombok.Getter;
import lombok.Setter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("phone")
@Getter
@Setter
public class Phone implements Product {

    @Value("${phone.category}")
    private String category;

    @Value("Iphone")
    private String name;

    @Value("${phone.price}")
    private String priceStr;
    private double price;
    public double getPrice() {
        return Double.parseDouble(priceStr);
    }

    @PostConstruct
    public void init() {
        System.out.println("--- Phone bean is being initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("--- Phone bean is being destroyed.");
    }
}
