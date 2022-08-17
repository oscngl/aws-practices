package com.oscngl.spring.boot.aws.lambda.repository;

import com.oscngl.spring.boot.aws.lambda.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepository {

    public List<User> getUsers() {
        return Stream.of(
                new User(1L, "User", "1", "user1@gmail.com"),
                new User(2L, "User", "2", "user2@gmail.com"),
                new User(3L, "User", "3", "user3@gmail.com"),
                new User(4L, "User", "4", "user5@gmail.com"),
                new User(5L, "Ömer Said", "Çengel", "oscngl@gmail.com")
        ).collect(Collectors.toList());
    }

}
