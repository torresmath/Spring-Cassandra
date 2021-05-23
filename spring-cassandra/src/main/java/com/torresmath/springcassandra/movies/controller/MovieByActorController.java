package com.torresmath.springcassandra.movies.controller;

import com.torresmath.springcassandra.movies.controller.response.MovieByActorResponse;
import com.torresmath.springcassandra.movies.model.MovieByActor;
import com.torresmath.springcassandra.movies.model.repository.MovieByActorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
public class MovieByActorController {

    public MovieByActorController(MovieByActorRepository repository) {
        this.repository = repository;
    }

    private final MovieByActorRepository repository;

    @GetMapping
    public ResponseEntity<List<MovieByActorResponse>> retrieve(@RequestParam("actor") String actorName) {

        List<MovieByActor> possibleMovie = repository.findByKeyActorName(actorName);

        if (possibleMovie.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<MovieByActorResponse> movies = possibleMovie.stream()
                .map(MovieByActorResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(movies);
    }
}
