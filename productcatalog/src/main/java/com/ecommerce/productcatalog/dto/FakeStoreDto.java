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

//  simply returning the productDto after converting
            return FakeStoreProductDto.getProductDtoFromFakeStoreProductDto(fakeStoreDto.getProduct());
    }
}
