package com.oscngl.spring.boot.aws.ci.cd.codepipeline.codebuild.elastic.beanstalk.repository;

import com.oscngl.spring.boot.aws.ci.cd.codepipeline.codebuild.elastic.beanstalk.model.User;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserRepository {

    private final List<User> users = Stream.of(
            new User(1L, "User", "1", "user1@gmail.com"),
            new User(2L, "User", "2", "user2@gmail.com"),
            new User(3L, "User", "3", "user3@gmail.com"),
            new User(4L, "User", "4", "user5@gmail.com"),
            new User(5L, "Ömer Said", "Çengel", "oscngl@gmail.com")
    ).collect(Collectors.toList());

    public List<User> findAll() {
        return users
                .stream()
                .sorted(Comparator.comparing(User::getId).reversed())
                .collect(Collectors.toList());
    }

    public User findById(Long id) {
        return users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElse(null);
    }

}
