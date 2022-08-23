package com.oscngl.spring.boot.aws.dynamodb.controller;

import com.oscngl.spring.boot.aws.dynamodb.model.User;
import com.oscngl.spring.boot.aws.dynamodb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id) {
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestBody User user) {
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.update(user), HttpStatus.OK);
    }

}
