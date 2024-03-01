package com.example.demo.model.res.product;

import com.example.demo.entity.Image;
import com.example.demo.entity.enumration.Gender;
import com.example.demo.model.res.category.CategoryRes;
import com.example.demo.model.res.image.ImageRes;
import com.example.demo.model.res.place.PlaceRes;
import lombok.Data;

import java.util.List;

@Data
public class ProductRes {

    private String name;

    private Float rootPrice;

    private Float presentPrice;

    private List<ImageRes> images;

    private Float discount;

    private String color;

    private String description;

    private Gender gender;

    private PlaceRes place;

    private CategoryRes category;
}
