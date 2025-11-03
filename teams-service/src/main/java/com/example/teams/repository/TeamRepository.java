package com.example.teams.repository;

import com.example.teams.model.Team;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TeamRepository extends ReactiveCrudRepository<Team, Integer> {}
