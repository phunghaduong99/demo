package com.example.demo.entity.user;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.enumration.RoleEnum;
import com.example.demo.entity.enumration.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

//@MappedSuperclass
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "t_user")
public class UserBaseEntity extends BaseEntity implements UserDetails {

    @Column(name = "username", unique = true, length = 100, nullable = false)
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role", columnDefinition = "varchar(255)")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @Column(name = "status", columnDefinition = "varchar(255)")
    @Enumerated(EnumType.STRING)
    @Value("ACTIVATED")
    private Status status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == null) return null;
        if (role.getPermissions() == null) return null;

        return role.getPermissions().stream()
                .map(Enum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
