package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.dto.StatusMessageDto;
import com.ecommerce.productcatalog.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SImpleProductServiceImpl implements ProductService{
    @Override
    public ProductDto getProductById(Long id) {
        System.out.println("Simple Project manager");
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public StatusMessageDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return null;
    }


}
