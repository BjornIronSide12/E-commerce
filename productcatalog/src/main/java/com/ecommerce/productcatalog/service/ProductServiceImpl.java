package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.ProductDto;
import com.ecommerce.productcatalog.dto.StatusMessageDto;
import com.ecommerce.productcatalog.exception.NotFoundException;
import com.ecommerce.productcatalog.exception.ProductIsNullException;
import com.ecommerce.productcatalog.models.Product;
import com.ecommerce.productcatalog.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getProductById(Long id) {

        UUID uuid = UUID.randomUUID();
        Optional<Product> optionalProduct = productRepository.findById(uuid);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return Product.productToProductDTO(product);
        }
        return null;
    }


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product: productList) {
            productDtoList.add(Product.productToProductDTO(product));
        }
        return productDtoList;
    }

    @Override
    public StatusMessageDto deleteProductById(Long id) {
        UUID uuid = UUID.randomUUID();
        productRepository.deleteById(uuid);
        return new StatusMessageDto("Product is deleted Successfully", " for id " + id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = ProductDto.productDtoToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        ProductDto updatedProductDto = Product.productToProductDTO(savedProduct);
        return updatedProductDto;
    }


}
