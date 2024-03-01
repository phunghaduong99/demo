package com.example.demo.service.impl;

import com.example.demo.entity.Image;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.CloudinaryService;
import com.example.demo.service.MediaService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {
    private final ImageRepository imageRepository;
    private final CloudinaryService cloudinaryService;

    public MediaServiceImpl(ImageRepository imageRepository, CloudinaryService cloudinaryService) {
        this.imageRepository = imageRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public String uploadImage(MultipartFile imageFile, String folderName) {
        try {

            Image image = new Image();
            image.setName(folderName);
            image.setUrl(cloudinaryService.uploadFile(imageFile, folderName));
            if(image.getUrl() == null) {
                return null;
            }
            imageRepository.save(image);
            return image.getUrl();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> uploadMultiImage(List<MultipartFile> files, String folderName) {
        return  files.stream().map((file) -> uploadImage(file, folderName)).toList();
    }
}

