package com.example.backend_fil_rouge.services;

import java.util.List;

import com.example.backend_fil_rouge.models.Category;

public interface CategoryService {
	List<Category> getCategories();
	
	Category getCategoryById(Long id);
	
	Category addCategory(Category category);
	
	Category updateCategory(Category category, Long id);
	
	void deleteCategoryById(Long id);
	
	void deleteCategories();
}
