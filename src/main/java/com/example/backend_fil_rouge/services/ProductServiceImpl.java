package com.example.backend_fil_rouge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_fil_rouge.models.Category;
import com.example.backend_fil_rouge.models.Product;
import com.example.backend_fil_rouge.repositories.CategoryRepository;
import com.example.backend_fil_rouge.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productRepo.findAll();
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepo.findById(id);
		if (product.isPresent())
			return product.get();
		return null;
	}

	@Override
	public Product addProduct(Product product, Long category_id) {
		// TODO Auto-generated method stub
		Optional<Category> category = categoryRepo.findById(category_id);
		if (category.isPresent())
		{
			Product _product = new Product();
			_product.setAvailable(product.getAvailable());
			_product.setName(product.getName());
			_product.setPrice(product.getPrice());
			_product.setDescription(product.getDescription());
			_product.setCategory(category.get());
			return productRepo.save(_product);
		}
		return null;
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		// TODO Auto-generated method stub
		Optional<Product> tempProduct = productRepo.findById(id);
		if (tempProduct.isPresent())
		{
			Product _product = tempProduct.get();
			_product.setName(product.getName());
			_product.setAvailable(product.getAvailable());
			_product.setDescription(product.getDescription());
			_product.setPrice(product.getPrice());
			return productRepo.save(_product);
		}
		return null;
	}

	@Override
	public void deleteProducts() {
		// TODO Auto-generated method stub
		productRepo.deleteAll();
	}

	@Override
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
	}
	
}
