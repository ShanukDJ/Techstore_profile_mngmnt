package com.techstore.profileapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/users/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        return userRepository.findById(Integer.parseInt(id)).get();
    }

    @PostMapping("/users")
    public @ResponseBody User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public @ResponseBody void deleteUser(@PathVariable String id) {
        userRepository.deleteById(Integer.parseInt(id));
    }

    @PutMapping("/users")
    public @ResponseBody User UpdateUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}


