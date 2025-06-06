package com.project_infinityplay.backend.auth.authorization;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
