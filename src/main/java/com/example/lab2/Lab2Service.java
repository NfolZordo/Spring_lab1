package com.example.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Lab2Service {
    private Customer customer;
    @Autowired
    Lab2Service(Customer customer) {
        this.customer = customer;
    }
    Lab2Service(){}
    public void write() {
        System.out.println("SSSSSS");
    }

}
