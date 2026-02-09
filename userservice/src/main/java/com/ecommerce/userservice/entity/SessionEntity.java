package com.ecommerce.userservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class SessionEntity extends BaseEntity{
    private String token;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity user;

    public SessionEntity() {}
    public SessionEntity(UserEntity user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
    }
}
