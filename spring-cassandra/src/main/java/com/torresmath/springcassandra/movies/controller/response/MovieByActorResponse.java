package com.torresmath.springcassandra.movies.controller.response;

import com.torresmath.springcassandra.movies.model.MovieByActor;

import java.util.Set;

public class MovieByActorResponse {

    public MovieByActorResponse(String title, Set<String> genres, Integer ageRating) {
        this.title = title;
        this.genres = genres;
        this.ageRating = ageRating;
    }

    public final String title;
    public final Set<String> genres;
    public final Integer ageRating;

    public MovieByActorResponse(MovieByActor movieByActor) {
        this.title = movieByActor.getTitle();
        this.genres = movieByActor.getGenres();
        this.ageRating = movieByActor.getAgeRating();
    }
}
