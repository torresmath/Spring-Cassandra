package com.torresmath.springcassandra.actors.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("actors_by_movie")
public class ActorByMovie {

    @PrimaryKey
    private ActorByMovieKey key;

    public ActorByMovie(final ActorByMovieKey key) {
        this.key = key;
    }
}
