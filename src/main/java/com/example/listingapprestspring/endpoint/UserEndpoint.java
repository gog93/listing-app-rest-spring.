package com.example.listingapprestspring.endpoint;


import com.example.listingapprestspring.model.User;
import com.example.listingapprestspring.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class UserEndpoint {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public List<com.example.listingapprestspring.model.User> users() {
        return userServiceImpl.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("is") int id) {
        return userServiceImpl.findById(id);
    }

    @PostMapping("/users")
    public User category(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return userServiceImpl.updateUser(id, user);
    }

    @DeleteMapping("/users")
    public ResponseEntity<User> deleteById(@PathVariable("is") int id) {
        return userServiceImpl.deleteById(id);
    }

}
