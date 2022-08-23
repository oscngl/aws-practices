package com.oscngl.spring.boot.aws.dynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.oscngl.spring.boot.aws.dynamodb.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final DynamoDBMapper mapper;

    public User save(User user) {
        mapper.save(user);
        return user;
    }

    public User findById(String id) {
        return mapper.load(User.class, id);
    }

    public void delete(User user) {
        mapper.delete(user);
    }

    public User update(User user) {
        mapper.save(user, buildExpression(user));
        return user;
    }

    private DynamoDBSaveExpression buildExpression(User user) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("id", new ExpectedAttributeValue(new AttributeValue().withS(user.getId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }

}
