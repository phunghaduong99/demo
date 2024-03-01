package com.example.demo.entity;

import com.example.demo.entity.enumration.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "t_images")
public class Image extends BaseEntity{

    @Column(name = "name_image")
    private String name;

    @Column(name = "url_image")
    private String url;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}