package com.ecommerce.userservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class UserEntity extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SessionEntity> sessions;
}
