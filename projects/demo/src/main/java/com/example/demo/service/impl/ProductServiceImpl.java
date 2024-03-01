package com.example.demo.service.impl;

import com.example.demo.converter.product.ProductAddConverter;
import com.example.demo.converter.product.ProductResConverter;
import com.example.demo.entity.Category;
import com.example.demo.entity.Image;
import com.example.demo.entity.Place;
import com.example.demo.entity.Product;
import com.example.demo.entity.enumration.Status;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.req.product.ProductAddReq;
import com.example.demo.model.res.product.ProductRes;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductResConverter productResConverter;

    private final ProductAddConverter productAddConverter;

    private final ImageRepository imageRepository;
    private final CategoryRepository categoryRepository;
    private final PlaceRepository placeRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductResConverter productResConverter,
                              ProductAddConverter productAddConverter,
                              ImageRepository imageRepository,
                              CategoryRepository categoryRepository,
                              PlaceRepository placeRepository){
        this.productResConverter = productResConverter;
        this.productRepository = productRepository;
        this.productAddConverter = productAddConverter;
        this.imageRepository = imageRepository;
        this.categoryRepository = categoryRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public List<ProductRes> findAll(Pageable pageable) {
        return productResConverter.toDto(productRepository.findAll(pageable).getContent());
    }

    @Override
    public ProductRes addProduct(ProductAddReq req) {
        // Convert request to entity
        Product product = productAddConverter.toEntity(req);

        // Fetch images from repository
        List<String> imageUrls = req.getImages();
        List<Image> imageList = imageUrls.stream()
                .map(url -> imageRepository.findByUrl(url)
                        .orElseThrow(() -> new NotFoundException("Image not found for URL: " + url)))
                .toList();

        // Set images, category, place, and status for the product
        product.setImages(imageList);

        Category category = categoryRepository.findByCode(req.getCategoryCode())
                .orElseThrow(() -> new NotFoundException("Category with code not found"));
        product.setCategory(category);

        Place place = placeRepository.findByCode(req.getPlaceCode())
                .orElseThrow(() -> new NotFoundException("Place with code not found"));
        product.setPlace(place);

        product.setStatus(Status.ACTIVATED);

        // Save the product and convert it to DTO for response
        return productResConverter.toDto(productRepository.save(product));
    }
}