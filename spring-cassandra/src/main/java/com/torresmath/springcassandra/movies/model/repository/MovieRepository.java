package com.torresmath.springcassandra.movies.model.repository;

import com.torresmath.springcassandra.movies.model.Movie;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface MovieRepository extends CassandraRepository<Movie, UUID> {
}
