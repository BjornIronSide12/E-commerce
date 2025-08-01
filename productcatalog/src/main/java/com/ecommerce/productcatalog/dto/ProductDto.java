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
    String discount;

    public static UpdateProductDto getUpdateProductDtoFromProductDto(ProductDto productDto) {
        return new UpdateProductDto(productDto.getId(), productDto.getTitle(), productDto.getBrand(), productDto.getModel(), productDto.color, productDto.category, productDto.discount);
    }
}
