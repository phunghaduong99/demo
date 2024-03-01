package com.example.demo.service.impl;

import com.example.demo.entity.Image;
import com.example.demo.handle.NotFoundException;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.CloudinaryService;
import com.example.demo.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final CloudinaryService cloudinaryService;

    public ImageServiceImpl(ImageRepository imageRepository, CloudinaryService cloudinaryService) {
        this.imageRepository = imageRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public Image findByUrlName(String url) {
        Optional<Image> result = this.imageRepository.findByUrl(url);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new NotFoundException("Image with this name not found");
        }
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
        return  files.stream().map((file) ->
        {
            Image image = new Image();
            try {
                image.setName(folderName);
                image.setUrl(cloudinaryService.uploadFile(file, folderName));
                if (image.getUrl() == null) {
                    return null;
                }
                imageRepository.save(image);
                return image.getUrl();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).toList();
    }
}

