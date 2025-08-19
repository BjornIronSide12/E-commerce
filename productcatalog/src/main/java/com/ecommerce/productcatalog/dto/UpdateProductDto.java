package com.ecommerce.productcatalog.dto;

import com.ecommerce.productcatalog.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateProductDto {
    private Long id;
    private String title;
    private String brand;
    private String model;
    private String color;
    private Category category;
    private String discount;
}
