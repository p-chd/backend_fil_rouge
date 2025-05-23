package com.example.backend_fil_rouge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_fil_rouge.models.Category;
import com.example.backend_fil_rouge.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        Optional<Category> tempCategory = categoryRepository.findById(id);
        if (tempCategory.isPresent()) {
            Category _category = tempCategory.get();
            _category.setName(category.getName());
            _category.setDescription(category.getDescription());
            return categoryRepository.save(_category);
        }
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteCategories() {
        categoryRepository.deleteAll();
    }
}
