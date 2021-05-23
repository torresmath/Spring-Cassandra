package com.torresmath.springcassandra.movies.model.repository;

import com.torresmath.springcassandra.movies.model.MovieByGenre;
import com.torresmath.springcassandra.movies.model.MovieByGenreKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface MovieByGenreRepository extends CassandraRepository<MovieByGenre, MovieByGenreKey> {

    @Query(allowFiltering = true)
    List<MovieByGenre> findByKeyGenreAndKeyReleaseDateAndKeyMovieId(String g, LocalDate releaseDate, UUID id);
}
