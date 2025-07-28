package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.models.Product;

public interface ProductService {
    ProductDto getProductById(Long id) ;
}
