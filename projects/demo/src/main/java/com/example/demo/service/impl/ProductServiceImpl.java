package com.example.demo.service.impl;

import com.example.demo.converter.product.ProductResConverter;
import com.example.demo.model.req.product.ProductAddReq;
import com.example.demo.model.res.product.ProductRes;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductResConverter productResConverter;

    public ProductServiceImpl(ProductRepository productRepository, ProductResConverter productResConverter){
        this.productResConverter = productResConverter;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductRes> findAll(Pageable pageable) {
        return productResConverter.toDto(productRepository.findAll(pageable).getContent());
    }

    @Override
    public ProductRes addProduct(ProductAddReq res) {
        return null;
    }
}