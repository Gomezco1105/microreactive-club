package com.example.teams.service;

import com.example.teams.model.Team;
import com.example.teams.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TeamService {
    private final TeamRepository repo;

    public TeamService(TeamRepository repo) {
        this.repo = repo;
    }

    public Flux<Team> findAll() { return repo.findAll(); }
    public Mono<Team> findById(Integer id) { return repo.findById(id); }
    public Mono<Team> create(Team t) { return repo.save(t); }
    public Mono<Team> update(Integer id, Team t) {
        return repo.findById(id)
            .flatMap(old -> repo.save(new Team(id, t.name(), t.city())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}
