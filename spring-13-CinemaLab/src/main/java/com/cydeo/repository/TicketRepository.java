package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Movie;
import com.cydeo.entity.Ticket;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    int countTicketsByUserAccountId(Long userId);


    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccount_Email(String email);


    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinema_Movie_Name(String movieName);


    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween (LocalDateTime dateTime, LocalDateTime dateTime2);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount = ?1")
    List<Ticket> retrieveByUser(User user);


    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> retrieveByDateTimeRangeBetween(LocalDateTime dateTime, LocalDateTime dateTime2);



    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1", nativeQuery = true)
    Integer countAllTicketsByUserAccount(@Param("userId") Long userId);


    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1 and date_time BETWEEN ?2 and ?3", nativeQuery = true)
    Integer countTicketsByUserDateRangeBetween(User user, LocalDateTime dateTime, LocalDateTime dateTime2);

    //Write a native query to distinct all tickets by movie name
 @Query(value = "SELECT DISTINCT (m.name) FROM ticket t join movie_cimema mc" +
         "on mc.id = t.movie_cinema_id join movie m on m.id = mc.movie_id", nativeQuery = true)
    List<String> retrieveAllDistinctMovieNames();


    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket JOIN user_account on ticket.user_account_id=user_account.id WHERE user_account.email = ?1",
    nativeQuery = true)
    List<Ticket> retrieveTicketsByUserEmail(String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> retrieveAllTickets();


    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua on t.user_account_id=ua.id join movie_cimema mc" +
            " on mc.id = t.movie_cinema_id join movie m on m.id = mc.movie_id join account_details ad on ad.id = ua.account_details_id " +
            " WHERE  ua.username ILIKE concat('%',?1,'%') OR ad.name ILIKE concat('%',?1,'%') OR m.name ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<Ticket> retrieveAllTicketsWithSpecificValue( String value);

}
