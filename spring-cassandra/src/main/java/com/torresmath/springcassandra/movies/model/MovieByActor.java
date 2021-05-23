package com.torresmath.springcassandra.movies.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.Set;

@Table("movies_by_actor")
public class MovieByActor {

    @PrimaryKey
    private MovieByActorKey key;

    @Column
    private String title;

    @Column
    private Set<String> genres;

    @Column("age_rating")
    private Integer ageRating;

    @Column("release_date")
    private LocalDate releaseDate;

    public MovieByActor(MovieByActorKey key, String title, Set<String> genres, Integer ageRating, LocalDate releaseDate) {
        this.key = key;
        this.title = title;
        this.genres = genres;
        this.ageRating = ageRating;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public Integer getAgeRating() {
        return ageRating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
