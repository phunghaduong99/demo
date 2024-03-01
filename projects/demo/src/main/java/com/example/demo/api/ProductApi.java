package com.example.demo.api;

import com.example.demo.model.req.product.ProductAddReq;
import com.example.demo.service.ImageService;
import com.example.demo.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin/products")
public class ProductApi {

    private final ProductService productService;

    private final ImageService imageService;

    public ProductApi(ProductService productService, ImageService imageService){
        this.productService = productService;
        this.imageService = imageService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable){
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadFiles(@RequestPart MultipartFile imageFile) throws Exception {
        try {
            return ResponseEntity.ok().body(Map.of("url", imageService.uploadImage(imageFile, "product")));
        } catch (Exception e) {
            throw new Exception("INVALID DATA", e);
        }
    }

    @PostMapping(value = "/uploadMultiFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadMultiFile(@RequestPart List<MultipartFile> files) throws Exception {
        try {
            return ResponseEntity.ok().body(Map.of("url", imageService.uploadMultiImage(files, "product")));
        } catch (Exception e) {
            throw new Exception("INVALID DATA", e);
        }
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductAddReq req){
        return ResponseEntity.ok(productService.addProduct(req));
    }
}
