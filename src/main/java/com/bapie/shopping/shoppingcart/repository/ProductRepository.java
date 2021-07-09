package com.bapie.shopping.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bapie.shopping.shoppingcart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
