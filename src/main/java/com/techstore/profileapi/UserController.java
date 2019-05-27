package com.techstore.profileapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmailAndPassword(email, password );
        if (user == null) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/users/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        return userRepository.findById(Integer.parseInt(id)).get();
    }


    @GetMapping("/users")
    public @ResponseBody List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @PostMapping("/users")
    public @ResponseBody User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public @ResponseBody void deleteUser(@PathVariable String id) {
        userRepository.deleteById(Integer.parseInt(id));
    }

    @PutMapping("/users/{id}")
    public @ResponseBody User UpdateUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
}






