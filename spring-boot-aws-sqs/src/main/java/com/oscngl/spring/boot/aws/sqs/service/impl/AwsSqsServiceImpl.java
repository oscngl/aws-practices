package com.oscngl.spring.boot.aws.sqs.service.impl;

import com.oscngl.spring.boot.aws.sqs.service.AwsSqsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AwsSqsServiceImpl implements AwsSqsService {

    private final QueueMessagingTemplate queueMessagingTemplate;

    Logger logger= LoggerFactory.getLogger(AwsSqsServiceImpl.class);

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    @Override
    public String sendMessage(String message) {
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
        return "Message sent successfully: " + message;
    }

    @Override
    @SqsListener("spring-boot-aws-sqs-queue")
    public void loadMessage(String message) {
        logger.info("Message from SQS Queue: " + message);
    }

}
