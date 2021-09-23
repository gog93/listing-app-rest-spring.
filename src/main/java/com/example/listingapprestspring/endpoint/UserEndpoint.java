package com.example.listingapprestspring.endpoint;

//import com.example.listingapprestspring.repository.UserRepository;
import com.example.listingapprestspring.model.Category;
import com.example.listingapprestspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class UserEndpoint {
    @Autowired
    private  UserRepository userRepository;

   @GetMapping("/users")
  public List<User> users() {
       return userRepository.findAll();
   }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getCategory(@PathVariable("is") int id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/user")
    public User category(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> category(@PathVariable ("id") int id, @RequestBody User user) {
        Optional <User> byId=userRepository.findById(id);
        if(byId.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        User userFromDb=byId.get();
        userFromDb.setUsername(user.getUsername());
        userFromDb.setPassword(user.getPassword());

        return ResponseEntity.ok().body(userRepository.save(user));
    }

    @DeleteMapping("/user")
    public ResponseEntity<User> deleteById(@PathVariable("is") int id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
