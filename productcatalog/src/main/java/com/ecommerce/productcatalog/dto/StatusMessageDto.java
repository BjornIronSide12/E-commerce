package com.ecommerce.productcatalog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusMessageDto {
    String status;
    String message;

// review this
    public StatusMessageDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
