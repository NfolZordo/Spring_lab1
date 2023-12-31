package com.example.lab1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AppLab1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer = context.getBean("customer", Customer.class);

        System.out.println("Customer: " + customer.getName());
        System.out.println("Shopping at: " + customer.getShop());

        List<Product> products = customer.getShop().getProducts();
        System.out.println("Products:");
        for (Product product : products) {
            if (product instanceof Computer) {
                Computer computer = (Computer) product;
                System.out.println("  Computer: " + computer.getName() + " Brand - " + computer.getBrand());
            } else if (product instanceof Phone) {
                Phone phone = (Phone) product;
                System.out.println("  Phone: " + phone.getName() + " - " + phone.getCategory());
            }
        }
    }
}