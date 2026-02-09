package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.dto.LoginRequestDto;
import com.ecommerce.userservice.dto.UserDto;
import com.ecommerce.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    //Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testApi() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) {
        UserDto newUser = userService.signUp(userDto);
        // Returns HTTP 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        String username = userService.login(loginRequestDto);
        return ResponseEntity.ok(username + " has logged in");
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody String token) {
        userService.logout(token);
        return ResponseEntity.ok("logged out");
    }

}
