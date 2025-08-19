package com.ecommerce.productcatalog;

import com.ecommerce.productcatalog.models.Category;
import com.ecommerce.productcatalog.models.Product;
import com.ecommerce.productcatalog.repository.CategoryRepository;
import com.ecommerce.productcatalog.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ProductcatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogApplication.class, args);
	}

}
