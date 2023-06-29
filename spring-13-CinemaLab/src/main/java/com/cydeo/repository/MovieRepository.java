package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findByName(String name);


    //Write a derived query to list all movies between a range of prices
    List<Movie> findByPriceBetween(BigDecimal price1, BigDecimal price2);


    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> existsByDurationIn(List<Integer> durations);



    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findByReleaseDateAfter(LocalDate date);


    //Write a derived query to list all movies with a specific state and type
    List<Movie> findByStateAndType (MovieState movieState, MovieType movieType);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
    Movie retrieveByPriceBetweenTheRange(BigDecimal price1, BigDecimal price2);


    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m")
    List<Movie> retrieveAllMovieNames();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT name FROM movie WHERE name = ?1", nativeQuery = true)
    Movie retrieveMovieByName(String name);


    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2", nativeQuery = true)
    Movie retrieveMovieByPriceRangeBetween(BigDecimal price1, BigDecimal price2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "SELECT * FROM movie WHERE duration BETWEEN ?1 AND ?2", nativeQuery = true)
    Movie retrieveMovieByDurationBetween(Integer duration1, Integer duration2);

    //Write a native query to list the top 5 most expensive movies
    @Query(value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5", nativeQuery = true)
    List<Movie> retrieveTop5MoviesByPrice();


}
