package com.ecommerce.productcatalog.thirdpartyclient.fakestoreclient;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.dto.StatusMessageDto;
import com.ecommerce.productcatalog.exception.NotFoundException;
import com.ecommerce.productcatalog.exception.ProductIsNullException;

import java.util.List;

public interface ProductClient {
    ProductDto getProductById(Long id) throws NotFoundException, ProductIsNullException;
    List<ProductDto> getAllProducts();
    StatusMessageDto deleteProductById(Long id);
    ProductDto updateProduct(ProductDto productDto) throws NotFoundException;
}
