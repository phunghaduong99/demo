package com.example.demo.api;

import com.example.demo.model.req.product.ProductAddReq;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/products")
public class ProductApi {

    private final ProductService productService;

    public ProductApi(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping
    public ResponseEntity<?> findAll(Pageable pageable){
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> uploadFiles(List<MultipartFile> files){
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductAddReq req){
        return ResponseEntity.ok(productService.addProduct(req));
    }
}
