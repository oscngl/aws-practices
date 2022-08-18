package com.oscngl.spring.boot.aws.ci.cd.codepipeline.codebuild.elastic.beanstalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootAwsCiCdCodepipelineCodebuildElasticBeanstalkApplication {

    @GetMapping
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<>("AWS CodePipeline & CodeBuild & Elastic Beanstalk & CI/CD with Spring Boot", HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAwsCiCdCodepipelineCodebuildElasticBeanstalkApplication.class, args);
    }

}
