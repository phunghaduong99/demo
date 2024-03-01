package com.example.demo.service;

import com.example.demo.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    public Image findByUrlName(String url);
    public String uploadImage(MultipartFile file, String folderName);
    public List<String> uploadMultiImage(List<MultipartFile> files, String folderName);
}
