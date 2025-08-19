package com.ecommerce.productcatalog.service;

import com.ecommerce.productcatalog.dto.*;

import com.ecommerce.productcatalog.exception.NotFoundException;
import com.ecommerce.productcatalog.exception.ProductIsNullException;
import com.ecommerce.productcatalog.thirdpartyclient.fakestoreclient.FakeStoreClientImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

import static com.ecommerce.productcatalog.dto.FakeStoreDto.getProductDtoFromFakeStoreDto;
import static com.ecommerce.productcatalog.dto.FakeStoreMultipleProductsDto.getProductDtoFromFakeStoreMultipleProductDto;

/**
 * instead of calling fakestoreapi we are now using SimpleProductService to implement our logic
 */
//@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    private FakeStoreClientImpl fakeStoreClient;

    public FakeStoreProductServiceImpl(FakeStoreClientImpl fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }


    @Override
    public ProductDto getProductById(Long id) throws NotFoundException, ProductIsNullException {
        return fakeStoreClient.getProductById(id);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return fakeStoreClient.getAllProducts();
    }

    @Override
    public StatusMessageDto deleteProductById(Long id) {
        return fakeStoreClient.deleteProductById(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) throws NotFoundException{
        return fakeStoreClient.updateProduct(productDto);
    }
}
