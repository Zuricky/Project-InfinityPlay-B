package com.project_infinityplay.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {
    @GetMapping("/api/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Backend up and running");
    }
}