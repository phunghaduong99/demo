package com.example.demo.entity;

import com.example.demo.entity.enumration.Role;
import com.example.demo.entity.enumration.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_seller")
@Data
public class Seller extends UserBaseEntity{

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="bussinesEmail")
    private String bussinesEmail;
}
