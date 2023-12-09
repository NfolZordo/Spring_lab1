package com.example.lab3.repository;

import com.example.lab3.model.Customer;
import com.example.lab3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Customer, Integer> {
    Product findById(int id);
}