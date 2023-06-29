package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Genre;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);


    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countByCinemaId(Long id);


    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findByDateTimeAfter (LocalDateTime dateTime);


    //Write a derived query to find the top 3 expensive movies
     List<MovieCinema> findTop3ByOrderByMovie_PriceDesc();


    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovie_NameContaining (String name);


    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinema_Location_Name(String locationName);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime > ?1")
    List<MovieCinema> retrieveMovieCinemaDateTimeGreaterThan(LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT COUNT(*) FROM movie_cinema WHERE cinema_id = ?1", nativeQuery = true)
    Integer retrieveCountOfMovieCinemaByCinemaId(Long id);


    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT * FROM movie_cinema JOIN cinema ON movie_cinema.cinema_id = cinema.id JOIN location ON cinema.location_id=location.id WHERE location.name = ?1",
            nativeQuery = true)
    List<MovieCinema> retrieveMovieCinemaByLocation(String locationName);



}
