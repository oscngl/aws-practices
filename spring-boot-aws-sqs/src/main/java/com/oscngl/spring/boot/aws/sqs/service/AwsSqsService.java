package com.oscngl.spring.boot.aws.sqs.service;

public interface AwsSqsService {

    String sendMessage(String message);
    void loadMessage(String message);

}
