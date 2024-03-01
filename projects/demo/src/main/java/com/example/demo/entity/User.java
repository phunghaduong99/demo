package com.example.demo.entity;

import com.example.demo.entity.enumration.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_user")
@Data
public class User extends UserBaseEntity{

    private Gender gender;
}
