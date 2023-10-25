package com.example.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface Product {
    String getName();
    double getPrice();
}
