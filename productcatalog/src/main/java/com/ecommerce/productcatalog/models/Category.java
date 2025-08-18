package com.ecommerce.productcatalog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel{
    @Column
    private String name;
    /**
     * The field that owns the relationship. Required unless
     * the relationship is unidirectional.
     */
    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
