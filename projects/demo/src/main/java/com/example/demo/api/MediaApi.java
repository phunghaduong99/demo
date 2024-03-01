package com.example.demo.api;

import com.example.demo.service.MediaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin/media")
public class MediaApi {

    private final MediaService mediaService;

    public MediaApi(MediaService mediaService){
        this.mediaService = mediaService;
    }


    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadFiles(@RequestPart MultipartFile imageFile){
        return ResponseEntity.ok().body(Map.of("url", mediaService.uploadImage(imageFile, "product")));
    }

    @PostMapping(value = "/uploadMultiFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadMultiFile(@RequestPart List<MultipartFile> files){
        return ResponseEntity.ok().body(Map.of("url", mediaService.uploadMultiImage(files, "product")));
    }
}
