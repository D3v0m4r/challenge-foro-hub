package com.example.foro.hub.user;

public record UserDTO(
        String name,
        String username,
        String password,
        Boolean enable
) {
}
