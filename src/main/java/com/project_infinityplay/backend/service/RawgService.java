package com.project_infinityplay.backend.service;

import com.project_infinityplay.backend.dto.*;
import com.project_infinityplay.backend.model.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RawgService {

    private final WebClient webClient;
    private final String apiKey;

    public RawgService(WebClient rawgClient,
                       @Value("${rawg.api.key}") String apiKey) {
        this.webClient = rawgClient;
        this.apiKey = apiKey;
    }

    @Cacheable("games-list")
    public List<Game> fetchGames(int page, int pageSize, String search) {
        RawgResponse resp = webClient.get()
                .uri(uri -> uri.path("/games")
                        .queryParam("key", apiKey)
                        .queryParam("page", page)
                        .queryParam("page_size", pageSize)
                        .queryParamIfPresent("search", Optional.ofNullable(search))
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        clientResponse -> Mono.error(new ResponseStatusException(clientResponse.statusCode())))
                .bodyToMono(RawgResponse.class)
                .block();
        return resp.getResults().stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Cacheable("game-detail")
    public Optional<Game> fetchGameById(Long id) {
        RawgGameDto dto = webClient.get()
                .uri(uri -> uri.path("/games/{id}")
                        .queryParam("key", apiKey)
                        .build(id))
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.empty())
                .onStatus(HttpStatusCode::is5xxServerError,
                        clientResponse -> Mono.error(new ResponseStatusException(clientResponse.statusCode())))
                .bodyToMono(RawgGameDto.class)
                .block();
        return dto == null ? Optional.empty() : Optional.of(toEntity(dto));
    }

    private Game toEntity(RawgGameDto dto) {
        Game g = new Game();
        g.setId(dto.getId());
        g.setTitle(dto.getName());
        g.setDescription("Description from RAWG");
        if (dto.getReleased() != null) {
            g.setReleaseDate(LocalDate.parse(dto.getReleased()));
        }
        g.setCoverUrl(dto.getBackgroundImage());
        double price = 10 + Math.random() * 50;
        g.setPrice(BigDecimal.valueOf(Math.round(price * 100) / 100.0));
        return g;
    }
}