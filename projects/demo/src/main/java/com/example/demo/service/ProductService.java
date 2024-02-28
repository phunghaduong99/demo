package com.example.demo.service;

import com.example.demo.model.req.product.ProductAddReq;
import com.example.demo.model.res.product.ProductRes;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {
    List<ProductRes> findAll(Pageable pageable);
    ProductRes addProduct(ProductAddReq res);
}
