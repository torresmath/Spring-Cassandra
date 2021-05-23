package com.torresmath.springcassandra.movies.controller;

import com.torresmath.springcassandra.movies.controller.request.MovieRequest;
import com.torresmath.springcassandra.movies.controller.response.MovieResponse;
import com.torresmath.springcassandra.movies.model.Movie;
import com.torresmath.springcassandra.movies.model.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    private final MovieRepository repository;

    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody MovieRequest request) {

        Movie movie = request.toMovie();

        repository.insert(movie);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieResponse> retrieve(@PathVariable UUID movieId) {

        Optional<Movie> possibleMovie = repository.findById(movieId);

        if (possibleMovie.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new MovieResponse(possibleMovie.get()));

    }
}
