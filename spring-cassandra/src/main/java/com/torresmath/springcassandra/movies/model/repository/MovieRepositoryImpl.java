package com.torresmath.springcassandra.movies.model.repository;

import com.torresmath.springcassandra.actors.model.ActorByMovie;
import com.torresmath.springcassandra.actors.model.ActorByMovieKey;
import com.torresmath.springcassandra.actors.model.ActorByMovieRepository;
import com.torresmath.springcassandra.movies.model.*;
import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;

import java.util.UUID;

public class MovieRepositoryImpl extends SimpleCassandraRepository<Movie, UUID> implements MovieRepository {

    private final CassandraTemplate cassandraTemplate;
    private final MovieByActorRepository movieByActorRepository;
    private final MovieByGenreRepository movieByGenreRepository;
    private final MovieByYearRepository movieByYearRepository;
    private final ActorByMovieRepository actorByMovieRepository;

    public MovieRepositoryImpl(final CassandraEntityInformation<Movie, UUID> metadata,
                               final CassandraTemplate cassandraTemplate,
                               final MovieByActorRepository movieByActorRepository,
                               final MovieByGenreRepository movieByGenreRepository,
                               final MovieByYearRepository movieByYearRepository,
                               final ActorByMovieRepository actorByMovieRepository) {
        super(metadata, cassandraTemplate);
        this.cassandraTemplate = cassandraTemplate;
        this.movieByActorRepository = movieByActorRepository;
        this.movieByGenreRepository = movieByGenreRepository;
        this.movieByYearRepository = movieByYearRepository;
        this.actorByMovieRepository = actorByMovieRepository;
    }

    @Override
    public <S extends Movie> S insert(final S movie) {
        CassandraBatchOperations batchOps = cassandraTemplate.batchOps();
        insertByActor(movie, batchOps);
        insertByGenre(movie, batchOps);
        insertByYear(movie, batchOps);
        batchOps.insert(movie);
        batchOps.execute();
        return movie;
    }

    // region insert batch
    private void insertByActor(final Movie movie, final CassandraBatchOperations batchOps) {
        movie.getRoles()
                .forEach(
                        role -> {
                            MovieByActor movieByActor = new MovieByActor(
                                    new MovieByActorKey(
                                            role.getActorName(),
                                            movie.getId(),
                                            role.getCharacterName()
                                    ),
                                    movie.getTitle(),
                                    movie.getGenres(),
                                    movie.getAgeRating(),
                                    movie.getReleaseDate());
                            batchOps.insert(movieByActor);

                            ActorByMovie actorByMovie = new ActorByMovie(
                                    new ActorByMovieKey(movie.getId(),
                                            movie.getReleaseDate(),
                                            role.getActorName(),
                                            role.getCharacterName()));
                            batchOps.insert(actorByMovie);
                        }
                );
    }
    private void insertByGenre(final Movie movie, final CassandraBatchOperations batchOps) {
        movie
                .getGenres()
                .forEach(
                        g ->
                                batchOps.insert(
                                        new MovieByGenre(
                                                new MovieByGenreKey(g, movie.getReleaseDate(), movie.getId()),
                                                movie.getTitle(),
                                                movie.getGenres(),
                                                movie.getAgeRating())));
    }
    private void insertByYear(final Movie movie, final CassandraBatchOperations batchOps) {
        batchOps.insert(
                new MovieByYear(
                        new MovieByYearKey(
                                movie.getReleaseDate().getYear(), movie.getReleaseDate(), movie.getId()),
                        movie.getTitle(),
                        movie.getGenres(),
                        movie.getAgeRating()));
    }
    // endregion


    @Override
    public void delete(Movie movie) {
        CassandraBatchOperations batchOps = cassandraTemplate.batchOps();
        deleteByActor(movie, batchOps);
        deleteByGenre(movie, batchOps);
        deleteByYear(movie, batchOps);
        batchOps.delete(movie);
        batchOps.execute();
    }

    private void deleteByActor(final Movie movie, CassandraBatchOperations batchOps) {
        batchOps.delete(
                movieByActorRepository.findByKeyMovieId(movie.getId()));
        batchOps.delete(actorByMovieRepository.findByKeyMovieId(movie.getId()));
    }

    private void deleteByGenre(final Movie movie, final CassandraBatchOperations batchOps) {
        movie
                .getGenres()
                .forEach(
                        g ->
                                batchOps.delete(
                                        movieByGenreRepository.findByKeyGenreAndKeyReleaseDateAndKeyMovieId(
                                                g, movie.getReleaseDate(), movie.getId())));
    }

    private void deleteByYear(final Movie movie, final CassandraBatchOperations batchOps) {
        batchOps.delete(
                movieByYearRepository.findByKeyYearAndKeyReleaseDateAndKeyMovieId(
                        movie.getReleaseDate().getYear(), movie.getReleaseDate(), movie.getId()));
    }
}
