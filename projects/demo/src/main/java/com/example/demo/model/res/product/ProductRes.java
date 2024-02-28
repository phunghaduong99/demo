package com.example.demo.model.res.product;

import com.example.demo.entity.enumration.Gender;
import com.example.demo.model.res.category.CategoryRes;
import com.example.demo.model.res.place.PlaceRes;
import lombok.Data;

@Data
public class ProductRes {

    private String name;

    private Float rootPrice;

    private Float presentPrice;

    private String image;

    private Float discount;

    private String color;

    private String description;

    private Gender gender;

    private PlaceRes place;

    private CategoryRes category;
}
