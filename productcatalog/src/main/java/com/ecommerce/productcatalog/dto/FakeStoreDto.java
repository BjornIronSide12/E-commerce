package com.ecommerce.productcatalog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {
    String status;
    String message;
    FakeStoreProductDto product;

    public static ProductDto getProductDtoFromFakeStoreDto(FakeStoreDto fakeStoreDto) {
        if(fakeStoreDto == null) {
            return new ProductDto();
        }
        ProductDto productDto = new ProductDto();
        productDto.setTitle(fakeStoreDto.getProduct().getTitle());
        productDto.setImage(fakeStoreDto.getProduct().getImage());
        productDto.setPrice(fakeStoreDto.getProduct().getPrice());
        productDto.setDescription(fakeStoreDto.getProduct().getDescription());
        productDto.setBrand(fakeStoreDto.getProduct().getBrand());
        productDto.setModel(fakeStoreDto.getProduct().getModel());
        productDto.setColor(fakeStoreDto.getProduct().getColor());
        productDto.setCategory(fakeStoreDto.getProduct().getCategory());

        return productDto;
    }
}
