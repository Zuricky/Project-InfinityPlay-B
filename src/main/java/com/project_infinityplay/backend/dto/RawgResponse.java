package com.project_infinityplay.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class RawgResponse {
    private List<RawgGameDto> results;
    private String next;
    private String previous;
}