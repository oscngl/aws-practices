package com.oscngl.spring.boot.aws.sqs.controller;

import com.oscngl.spring.boot.aws.sqs.service.AwsSqsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aws/sqs")
@RequiredArgsConstructor
public class AwsSqsController {

    private final AwsSqsService sqsService;

    @GetMapping("/send/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {
        return new ResponseEntity<>(sqsService.sendMessage(message), HttpStatus.OK);
    }

}
