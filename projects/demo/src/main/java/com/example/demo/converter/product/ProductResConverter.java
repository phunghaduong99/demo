package com.example.demo.converter.product;

import com.example.demo.entity.Product;
import com.example.demo.model.res.product.ProductRes;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductResConverter {

    private final ModelMapper modelMapper;

    public ProductResConverter(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ProductRes toDto(Product product){
        return modelMapper.map(product, ProductRes.class);
    }

    public List<ProductRes> toDto(List<Product> products){
        return products.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Product toEntity(ProductRes productRes){
        return modelMapper.map(productRes, Product.class);
    }

    List<Product> toEntity(List<ProductRes> productResList){
        return productResList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
