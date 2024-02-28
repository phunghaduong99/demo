package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    private Instant createdDate = Instant.now();

    @Column(name = "last_modified_date")
    @LastModifiedDate
    private Instant lastModifiedDate = Instant.now();

    @Column(name = "created_by", updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "last_modified_by")
    @LastModifiedBy
    private String lastModifiedBy;
}
