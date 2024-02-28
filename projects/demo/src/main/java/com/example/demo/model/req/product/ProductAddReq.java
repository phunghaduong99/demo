package com.example.demo.model.req.product;

import com.example.demo.entity.enumration.Gender;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductAddReq {

    private String name;

    private Float rootPrice;

    private Float presentPrice;

    private String image;

    private Float discount;

    private String color;

    private String description;

    private Gender gender;

    private String placeCode;

    private String categoryCode;
}
