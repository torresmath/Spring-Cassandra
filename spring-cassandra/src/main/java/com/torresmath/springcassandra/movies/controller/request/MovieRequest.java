package com.torresmath.springcassandra.movies.controller.request;

import com.torresmath.springcassandra.movies.model.Movie;
import com.torresmath.springcassandra.movies.model.Role;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class MovieRequest {

    public final LocalDate releaseDate;
    public final String title;
    public final Set<String> genres;
    public final Integer ageRating;
    public final List<Role> roles;

    public MovieRequest(LocalDate releaseDate, String title, Set<String> genres, Integer ageRating, List<Role> roles) {
        this.releaseDate = releaseDate;
        this.title = title;
        this.genres = genres;
        this.ageRating = ageRating;
        this.roles = roles;
    }

    public Movie toMovie() {
        return new Movie(this.releaseDate, this.title, this.genres, this.ageRating, this.roles);
    }
}
