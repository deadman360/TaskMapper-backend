package com.deadman.taskmapper.domain.auth.interfaces;

import com.deadman.taskmapper.domain.auth.dto.request.RegisterUserRequest;
import com.deadman.taskmapper.domain.auth.dto.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse RegisterUser(RegisterUserRequest request);
}
