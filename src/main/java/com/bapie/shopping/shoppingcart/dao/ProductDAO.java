package com.bapie.shopping.shoppingcart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.bapie.shopping.shoppingcart.entity.Product;
import com.bapie.shopping.shoppingcart.entity.ResponseEntity;
import com.bapie.shopping.shoppingcart.entity.Review;
import com.bapie.shopping.shoppingcart.entity.User;
import com.bapie.shopping.shoppingcart.repository.ProductRepository;
import com.bapie.shopping.shoppingcart.repository.ReviewRepository;
import com.bapie.shopping.shoppingcart.repository.UserRepository;

@Repository
public class ProductDAO {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public ResponseEntity<Review> saveReview(int productId,int userId,Review review) {
		 ResponseEntity<Review> response = new  ResponseEntity<Review>();
		Optional<User> userOptional = userRepository.findById(userId);
		if(userOptional != null) {
			User userResult = userOptional.get();
			review.setUserName(userResult.getName());
		} else {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Invalid user ID");
			return response;
		}
		
		Optional<Product> productOptional = productRepository.findById(productId);
		if(productOptional!=null) {
			Product productResult = productOptional.get();
			review.setProduct(productResult);
			reviewRepository.save(review);
			
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(review);
			return response;
		} else {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Invalid product ID");
			return response;
		}
		
		
		
	}
}
