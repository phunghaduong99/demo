package com.example.demo.model.req.product;

import com.example.demo.entity.enumration.Gender;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ProductAddReq {

    private Long productCode;

    private String name;

    private Float rootPrice;

    private Float presentPrice;

    private List<String> images;

    private Float discount;

    private String color;

    private String description;

    private Gender gender;

    private String placeValue;

    private String categoryValue;
}
