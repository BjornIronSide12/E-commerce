package com.ecommerce.productcatalog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class FakeStoreMultipleProductsDto {
    String status;
    String message;
    List<FakeStoreProductDto> products;

    public static List<ProductDto> getProductDtoFromFakeStoreMultipleProductDto(FakeStoreMultipleProductsDto fakeStoreDto) {

        List<ProductDto> productDtoList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreDto.getProducts()) {
            ProductDto productDto = new ProductDto();
            productDto.setTitle(fakeStoreProductDto.getTitle());
            productDto.setImage(fakeStoreProductDto.getImage());
            productDto.setPrice(fakeStoreProductDto.getPrice());
            productDto.setDescription(fakeStoreProductDto.getDescription());
            productDto.setBrand(fakeStoreProductDto.getBrand());
            productDto.setModel(fakeStoreProductDto.getModel());
            productDto.setColor(fakeStoreProductDto.getColor());
            productDto.setCategory(fakeStoreProductDto.getCategory());

            productDtoList.add(productDto);
        }
        return productDtoList;
    }
}
