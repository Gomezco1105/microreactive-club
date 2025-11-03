package com.example.teams.controller;

import com.example.teams.controller.dto.TeamRequests;
import com.example.teams.model.Team;
import com.example.teams.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService service;

    public TeamController(TeamService service) { this.service = service; }

    @GetMapping
    public Flux<Team> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Mono<Team> byId(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public Mono<Team> create(@RequestBody @Valid TeamRequests.Create req) {
        return service.create(new Team(null, req.name(), req.city()));
    }

    @PutMapping("/{id}")
    public Mono<Team> update(@PathVariable Integer id, @RequestBody @Valid TeamRequests.Update req) {
        return service.update(id, new Team(null, req.name(), req.city()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}
