package com.example.lab3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example.lab3")
@PropertySource("classpath:myApp.properties")
@EnableAspectJAutoProxy
public class AppConfig {

}
