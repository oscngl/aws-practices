package com.oscngl.spring.boot.aws.api.gateway.elastic.beanstalk.controller;

import com.oscngl.spring.boot.aws.api.gateway.elastic.beanstalk.model.User;
import com.oscngl.spring.boot.aws.api.gateway.elastic.beanstalk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<>("AWS API Gateway & Elastic Beanstalk with Spring Boot", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

}
