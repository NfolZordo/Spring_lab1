package com.example.lab3.repository;

import com.example.lab3.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Override
    Optional<Shop> findById(Integer integer);

    @Override
    List<Shop> findAll();

    @Modifying
    @Query(value = "INSERT INTO shop (name, address) VALUES (:name, :address)", nativeQuery = true)
    void save(@Param("name") String name, @Param("address") String address);

    @Override
    <S extends Shop> S save(S shop);
}