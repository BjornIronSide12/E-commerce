package com.ecommerce.productcatalog.controllers;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.dto.StatusMessageDto;
import com.ecommerce.productcatalog.exception.NotFoundException;
import com.ecommerce.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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

//    APIs

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id) throws NotFoundException{
        return new ResponseEntity<>(productService.getProductById(id),
                HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<StatusMessageDto> deleteProductById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(
                productService.deleteProductById(id),
        HttpStatus.OK);
    }

    @PutMapping(path="/", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) throws NotFoundException {
        return new ResponseEntity<>(productService.updateProduct(productDto)
                , HttpStatus.OK);
    }

}
