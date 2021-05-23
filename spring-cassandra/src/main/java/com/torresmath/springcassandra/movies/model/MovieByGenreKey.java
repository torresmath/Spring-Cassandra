package com.torresmath.springcassandra.movies.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.LocalDate;
import java.util.UUID;

@PrimaryKeyClass
public class MovieByGenreKey {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String genre;

    @PrimaryKeyColumn(value = "release_date", ordinal = 0, ordering = Ordering.DESCENDING)
    private LocalDate releaseDate;

    @PrimaryKeyColumn(value = "movie_id", ordinal = 1, ordering = Ordering.ASCENDING)
    private UUID movieId;

    public MovieByGenreKey(String genre, LocalDate releaseDate, UUID movieId) {
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.movieId = movieId;
    }
}
