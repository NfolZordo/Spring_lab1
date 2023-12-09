package com.example.lab3.repository;

import com.example.lab3.model.Customer;
import com.example.lab3.model.Product;
import com.example.lab3.model.ProductsPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Customer, Integer> {
    Product findById(int id);

    @Query(value = "SELECT * FROM products_prise pp WHERE pp.product_id = :productId AND pp.shop_id = :shopId", nativeQuery = true)
    List<Object[]>  findPriceByProductAndCustomer(@Param("productId") Integer productId, @Param("shopId") Integer shopId);

}
