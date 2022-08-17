package com.oscngl.spring.boot.aws.ec2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>("Spring Boot Application running on Amazon EC2 instance!", HttpStatus.OK);
    }

}
