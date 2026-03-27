package com.deadman.taskmapper.controller;

import com.deadman.taskmapper.domain.auth.dto.request.LoginRequest;
import com.deadman.taskmapper.domain.auth.dto.request.RegisterUserRequest;
import com.deadman.taskmapper.domain.auth.dto.response.LoginResponse;
import com.deadman.taskmapper.domain.auth.dto.response.RegisterUserResponse;
import com.deadman.taskmapper.domain.auth.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return null;
    }

    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.RegisterUser(request));
    }
}
