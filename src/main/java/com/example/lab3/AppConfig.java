package com.example.lab3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.lab3")
@PropertySource("classpath:myApp.properties")
@EnableAspectJAutoProxy
public class AppConfig {

}
