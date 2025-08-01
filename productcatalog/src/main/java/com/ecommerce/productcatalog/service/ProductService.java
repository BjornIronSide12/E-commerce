package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.dto.StatusMessageDto;
import com.ecommerce.productcatalog.exception.NotFoundException;
import com.ecommerce.productcatalog.models.Product;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(Long id) throws NotFoundException;
    List<ProductDto> getAllProducts();
    StatusMessageDto deleteProductById(Long id);
    ProductDto updateProduct(ProductDto productDto) throws NotFoundException;
}
