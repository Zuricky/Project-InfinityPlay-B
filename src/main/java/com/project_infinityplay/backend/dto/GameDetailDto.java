package com.project_infinityplay.backend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class GameDetailDto {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private LocalDate releaseDate;
    private String coverUrl;
    private Double rating;
    private Integer metacritic;
    private List<String> genres;
    private List<String> platforms;
}