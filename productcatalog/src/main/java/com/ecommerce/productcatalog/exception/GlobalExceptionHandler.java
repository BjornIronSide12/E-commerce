package com.ecommerce.productcatalog.exception;

import com.ecommerce.productcatalog.dto.ExceptionHandleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionHandleDto> handleNotFoundException(NotFoundException notFoundException) {
        return new ResponseEntity<>(
                new ExceptionHandleDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    public ResponseEntity<ExceptionHandleDto> productNullExceptionHandler(ProductIsNullException productIsNullException) {
        return new ResponseEntity<>(
                new ExceptionHandleDto(HttpStatus.BAD_GATEWAY, productIsNullException.getMessage()),
                HttpStatus.BAD_GATEWAY
        );
    }
}
