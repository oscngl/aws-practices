package com.oscngl.spring.boot.aws.lambda;

import com.oscngl.spring.boot.aws.lambda.model.User;
import com.oscngl.spring.boot.aws.lambda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringBootAwsLambdaApplication {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public Supplier<List<User>> getUsers() {
        return () -> userRepository.getUsers();
    }

    @Bean
    public Function<Long, List<User>> getUserById() {
        return (id) -> userRepository
                .getUsers()
                .stream()
                .filter(user -> user.getId().equals(id))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAwsLambdaApplication.class, args);
    }

}
