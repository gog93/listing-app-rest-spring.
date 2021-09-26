package com.example.listingapprestspring.service;

import com.example.listingapprestspring.model.Category;
import com.example.listingapprestspring.model.Listing;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    ResponseEntity<Category> deleteById(int id);

    ResponseEntity <Category>  updateCategory(int id, Category category);

    Category addCategory(Category category);

    ResponseEntity <Category> findById(int id);

    List<Category> findAll();
}
