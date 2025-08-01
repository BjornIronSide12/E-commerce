package com.ecommerce.productcatalog.thirdpartyclient.fakestoreclient;

import com.ecommerce.productcatalog.dto.*;
import com.ecommerce.productcatalog.exception.NotFoundException;
import com.ecommerce.productcatalog.exception.ProductIsNullException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static com.ecommerce.productcatalog.dto.FakeStoreDto.getProductDtoFromFakeStoreDto;
import static com.ecommerce.productcatalog.dto.FakeStoreMultipleProductsDto.getProductDtoFromFakeStoreMultipleProductDto;

@Component
public class FakeStoreClientImpl implements ProductClient{

    private final WebClient webClient;

    public FakeStoreClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }


    @Override
    public ProductDto getProductById(Long id) throws NotFoundException, ProductIsNullException {
        /* .uri(String uri, Object... var) ==> values of path variables which are passed in uri {var1}/{var2}
            must be explicitly mentioned after ','
           */

        // calling fakestore api by using webclient
        Mono<FakeStoreDto> fakeStoreDtoMono = webClient.get()
                .uri("/{id}", id) // passed id will be fetched inside -- > {id}
                .retrieve().bodyToMono(FakeStoreDto.class);
        FakeStoreDto fakeStoreDto = fakeStoreDtoMono.block();
        // if fakestore is null
        if(fakeStoreDto == null) {
            throw new ProductIsNullException("We got null response for id: " + id);
        }
        // fakestore returns 149 id by default if id does not exists
        // hence if fakestore.id != id, then the id that we sent is not found
        if(!id.equals(fakeStoreDto.getProduct().getId())) {
            throw new NotFoundException("Product with id: " + fakeStoreDto.getProduct().getId() + " is not found");
        }

        return getProductDtoFromFakeStoreDto(fakeStoreDto);
    }

    @Override
    public List<ProductDto> getAllProducts() {

        // calling fakestore api by using webclient
        Mono<FakeStoreMultipleProductsDto> fakeStoreDtoMono = webClient.get().uri("?limit=5")
                .retrieve().bodyToMono(FakeStoreMultipleProductsDto.class);

        List<ProductDto> productDtoList = new ArrayList<>();

        FakeStoreMultipleProductsDto fakeStoreDtos = fakeStoreDtoMono.block();

        return getProductDtoFromFakeStoreMultipleProductDto(fakeStoreDtos);

    }

    @Override
    public StatusMessageDto deleteProductById(Long id) {

        // calling fakestore api by using webclient
        Mono<StatusMessageDto> statusMessageDtoMono = webClient.delete().uri("/{id}", id)
                .retrieve().bodyToMono(StatusMessageDto.class);

        StatusMessageDto statusMessageDto = statusMessageDtoMono.block();
        return statusMessageDto == null ?
                new StatusMessageDto("Not found", "Unable to get any response from fakestore delete api") :
                statusMessageDto;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) throws NotFoundException{
        UpdateProductDto updateProductDto = ProductDto.getUpdateProductDtoFromProductDto(productDto);
        Mono<FakeStoreDto> fakeStoreDtoMono= webClient.put().uri("/{id}", updateProductDto.getId())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(updateProductDto)).retrieve().bodyToMono(FakeStoreDto.class);

        FakeStoreDto fakeStoreDto = fakeStoreDtoMono.block();

        // handling null response
        if(fakeStoreDto == null || !fakeStoreDto.getProduct().getId().equals(productDto.getId())) {
            throw new NotFoundException("Product with id: " + productDto.getId() + " is not found");
        }
        return getProductDtoFromFakeStoreDto(fakeStoreDto);
    }
}
