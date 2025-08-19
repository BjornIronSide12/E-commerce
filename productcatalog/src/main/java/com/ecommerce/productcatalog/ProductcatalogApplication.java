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

	private static ProductRepository productRepository;
	private  static CategoryRepository categoryRepository;

	public ProductcatalogApplication(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductcatalogApplication.class, args);


		Category category = new Category("phones", new ArrayList<>());
		categoryRepository.save(category);
		Product product = new Product("iphone", "wow", "dj", category, 32);
		productRepository.save(product);
	}

}
