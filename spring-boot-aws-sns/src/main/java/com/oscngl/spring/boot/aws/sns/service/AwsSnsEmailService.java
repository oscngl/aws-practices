package com.oscngl.spring.boot.aws.sns.service;

import com.oscngl.spring.boot.aws.sns.model.SnsEmailMessage;

public interface AwsSnsEmailService {

    String subscribe(String topic, String email);
    String sendNotification(String topic, SnsEmailMessage snsEmailMessage);

}
