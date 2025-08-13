package com.ecommerce.productcatalog.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(generator = "myGenerator")
    @Column(name = "id")
    private UUID uuid;
}
