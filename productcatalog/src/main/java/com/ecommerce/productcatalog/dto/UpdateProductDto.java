package com.ecommerce.productcatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateProductDto {
    private int id;
    private String title;
    private String brand;
    private String model;
    private String color;
    private String category;
    private String discount;
}
