package com.example.demo.entity;

import com.example.demo.entity.user.Seller;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "t_shop")
@Data
public class Shop extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Seller owner;

    @ManyToOne
    private Image image;

    @OneToMany(mappedBy = "shop")
    private List<Product> products;
}