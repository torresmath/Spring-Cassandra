package com.torresmath.springcassandra.movies.controller;

import com.torresmath.springcassandra.movies.model.Movie;
import com.torresmath.springcassandra.movies.model.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
public class DeleteMovieController {

    public DeleteMovieController(MovieRepository repository) {
        this.repository = repository;
    }

    private final MovieRepository repository;

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> delete(@PathVariable UUID movieId) {

        Optional<Movie> possibleMovie = repository.findById(movieId);

        if (possibleMovie.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(possibleMovie.get());

        return ResponseEntity.ok().build();
    }
}
