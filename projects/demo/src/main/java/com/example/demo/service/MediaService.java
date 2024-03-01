package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaService {
    String uploadImage(MultipartFile file, String folderName);
    List<String> uploadMultiImage(List<MultipartFile> files, String folderName);
}
