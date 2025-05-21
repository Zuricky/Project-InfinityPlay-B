package com.project_infinityplay.backend.controller;

import com.project_infinityplay.backend.model.Game;
import com.project_infinityplay.backend.service.RawgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {
    private final RawgService rawgService;

    public GameController(RawgService rawgService) {
        System.out.println("🔹 GameController caricato!");
        this.rawgService = rawgService;
    }

    @Operation(summary = "List games with pagination and optional search")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters")
    })
    @GetMapping
    public List<Game> listAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(required = false) String search) {
        return rawgService.fetchGames(page, size, search);
    }

    @Operation(summary = "Get game detail by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Game found"),
            @ApiResponse(responseCode = "404", description = "Game not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Game> getOne(@PathVariable Long id) {
        Optional<Game> opt = rawgService.fetchGameById(id);
        return opt.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));
    }
}