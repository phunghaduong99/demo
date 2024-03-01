package com.example.demo.entity;

import com.example.demo.entity.composite.UserProductKey;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "t_product_rate")
@Entity
@Data
public class ProductRate {

    @EmbeddedId
    private UserProductKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "rate")
    private int rate;
}
