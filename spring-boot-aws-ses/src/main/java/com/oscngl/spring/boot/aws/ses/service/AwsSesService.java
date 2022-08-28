package com.oscngl.spring.boot.aws.ses.service;

import org.springframework.mail.SimpleMailMessage;

public interface AwsSesService {

    void sendEmail(SimpleMailMessage simpleMailMessage);

}
