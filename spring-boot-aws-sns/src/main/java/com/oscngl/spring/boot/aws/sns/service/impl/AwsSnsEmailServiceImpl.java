package com.oscngl.spring.boot.aws.sns.service.impl;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.oscngl.spring.boot.aws.sns.model.SnsEmailMessage;
import com.oscngl.spring.boot.aws.sns.service.AwsSnsEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AwsSnsEmailServiceImpl implements AwsSnsEmailService {

    private final AmazonSNSClient snsClient;

    @Override
    public String subscribe(String topic, String email) {
        SubscribeRequest request = new SubscribeRequest(topic, "email", email);
        snsClient.subscribe(request);
        return "Subscription request is pending. To confirm the subscription, check your email : " + email;
    }

    @Override
    public String sendNotification(String topic, SnsEmailMessage snsEmailMessage) {
        PublishRequest publishRequest=new PublishRequest(topic, snsEmailMessage.getBody(), snsEmailMessage.getSubject());
        snsClient.publish(publishRequest);
        return "Notification sent successfully.";
    }

}
