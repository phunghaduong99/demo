package com.example.demo.model.req.product;

import com.example.demo.entity.enumration.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ProductAddReq {

    @NotBlank(message = "name is not null or empty")
    private String name;

    @NotNull(message = "rootPrice is not null")
    @Min(message = "rootPrice must > 0", value = 0)
    private Float rootPrice;

    @NotNull(message = "presentPrice is not null")
    @Min(message = "presentPrice must > 0", value = 0)
    private Float presentPrice;

    @NotNull(message = "images is not null")
    private List<String> images;

    @NotNull(message = "discount is not null")
    @Min(message = "discount must > 0", value = 0)
    private Float discount;

    @NotBlank(message = "color is not null or empty")
    private String color;

    @NotBlank(message = "description is not null or empty")
    private String description;

    @NotNull(message = "gender is not null")
    private Gender gender;

    @NotBlank(message = "placeCode is not null or empty")
    private String placeCode;

    @NotBlank(message = "categoryCode is not null or empty")
    private String categoryCode;
}
