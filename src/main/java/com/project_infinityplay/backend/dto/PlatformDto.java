package com.project_infinityplay.backend.dto;

import lombok.Data;

@Data
public class PlatformDto {
    private PlatformDetail platform;

    @Data
    public static class PlatformDetail {
        private String name;
    }
}