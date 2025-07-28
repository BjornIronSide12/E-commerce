package com.ecommerce.productcatalog.controllers;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController {

    // Field Injection
    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

    //Constructor injection
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
    @GetMapping("{id}")
    public ProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

}
