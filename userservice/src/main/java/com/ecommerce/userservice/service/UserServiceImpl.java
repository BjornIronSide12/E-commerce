package com.ecommerce.userservice.service;

import com.ecommerce.userservice.dto.LoginRequestDto;
import com.ecommerce.userservice.dto.UserDto;
import com.ecommerce.userservice.entity.LoginRequestEntity;
import com.ecommerce.userservice.entity.SessionEntity;
import com.ecommerce.userservice.entity.UserEntity;
import com.ecommerce.userservice.repository.SessionRepository;
import com.ecommerce.userservice.utility.mapper.DtoEntityMapper;
import com.ecommerce.userservice.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SessionService sessionService;

    public UserServiceImpl(UserRepository userRepository, SessionService sessionService) {
        this.userRepository = userRepository;
        this.sessionService =  sessionService;
    }
    @Override
    public UserDto signUp(UserDto userDto) {
        UserEntity savedUser = userRepository.save(DtoEntityMapper.userDtoToEntity(userDto));
        // call session service
        sessionService.createSession(savedUser);
        // to avoid sending password, we have created a new Dto
        UserDto savedUserDto = DtoEntityMapper.userEntityToDto(savedUser);

        return savedUserDto;
    }

    @Override
    public String login(LoginRequestDto loginRequestDto) {
        LoginRequestEntity loginRequest = DtoEntityMapper.loginRequestDtoToEntity(loginRequestDto);

        UserEntity user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));
        // call session service
        sessionService.createSession(user);
        return user.getFirstName()+" "+user.getLastName();
    }

    @Override
    public void logout(String token) {
        // remove the session
        sessionService.deleteSession(token);
    }
}
