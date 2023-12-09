package com.example.lab3.repository;

import com.example.lab3.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Отримати всіх покупців
    List<Customer> findAll();

    // Отримати покупця за ідентифікатором
    Optional<Customer> findById(Integer id);

    // Зберегти нового покупця
    <S extends Customer> S save(S customer);

    // Видалити покупця за ідентифікатором
    void deleteById(Integer id);
}
