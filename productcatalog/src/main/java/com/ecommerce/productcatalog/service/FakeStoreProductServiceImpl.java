package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.FakeStoreDto;
import com.ecommerce.productcatalog.dto.ProductDto;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import static com.ecommerce.productcatalog.dto.FakeStoreDto.getProductDtoFromFakeStoreDto;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private final WebClient webClient;

    public FakeStoreProductServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }


    @Override
    public ProductDto getProductById(Long id) {
        Mono<FakeStoreDto> fakeStoreDtoMono = webClient.get()
                .uri("products/{id}", id) // passed id will be fetched inside -- > {id}
                .retrieve().bodyToMono(FakeStoreDto.class);
        /* .uri(String uri, Object... var) ==> values of path variables which are passed in uri {var1}/{var2}
            must be explicitly mentioned after ','
           */
        FakeStoreDto fakeStoreDto = fakeStoreDtoMono.block();

        ProductDto productDto = getProductDtoFromFakeStoreDto(fakeStoreDto);

        return productDto;
//        return new ProductDto();
    }
}
