package com.example.lab3;

import com.example.lab3.model.Shop;
import com.example.lab3.repositoriy.ShopRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan(basePackages = "com.example.lab3")
public class AppLab3 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Create the Spring application context

        // Get the ShopRepository bean from the context
        ShopRepository shopRepository = context.getBean(ShopRepository.class);

        // Call the findAll() method on the ShopRepository instance
        Iterable<Shop> shops = shopRepository.findAll();

        // Print or process the result as needed
        for (Shop shop : shops) {
            System.out.println(shop);
        }

        // Close the application context
        context.close();
    }
}
