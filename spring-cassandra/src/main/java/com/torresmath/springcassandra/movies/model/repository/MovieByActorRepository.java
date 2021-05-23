package com.torresmath.springcassandra.movies.model.repository;

import com.torresmath.springcassandra.movies.model.MovieByActor;
import com.torresmath.springcassandra.movies.model.MovieByActorKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MovieByActorRepository extends CassandraRepository<MovieByActor, MovieByActorKey> {

    @Query(allowFiltering = true)
    List<MovieByActor> findByKeyMovieId(UUID id);

    List<MovieByActor> findByKeyActorName(String actorName);
}
