package com.oscngl.spring.boot.aws.ses.service.impl;

import com.oscngl.spring.boot.aws.ses.service.AwsSesService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AwsSesServiceImpl implements AwsSesService {

    private final MailSender mailSender;

    @Override
    public void sendEmail(SimpleMailMessage simpleMailMessage) {
        mailSender.send(simpleMailMessage);
    }

}
