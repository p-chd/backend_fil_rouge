package com.example.backend_fil_rouge.services;

import java.util.List;

import com.example.backend_fil_rouge.models.Product;

public interface ProductService {

	List<Product> getProducts();
	
	Product getProductById(Long id);
	
	Product addProduct(Product product, Long category_id);
	
	Product updateProduct(Product product, Long id);
	
	void deleteProducts();
	
	void deleteProductById(Long id);
}