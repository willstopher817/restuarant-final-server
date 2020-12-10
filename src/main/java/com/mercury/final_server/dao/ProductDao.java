package com.mercury.final_server.dao;

import com.mercury.final_server.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    // WHERE PRICE >= 400
    // JPA Query Lookup: you must follow naming convention
    // JPA will read your method name and understand it
    // if you follow the correct naming convention
    // JPA will generate corresponding DAO method for you!!!
    List<Product> findByPriceGreaterThanEqual(int minPrice);

    // if you don't want to follow naming convention for instructing
    // JPA to generate DAO method
    // or a very complicated condition: name contains iphone and price > 400 and stock is even number
    // you can use custom query

    // get the max price for all products
    // JPA can't understand below method name
    // custom query
    // HQL: Hibernate Query Language
    // JPQL: JPA Query Language
    // SQL: SELECT max(price) FROM PRODUCT
    @Query("select max(p.price) from Product p")
    int getMaxPrice();

    // get products with stock under 200
    @Query("select p from Product p where p.stock < :stock")
    List<Product> getProductWithLowStock(@Param("stock") int stock);

}
