package com.bapie.shopping.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bapie.shopping.shoppingcart.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
