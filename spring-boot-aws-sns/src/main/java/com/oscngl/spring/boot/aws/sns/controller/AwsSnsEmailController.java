package com.oscngl.spring.boot.aws.sns.controller;

import com.oscngl.spring.boot.aws.sns.model.SnsEmailMessage;
import com.oscngl.spring.boot.aws.sns.service.AwsSnsEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aws/sns/email")
@RequiredArgsConstructor
public class AwsSnsEmailController {

    private final AwsSnsEmailService snsService;

    @GetMapping("/subscribe/{email}")
    public ResponseEntity<String> subscribe(@RequestParam String topic, @PathVariable String email) {
        return new ResponseEntity<>(snsService.subscribe(topic, email), HttpStatus.OK);
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestParam String topic, @RequestBody SnsEmailMessage snsEmailMessage) {
        return new ResponseEntity<>(snsService.sendNotification(topic, snsEmailMessage), HttpStatus.OK);
    }

}
