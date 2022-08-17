package com.oscngl.springbootawss3.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface S3Service {

    List<String> getFiles();
    byte[] downloadFile(String filename);
    String uploadFile(MultipartFile file);
    String deleteFile(String filename);

}
