package com.example.demo.entity;

import com.example.demo.entity.enumration.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_category")
@Data
public class Category extends BaseEntity{

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "value")
    private String value;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
