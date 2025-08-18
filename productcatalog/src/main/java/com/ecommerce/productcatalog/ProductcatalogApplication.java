package com.ecommerce.productcatalog;

import com.ecommerce.productcatalog.models.Category;
import com.ecommerce.productcatalog.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductcatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogApplication.class, args);
	}

	Category category = new Category();
	Product product = new Product("iphone", "wow", "dj", new Category(), 32);

}
