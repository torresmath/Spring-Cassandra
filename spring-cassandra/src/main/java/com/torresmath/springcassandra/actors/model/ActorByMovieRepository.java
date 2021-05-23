package com.torresmath.springcassandra.actors.model;

import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ActorByMovieRepository extends CassandraRepository<ActorByMovie, ActorByMovieKey> {

    List<ActorByMovie> findByKeyMovieId(UUID uuid);
}
