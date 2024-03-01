package com.example.demo.service.impl;

import com.example.demo.converter.product.ProductAddConverter;
import com.example.demo.converter.product.ProductResConverter;
import com.example.demo.entity.Category;
import com.example.demo.entity.Image;
import com.example.demo.entity.Place;
import com.example.demo.entity.Product;
import com.example.demo.model.req.product.ProductAddReq;
import com.example.demo.model.res.product.ProductRes;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ImageService;
import com.example.demo.service.PlaceService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductResConverter productResConverter;

    private final ProductAddConverter productAddConverter;

    private final ImageService imageService;
    private final CategoryService categoryService;
    private final PlaceService placeService;

    public ProductServiceImpl(ProductRepository productRepository, ProductResConverter productResConverter, ProductAddConverter productAddConverter  , ImageService imageService, CategoryService categoryService, PlaceService placeService){
        this.productResConverter = productResConverter;
        this.productRepository = productRepository;
        this.productAddConverter = productAddConverter;
        this.imageService = imageService;
        this.categoryService = categoryService;
        this.placeService = placeService;
    }

    @Override
    public List<ProductRes> findAll(Pageable pageable) {
        return productResConverter.toDto(productRepository.findAll(pageable).getContent());
    }

    @Override
    public ProductRes addProduct(ProductAddReq req) {
        Product product = productAddConverter.toEntity(req);

        List<Image> imageList = req.getImages().stream().map(imageService::findByUrlName).toList();
        product.setImages(imageList);
        Category category  = categoryService.findByValue(req.getCategoryValue());
        Place place  = placeService.findByValue(req.getPlaceValue());
        product.setCategory(category);
        product.setPlace(place);
        product.setId(req.getProductCode());
        productRepository.save(product);

        return productResConverter.toDto(product);
    }
}