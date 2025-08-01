package com.ecommerce.productcatalog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class FakeStoreMultipleProductsDto {
    StatusMessageDto statusMessageDto;
    List<FakeStoreProductDto> products;

    public static List<ProductDto> getProductDtoFromFakeStoreMultipleProductDto(FakeStoreMultipleProductsDto fakeStoreDtoList) {

        // null check
        if(fakeStoreDtoList == null) {
            return null;
        }

        // converting list of FakeStoreProductDto 
        List<ProductDto> productDtoList = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreDtoList.getProducts()) {
            ProductDto productDto = FakeStoreProductDto.getProductDtoFromFakeStoreProductDto(fakeStoreProductDto);

            productDtoList.add(productDto);
        }
        return productDtoList;
    }
}
