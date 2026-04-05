package com.deadman.taskmapper.service;

import com.deadman.taskmapper.domain.auth.User;
import com.deadman.taskmapper.domain.auth.dto.request.LoginRequest;
import com.deadman.taskmapper.domain.auth.dto.request.RegisterUserRequest;
import com.deadman.taskmapper.domain.auth.dto.response.LoginResponse;
import com.deadman.taskmapper.domain.auth.dto.response.RegisterUserResponse;
import com.deadman.taskmapper.infrastructure.config.TokenConfig;
import com.deadman.taskmapper.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public LoginResponse login(LoginRequest request) {
        UsernamePasswordAuthenticationToken userAndPassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPassword);
        User user = (User) authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);
        return new LoginResponse(token);
    }

    public RegisterUserResponse registerUser(RegisterUserRequest request){
        User newUser = new User();
        newUser.setName(request.name());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(newUser);

        return new RegisterUserResponse(newUser.getName(), newUser.getEmail());
    }
}
