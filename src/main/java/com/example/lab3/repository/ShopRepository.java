package com.example.lab3.repository;

import com.example.lab3.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
    @Override
    Optional<Shop> findById(Integer integer);

    @Override
    Iterable<Shop> findAll();


}