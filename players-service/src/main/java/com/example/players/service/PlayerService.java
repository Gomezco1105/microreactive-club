package com.example.players.service;

import com.example.players.model.Player;
import com.example.players.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerService {
    private final PlayerRepository repo;

    public PlayerService(PlayerRepository repo) { this.repo = repo; }

    public Flux<Player> all() { return repo.findAll(); }
    public Mono<Player> byId(Integer id) { return repo.findById(id); }
    public Flux<Player> byTeam(Integer teamId) { return repo.findByTeamId(teamId); }
    public Mono<Player> create(Player p) { return repo.save(p); }
    public Mono<Player> update(Integer id, Player p) {
        return repo.findById(id).flatMap(old -> repo.save(new Player(id, p.fullName(), p.position(), p.teamId())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}
