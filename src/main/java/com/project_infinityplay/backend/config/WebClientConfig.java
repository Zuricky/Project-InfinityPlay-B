package com.project_infinityplay.backend.config;

import org.springframework.context.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient rawgClient() {
        return WebClient.builder()
                .baseUrl("https://api.rawg.io/api/")
                .defaultHeader("Accept", "application/json")
                .build();
    }
}