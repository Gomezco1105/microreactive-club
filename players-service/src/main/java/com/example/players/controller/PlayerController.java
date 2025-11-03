package com.example.players.controller;

import com.example.players.controller.dto.PlayerRequests;
import com.example.players.model.Player;
import com.example.players.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService service) { this.service = service; }

    @GetMapping
    public Flux<Player> all() { return service.all(); }

    @GetMapping("/{id}")
    public Mono<Player> byId(@PathVariable Integer id) { return service.byId(id); }

    @GetMapping("/team/{teamId}")
    public Flux<Player> byTeam(@PathVariable Integer teamId) { return service.byTeam(teamId); }

    @PostMapping
    public Mono<Player> create(@RequestBody @Valid PlayerRequests.Create req) {
        return service.create(new Player(null, req.fullName(), req.position(), req.teamId()));
    }

    @PutMapping("/{id}")
    public Mono<Player> update(@PathVariable Integer id, @RequestBody @Valid PlayerRequests.Update req) {
        return service.update(id, new Player(null, req.fullName(), req.position(), req.teamId()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}
