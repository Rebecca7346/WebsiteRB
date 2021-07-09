package com.bapie.shopping.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bapie.shopping.shoppingcart.entity.Product;
import com.bapie.shopping.shoppingcart.entity.ResponseEntity;
import com.bapie.shopping.shoppingcart.entity.Review;
import com.bapie.shopping.shoppingcart.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("save")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	
	@PostMapping("save/{productId}/review/{userId}")
	public ResponseEntity<Review> saveReview(@RequestBody Review review, @PathVariable("productId") int productId,
			@PathVariable("userId") int userId) {
		return productService.saveReview(productId, userId, review);
	}
	
	@GetMapping("getall")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("get")
	public Product get() {
		return new Product();
	}
	
}
