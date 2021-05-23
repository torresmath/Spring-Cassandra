package com.torresmath.springcassandra.actors.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.LocalDate;
import java.util.UUID;

@PrimaryKeyClass
public class ActorByMovieKey {

    @PrimaryKeyColumn(name = "movie_id", type = PrimaryKeyType.PARTITIONED)
    private UUID movieId;

    @PrimaryKeyColumn(name = "release_date", ordinal = 0, ordering = Ordering.DESCENDING)
    private LocalDate releaseDate;

    @PrimaryKeyColumn(name = "actor_name", ordinal = 1, ordering = Ordering.ASCENDING)
    private String actorName;

    @PrimaryKeyColumn(name = "character_name", ordinal = 2, ordering = Ordering.ASCENDING)
    private String characterName;

    public ActorByMovieKey(UUID movieId, LocalDate releaseDate, String actorName, String characterName) {
        this.movieId = movieId;
        this.releaseDate = releaseDate;
        this.actorName = actorName;
        this.characterName = characterName;
    }
}
