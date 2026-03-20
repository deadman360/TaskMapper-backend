package com.deadman.taskmapper.domain.auth.value_object;

public record Email(String address) {
    public Email {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("email cannot be null");
        }

        if (address.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("invalid email address");
        }

        address = address.toLowerCase().trim();

    }

}
