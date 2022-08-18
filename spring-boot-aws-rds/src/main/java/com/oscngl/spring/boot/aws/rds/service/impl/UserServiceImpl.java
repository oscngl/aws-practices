package com.oscngl.spring.boot.aws.rds.service.impl;

import com.oscngl.spring.boot.aws.rds.exception.EntityAlreadyExistsException;
import com.oscngl.spring.boot.aws.rds.exception.EntityNotFoundException;
import com.oscngl.spring.boot.aws.rds.mapper.UserMapper;
import com.oscngl.spring.boot.aws.rds.model.User;
import com.oscngl.spring.boot.aws.rds.repository.UserRepository;
import com.oscngl.spring.boot.aws.rds.request.UserRequest;
import com.oscngl.spring.boot.aws.rds.response.UserResponse;
import com.oscngl.spring.boot.aws.rds.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.usersToResponses(users);
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return UserMapper.INSTANCE.userToResponse(user);
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + email));
        return UserMapper.INSTANCE.userToResponse(user);
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        Optional<User> userByEmail = userRepository.findByEmail(userRequest.getEmail());
        if(userByEmail.isPresent()) {
            throw new EntityAlreadyExistsException("User already exists with email: " + userRequest.getEmail());
        }
        return UserMapper.INSTANCE.userToResponse(userRepository.save(UserMapper.INSTANCE.requestToUser(userRequest)));
    }

    @Override
    public void updateUser(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        if(!user.getEmail().equals(userRequest.getEmail())) {
            Optional<User> userByEmail = userRepository.findByEmail(userRequest.getEmail());
            if(userByEmail.isPresent()) {
                throw new EntityAlreadyExistsException("User already exists with email: " + userRequest.getEmail());
            }
        }
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
