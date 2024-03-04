package com.example.demo.entity.user;

import com.example.demo.entity.enumration.Gender;
import com.example.demo.entity.user.UserBaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_customer")
@Data
@NoArgsConstructor
public class Customer extends UserBaseEntity {
    @Column(name = "gender", nullable = false,  columnDefinition = "varchar(255)")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
