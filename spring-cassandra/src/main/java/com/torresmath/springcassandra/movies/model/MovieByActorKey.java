package com.torresmath.springcassandra.movies.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

@PrimaryKeyClass
public class MovieByActorKey {

    @PrimaryKeyColumn(name = "actor_name", type = PrimaryKeyType.PARTITIONED)
    private String actorName;

    @PrimaryKeyColumn(name = "movie_id", ordinal = 1, ordering = Ordering.DESCENDING)
    private UUID movieId;

    @PrimaryKeyColumn(name = "character_name", ordinal = 2, ordering = Ordering.ASCENDING)
    private String characterName;

    public MovieByActorKey(final String actorName, final UUID movieId, final String characterName) {
        this.actorName = actorName;
        this.movieId = movieId;
        this.characterName = characterName;
    }

    @Deprecated
    public MovieByActorKey() { }
}
