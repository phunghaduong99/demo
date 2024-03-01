package com.example.demo.entity;

import com.example.demo.entity.enumration.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "t_place")
@Data
public class Place extends BaseEntity{

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "value")
    private String value;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
