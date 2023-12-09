package com.example.lab3.repository;

import com.example.lab3.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    // Отримати всіх покупців
    Iterable<Customer> findAll();

    // Отримати покупця за ідентифікатором
    Optional<Customer> findById(Integer id);

    // Зберегти нового покупця
    <S extends Customer> S save(S customer);

    // Видалити покупця за ідентифікатором
    void deleteById(Integer id);
}
