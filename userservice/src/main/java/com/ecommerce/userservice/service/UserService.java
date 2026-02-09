package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.LoginRequestDto;
import com.ecommerce.userservice.dto.UserDto;

public interface UserService {

    UserDto signUp(UserDto userDto);

    String login(LoginRequestDto loginRequestDto);

    void logout(String token);
}
