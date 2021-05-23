package com.torresmath.springcassandra.movies.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;

@Table("movies_by_year")
public class MovieByYear {

    @PrimaryKey
    private MovieByYearKey key;

    @Column
    private String title;

    @Column
    private Set<String> genres;

    @Column("age_rating")
    private Integer ageRating;

    public MovieByYear(MovieByYearKey key, String title, Set<String> genres, Integer ageRating) {
        this.key = key;
        this.title = title;
        this.genres = genres;
        this.ageRating = ageRating;
    }
}
