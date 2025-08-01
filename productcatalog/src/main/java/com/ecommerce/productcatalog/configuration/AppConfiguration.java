package com.ecommerce.productcatalog.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfiguration {

    final String productBaseUrl = "https://fakestoreapi.in/api/products";

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(productBaseUrl)
                .build();
    }
}
