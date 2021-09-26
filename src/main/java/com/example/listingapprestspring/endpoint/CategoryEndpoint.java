package com.example.listingapprestspring.endpoint;

import com.example.listingapprestspring.model.Category;
import com.example.listingapprestspring.model.Listing;
import com.example.listingapprestspring.repository.CategoryRepository;
import com.example.listingapprestspring.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CategoryEndpoint {

    private final CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/categories")
    public List<Category> categories() {
        return categoryServiceImpl.findAll();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
        return categoryServiceImpl.findById(id);
    }

    @PostMapping("/categories")
    public Category category(@RequestBody Category category) {
        return categoryServiceImpl.addCategory(category);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
        return categoryServiceImpl.updateCategory(id, category);
    }

    @DeleteMapping("/categories")
    public ResponseEntity<Category> deleteById(@PathVariable("is") int id) {
        return categoryServiceImpl.deleteById(id);
    }

}
