package com.oscngl.spring.boot.aws.rds.service;

import com.oscngl.spring.boot.aws.rds.request.UserRequest;
import com.oscngl.spring.boot.aws.rds.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getUsers();
    UserResponse getUserById(Long id);
    UserResponse getUserByEmail(String email);
    UserResponse createUser(UserRequest userRequest);
    void updateUser(Long id, UserRequest userRequest);
    void deleteUser(Long id);

}
