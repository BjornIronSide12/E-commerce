package com.ecommerce.productcatalog.dto;


import com.ecommerce.productcatalog.models.Category;
import com.ecommerce.productcatalog.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    Long id;
    String title;
    String image;
    double price;
    String description;
    String brand;
    String model;
    String color;
    Category category;
    String discount;

    public static UpdateProductDto getUpdateProductDtoFromProductDto(ProductDto productDto) {
        return new UpdateProductDto(productDto.getId(), productDto.getTitle(), productDto.getBrand(), productDto.getModel(), productDto.color, productDto.category, productDto.discount);
    }

    public static Product productDtoToProduct(ProductDto productDto) {
        Product product = new Product();

        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());

        return product;
    }
}
