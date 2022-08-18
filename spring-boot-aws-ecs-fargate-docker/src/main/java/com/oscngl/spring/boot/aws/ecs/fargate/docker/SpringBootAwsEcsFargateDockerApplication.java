package com.oscngl.spring.boot.aws.ecs.fargate.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class SpringBootAwsEcsFargateDockerApplication {

    @GetMapping
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<>("AWS ECS & Fargate & Docker with Spring Boot Application", HttpStatus.OK);

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAwsEcsFargateDockerApplication.class, args);
    }

}
