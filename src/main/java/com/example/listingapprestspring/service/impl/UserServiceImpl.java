package com.example.listingapprestspring.service.impl;

import com.example.listingapprestspring.model.User;
import com.example.listingapprestspring.repository.UserRepository;
import com.example.listingapprestspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;

    @Override
    public ResponseEntity<User> deleteById(int id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @Override
    public ResponseEntity <User> updateUser(int id, User user) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User userFromDb = byId.get();
        userFromDb.setName(user.getName());
        userFromDb.setPassword(user.getPassword());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setSurname(user.getSurname());
        user.setRole(user.getRole());

        return ResponseEntity.ok().body(userRepository.save(user));
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public ResponseEntity <User> findById(int id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @Override
    public List <User> findAll() {
        return userRepository.findAll();
    }
}
