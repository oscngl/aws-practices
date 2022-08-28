package com.oscngl.spring.boot.aws.ses.controller;

import com.oscngl.spring.boot.aws.ses.service.AwsSesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aws/ses")
@RequiredArgsConstructor
public class AwsSesController {

    private final AwsSesService awsSesService;

    @GetMapping("/send")
    public ResponseEntity<String> sendEmail(SimpleMailMessage simpleMailMessage) {
        awsSesService.sendEmail(simpleMailMessage);
        return new ResponseEntity<>("Mail sent successfully.", HttpStatus.OK);
    }

}
