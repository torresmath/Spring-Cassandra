package com.torresmath.springcassandra.movies.model;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Table("movies")
public class Movie {

    @PrimaryKey(value = "movie_id")
    private UUID id;

    @Column("release_date")
    private LocalDate releaseDate;

    @Column
    private String title;

    @Column
    private Set<String> genres;

    @Column("age_rating")
    private Integer ageRating;

    @Transient private List<Role> roles;

    public Movie(LocalDate releaseDate, String title, Set<String> genres, Integer ageRating, List<Role> roles) {
        this.id = UUID.randomUUID();
        this.releaseDate = releaseDate;
        this.title = title;
        this.genres = genres;
        this.ageRating = ageRating;
        this.roles = roles;
    }

    public Movie() {
    }

    public List<Role> getRoles() {
        return roles;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public UUID getId() {
        return id;
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


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", releaseDate=" + releaseDate +
                ", title='" + title + '\'' +
                ", genres=" + genres +
                ", ageRating='" + ageRating + '\'' +
                ", roles=" + roles +
                '}';
    }
}
