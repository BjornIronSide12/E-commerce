package com.ecommerce.userservice.entity;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "naman")
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID uuid;
}