package com.ecommerce.userservice.utility.mapper;

import com.ecommerce.userservice.dto.LoginRequestDto;
import com.ecommerce.userservice.dto.UserDto;
import com.ecommerce.userservice.entity.LoginRequestEntity;
import com.ecommerce.userservice.entity.UserEntity;

public interface DtoEntityMapper {

    // Java compiles it as this: as public static User
    // in case of interface, if we don't speficy any modifier it is "public"
    static UserEntity userDtoToEntity(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }

    static UserDto userEntityToDto(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }

    static LoginRequestEntity loginRequestDtoToEntity(LoginRequestDto loginRequestDto) {
        LoginRequestEntity loginRequestEntity = new LoginRequestEntity();
        loginRequestEntity.setPassword(loginRequestDto.getPassword());
        loginRequestEntity.setEmail(loginRequestDto.getEmail());
        return loginRequestEntity;
    }

//    static LoginRequestDto loginRequestEntityToDto(LoginRequestEntity loginRequestEntity) {
//
//        LoginRequestDto loginRequestDto = new LoginRequestDto();
//        loginRequestDto.setEmail(loginRequestEntity.getEmail());
//        return loginRequestDto;
//    }
}
