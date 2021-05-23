package com.torresmath.springcassandra.movies.controller.response;

import com.torresmath.springcassandra.movies.model.Movie;

import java.time.LocalDate;
import java.util.Set;

public class MovieResponse {

    public final String title;
    public final Integer ageRating;
    public final Set<String> genres;
    public final LocalDate releaseDate;

    public MovieResponse(Movie movie) {

        this.title = movie.getTitle();
        this.ageRating = movie.getAgeRating();
        this.genres = movie.getGenres();
        this.releaseDate = movie.getReleaseDate();

    }
}
