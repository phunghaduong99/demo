package com.example.demo.entity.user;

import com.example.demo.entity.user.UserBaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_seller")
@Data
@NoArgsConstructor
public class Seller extends UserBaseEntity {

    @Column(name="phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name="bussinesEmail")
    private String bussinesEmail;
}
