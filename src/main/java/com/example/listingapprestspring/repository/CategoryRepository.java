package com.example.listingapprestspring.repository;

import com.example.listingapprestspring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
