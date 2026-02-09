package com.ecommerce.userservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestEntity extends BaseEntity {
    private String email;
    private String password;
}
