package com.example.demo.converter.product;

import com.example.demo.entity.Product;
import com.example.demo.model.req.product.ProductAddReq;
import com.example.demo.model.res.product.ProductRes;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProductAddConverter {
    private final ModelMapper modelMapper;

    public ProductAddConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public Product toEntity(ProductAddReq productAddReq){
        return modelMapper.map(productAddReq, Product.class);
    }

    List<Product> toEntity(List<ProductAddReq> productResList){
        return productResList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
