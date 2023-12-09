package com.example.lab3.repository;

import com.example.lab3.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    void deleteById(Integer id);

    @Query("select c from Customer c where c.phone = ?1")
    Customer findByPhone(int phone);
}
