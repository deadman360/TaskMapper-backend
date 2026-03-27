package com.deadman.taskmapper.domain.auth.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @NotEmpty(message = "email is mandatory") String email,
        @NotEmpty(message = "password is mandatory") String password) {
}
