package com.project_infinityplay.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class RawgGameDto {
    private Long id;
    @JsonProperty("name")
    private String name;
    private String released;
    @JsonProperty("background_image")
    private String backgroundImage;
    private Double rating;
    private Integer metacritic;
    private List<GenreDto> genres;
    private List<PlatformDto> platforms;
}