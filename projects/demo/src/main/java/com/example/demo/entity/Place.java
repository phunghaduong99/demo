package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "t_place")
@Data
public class Place extends BaseEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private String value;
}
