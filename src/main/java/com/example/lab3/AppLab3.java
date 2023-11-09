package com.example.lab3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan(basePackages = "com.example.lab3")
public class AppLab3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Customer customer = context.getBean(Customer.class);

        List<Product> products = customer.getShop().getProducts();
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Shop Name: " + customer.getShop().getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Price: " + product.getPrice());
            if (product instanceof Phone) {
                Phone phone = (Phone) product;
                System.out.println("Category: " + phone.getCategory());
            }
            if (product instanceof Computer) {
                Computer computer = (Computer) product;
                System.out.println("Brand: " + computer.getBrand());
            }
            System.out.println("------------------");
        }
    }
}
