package com.ecommerce.productcatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionHandleDto {
    HttpStatus status;
    String message;
}
