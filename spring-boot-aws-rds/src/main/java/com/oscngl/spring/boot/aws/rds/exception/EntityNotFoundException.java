package com.oscngl.spring.boot.aws.rds.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String msg) {
        super(msg);
    }

}
