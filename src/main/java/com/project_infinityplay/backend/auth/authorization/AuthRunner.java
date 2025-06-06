package com.project_infinityplay.backend.auth.authorization;

import com.project_infinityplay.backend.auth.app_user.AppUser;
import com.project_infinityplay.backend.auth.app_user.AppUserService;
import com.project_infinityplay.backend.auth.app_user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class AuthRunner implements ApplicationRunner {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<AppUser> adminUser = appUserService.findByUsername("admin");
        if (adminUser.isEmpty()) {
            appUserService.registerUser("admin@gmail.com", "admin", "adminpwd", Set.of(Role.ROLE_ADMIN));
        }

        Optional<AppUser> normalUser = appUserService.findByUsername("user");
        if (normalUser.isEmpty()) {
            appUserService.registerUser("user@gmail.com", "user", "userpwd", Set.of(Role.ROLE_USER));
        }

        Optional<AppUser> normalSeller = appUserService.findByUsername("seller");
        if (normalSeller.isEmpty()) {
            appUserService.registerUser("seller@gmail.com", "seller", "sellerpwd", Set.of(Role.ROLE_SELLER));
        }
    }
}
