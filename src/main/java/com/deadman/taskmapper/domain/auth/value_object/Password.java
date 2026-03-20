package com.deadman.taskmapper.domain.auth.value_object;

public record Password(String hash) {
    public Password {
        if (hash == null || hash.isBlank()) {
            throw new IllegalArgumentException("password cannot be null");
        }
    }
}
