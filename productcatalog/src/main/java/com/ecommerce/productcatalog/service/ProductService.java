package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.models.Product;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(Long id);
    List<ProductDto> getAllProducts();
}
