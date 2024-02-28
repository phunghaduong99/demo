package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_category")
@Data
public class Category extends BaseEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private String value;
}
