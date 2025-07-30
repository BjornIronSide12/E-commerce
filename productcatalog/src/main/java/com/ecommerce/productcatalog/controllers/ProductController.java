package com.ecommerce.productcatalog.controllers;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    // Field Injection
//    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;

//    Constructor injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    API

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id),
                HttpStatus.OK);
    }

}
