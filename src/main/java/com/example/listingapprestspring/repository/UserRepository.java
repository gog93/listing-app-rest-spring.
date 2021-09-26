package com.example.listingapprestspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<com.example.listingapprestspring.model.User, Integer> {
    @Override
    List<com.example.listingapprestspring.model.User> findAll();
}
