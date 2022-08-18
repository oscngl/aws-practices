package com.oscngl.spring.boot.aws.sns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsEmailMessage {

    private String subject;
    private String body;

}
