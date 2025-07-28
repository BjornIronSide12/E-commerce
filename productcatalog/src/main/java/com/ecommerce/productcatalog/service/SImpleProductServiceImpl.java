package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.models.Product;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SImpleProductServiceImpl implements ProductService{
    @Override
    public ProductDto getProductById(Long id) {
        System.out.println("Simple Project manager");
        return null;
    }
}
