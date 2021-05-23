package com.torresmath.springcassandra.movies.model.repository;

import com.torresmath.springcassandra.movies.model.MovieByYear;
import com.torresmath.springcassandra.movies.model.MovieByYearKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface MovieByYearRepository extends CassandraRepository<MovieByYear, MovieByYearKey> {

    @Query(allowFiltering = true)
    List<MovieByYear> findByKeyYearAndKeyReleaseDateAndKeyMovieId(int year, LocalDate releaseDate, UUID id);
}
