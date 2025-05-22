package com.example.backend_fil_rouge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_fil_rouge.models.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}