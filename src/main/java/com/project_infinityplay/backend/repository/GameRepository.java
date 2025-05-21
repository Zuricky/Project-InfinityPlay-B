package com.project_infinityplay.backend.repository;

import com.project_infinityplay.backend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}