package com.example.lab3.repositoriy;

import com.example.lab3.model.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
    @Override
    Iterable<Shop> findAll();
}