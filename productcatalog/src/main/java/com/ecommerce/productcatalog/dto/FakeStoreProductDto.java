package com.ecommerce.productcatalog.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    Long id;
    String title;
    String image;
    Integer price;
    String description;
    String brand;
    String model;
    String color;
    String category;
    Boolean popular;
    Integer discount;

    // the object from fakestore api that we are getting is of the type FakeStoreProductDto
    // we are returning ProductDto to the client, to address the conversion at one place we are doing the DTO conversion
    // convert a FakeStoreProductDto object to ProductDto
    public static ProductDto getProductDtoFromFakeStoreProductDto(FakeStoreProductDto fakeStoreProductDto) {
        ProductDto productDto = new ProductDto();
        productDto.setId(fakeStoreProductDto.getId());
        productDto.setTitle(fakeStoreProductDto.getTitle());
        productDto.setImage(fakeStoreProductDto.getImage());
        productDto.setPrice(fakeStoreProductDto.getPrice());
        productDto.setDescription(fakeStoreProductDto.getDescription());
        productDto.setBrand(fakeStoreProductDto.getBrand());
        productDto.setModel(fakeStoreProductDto.getModel());
        productDto.setColor(fakeStoreProductDto.getColor());
        productDto.setCategory(fakeStoreProductDto.getCategory());
        return productDto;
    }
}
