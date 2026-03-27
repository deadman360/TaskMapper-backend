package com.deadman.taskmapper.domain.auth.service;

import com.deadman.taskmapper.domain.auth.dto.request.RegisterUserRequest;
import com.deadman.taskmapper.domain.auth.dto.response.RegisterUserResponse;
import com.deadman.taskmapper.domain.auth.entity.User;
import com.deadman.taskmapper.domain.auth.interfaces.UserService;
import com.deadman.taskmapper.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserResponse RegisterUser(RegisterUserRequest request){
        User newUser = new User();
        newUser.setName(request.name());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(newUser);

        return new RegisterUserResponse(newUser.getName(), newUser.getEmail());
    }
}
