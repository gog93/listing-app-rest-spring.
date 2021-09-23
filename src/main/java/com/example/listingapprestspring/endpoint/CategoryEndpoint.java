package com.example.listingapprestspring.endpoint;

import com.example.listingapprestspring.model.Category;
import com.example.listingapprestspring.model.Listing;
import com.example.listingapprestspring.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CategoryEndpoint {
    private final CategoryRepository categoryRepositori;

    @GetMapping("/categories")
    public List<Category> categories() {
        return categoryRepositori.findAll();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("is") int id) {
        Optional<Category> byId = categoryRepositori.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/categories")
    public Category category(@RequestBody Category category) {
        return categoryRepositori.save(category);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> category(@PathVariable ("id") int id, @RequestBody Category category) {
        Optional <Category> byId=categoryRepositori.findById(id);
        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Category categoryFromDb=byId.get();
        categoryFromDb.setName(category.getName());

        return ResponseEntity.ok().body(categoryRepositori.save(category));
    }

    @DeleteMapping("/categories")
    public ResponseEntity<Category> deleteById(@PathVariable("is") int id) {
        Optional<Category> byId = categoryRepositori.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoryRepositori.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
