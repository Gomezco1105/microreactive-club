package com.example.players.repository;

import com.example.players.model.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PlayerRepository extends ReactiveCrudRepository<Player, Integer> {
    Flux<Player> findByTeamId(Integer teamId);
}
