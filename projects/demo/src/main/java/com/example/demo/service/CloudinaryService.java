package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CloudinaryService {

    public String uploadFile(MultipartFile file, String folderName);

    public List<String> uploadMultiFile(List<MultipartFile> files, String folderName);
}
