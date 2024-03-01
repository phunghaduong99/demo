package com.example.demo.api;

import com.example.demo.model.req.product.ProductAddReq;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/products")
public class ProductApi {

    private final ProductService productService;

    public ProductApi(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(Pageable pageable){
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductAddReq req){
        return ResponseEntity.ok(productService.addProduct(req));
    }
}
