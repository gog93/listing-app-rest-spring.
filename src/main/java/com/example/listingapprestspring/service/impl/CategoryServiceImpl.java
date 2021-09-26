package com.example.listingapprestspring.service.impl;

import com.example.listingapprestspring.model.Category;
import com.example.listingapprestspring.repository.CategoryRepository;
import com.example.listingapprestspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    public final CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<Category> deleteById(int id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @Override
    public ResponseEntity <Category> updateCategory(int id, Category category) {
        Optional <Category> byId=categoryRepository.findById(id);
        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Category categoryFromDb=byId.get();
        categoryFromDb.setName(category.getName());

        return ResponseEntity.ok().body(categoryRepository.save(category));
    }


    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public ResponseEntity<Category> findById(int id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
