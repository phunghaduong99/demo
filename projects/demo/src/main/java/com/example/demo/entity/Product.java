package com.example.demo.entity;

import com.example.demo.entity.enumration.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "t_product")
@Data
public class Product extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "rootPrice")
    private Float rootPrice;

    @Column(name = "presentPrice")
    private Float presentPrice;

    @Column(name = "image")
    private String image;

    @Column(name = "discount")
    private Float discount;

    @Column(name = "color")
    private String color;

    @Column(name = "description")
    private String description;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Place place;
}
