package com.example.lab3.repository;

import com.example.lab3.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Override
    Optional<Shop> findById(Integer integer);

    @Override
    List<Shop> findAll();


}