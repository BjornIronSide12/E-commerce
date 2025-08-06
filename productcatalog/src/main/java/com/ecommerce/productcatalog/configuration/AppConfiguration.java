package com.ecommerce.productcatalog.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfiguration {

    @Value("${fakestore.api.baseurl}")
    String fakeStoreUrl;
    @Value("${fakestore.api.product}")
    String fakeStoreProductUrl;
    @Bean
    public WebClient webClient() {
        String productBaseUrl = fakeStoreUrl+fakeStoreProductUrl;
        System.out.println(productBaseUrl);
        return WebClient.builder()
                .baseUrl(productBaseUrl)
                .build();
    }
}
