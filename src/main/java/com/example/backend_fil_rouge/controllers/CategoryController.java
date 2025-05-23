package com.example.backend_fil_rouge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend_fil_rouge.models.Category;
import com.example.backend_fil_rouge.services.CategoryService;

@RestController
@RequestMapping(path = "api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<List<Category>> getCategories() {
        try {
            List<Category> categories = categoryService.getCategories();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        try {
            return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        try {
            return new ResponseEntity<>(categoryService.updateCategory(category, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "", produces = "application/json")
    public ResponseEntity<HttpStatus> deleteAllCategories() {
        try {
            categoryService.deleteCategories();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable Long id) {
        try {
            categoryService.deleteCategoryById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
