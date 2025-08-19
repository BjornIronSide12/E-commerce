package com.ecommerce.productcatalog.models;

import com.ecommerce.productcatalog.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{

    private String title;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
    private double price;

    public static ProductDto productToProductDTO(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImage());
        productDto.setCategory(product.getCategory());
        productDto.setPrice(product.getPrice());

        return productDto;
    }
}
