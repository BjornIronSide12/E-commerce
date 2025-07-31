package com.ecommerce.productcatalog.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    int id;
    String title;
    String image;
    Integer price;
    String description;
    String brand;
    String model;
    String color;
    String category;
}
