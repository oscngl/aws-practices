package com.oscngl.spring.boot.aws.rds.mapper;

import com.oscngl.spring.boot.aws.rds.model.User;
import com.oscngl.spring.boot.aws.rds.request.UserRequest;
import com.oscngl.spring.boot.aws.rds.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User requestToUser(UserRequest userRequest);
    UserRequest userToRequest(User user);
    List<User> requestsToUsers(List<UserRequest> userRequests);
    List<UserRequest> usersToRequests(List<User> users);

    User responseToUser(UserResponse userResponse);
    UserResponse userToResponse(User user);
    List<User> responsesToUsers(List<UserResponse> userResponses);
    List<UserResponse> usersToResponses(List<User> users);

}
