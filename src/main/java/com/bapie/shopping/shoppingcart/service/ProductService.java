package com.bapie.shopping.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bapie.shopping.shoppingcart.dao.ProductDAO;
import com.bapie.shopping.shoppingcart.entity.Product;
import com.bapie.shopping.shoppingcart.entity.ResponseEntity;
import com.bapie.shopping.shoppingcart.entity.Review;

@Service
public class ProductService {
	
	@Autowired
	ProductDAO productDAO;
	
	public Product saveProduct(Product product) {
		return productDAO.saveProduct(product);
	}
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}
	
	public ResponseEntity<Review> saveReview(int productId,int userId,Review review) {
		return productDAO.saveReview(productId, userId, review);
	}
}
