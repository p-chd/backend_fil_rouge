package com.example.backend_fil_rouge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_fil_rouge.models.Product;
import com.example.backend_fil_rouge.services.ProductService;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<List<Product>> getProducts()
	{
		try {
			List<Product> products = productService.getProducts();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Product> getProductById(@PathVariable Long id)
	{
		try {
			Product product = productService.getProductById(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product, @PathVariable Long category_id)
	{
		try {
			return new ResponseEntity<Product>(productService.addProduct(product, category_id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id)
	{
		try {
			return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "", produces = "application/json")
	public ResponseEntity<HttpStatus> deleteProducts()
	{
		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<HttpStatus> deleteProductById(@PathVariable Long id)
	{
		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
