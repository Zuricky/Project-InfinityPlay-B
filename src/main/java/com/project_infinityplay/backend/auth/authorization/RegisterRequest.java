package com.project_infinityplay.backend.auth.authorization;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String username;
    private String password;

    public RegisterRequest(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
