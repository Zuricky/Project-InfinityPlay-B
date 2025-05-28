package com.project_infinityplay.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Column(length = 1000)
    private String description;

    @PastOrPresent
    private LocalDate releaseDate;

    @Column(name = "cover_url")
    private String coverUrl;

    private double rating;

    private int metacritic;

    private List<String> platforms;
}