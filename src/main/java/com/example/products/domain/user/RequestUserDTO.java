package com.example.products.domain.user;

import jakarta.persistence.Enumerated;
import lombok.NonNull;

public record RequestUserDTO(
        @NonNull
        String name, String password, @Enumerated UserRole role) {
}
