package com.example.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "com.example.lab2")
public class AppLab2 {

    public static void main(String[] args) {
//            Product phone = new Phone();
//        Product cat1 = context.getBean("catBean", Product.class);
//            System.out.println(phone.getName());
        Phone phone = new Phone();
        String phoneName = phone.getName();
        System.out.println(phoneName);
    }
    }
