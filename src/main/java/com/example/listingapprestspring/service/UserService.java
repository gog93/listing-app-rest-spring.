package com.example.listingapprestspring.service;

import com.example.listingapprestspring.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<User> deleteById(int id);

    ResponseEntity<User> updateUser(int id, User listing);

    User addUser(User user);

    ResponseEntity<User> findById(int id);

    List<User> findAll();
}
