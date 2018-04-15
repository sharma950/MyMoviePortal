package com.mymovieportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mymovieportal.model.SeatBooking;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeatBookingRepository.
 */
public interface SeatBookingRepository extends JpaRepository<SeatBooking, Integer> {

    /**
     * Find by sb user id.
     *
     * @param sbUserId the sb user id
     * @return the seat booking[]
     */
    SeatBooking[] findBySbUserId(long sbUserId);

    /**
     * Cancel ticket.
     *
     * @param userid the userid
     * @param date the date
     * @param time the time
     * @return the seat booking[]
     */
    @Query("Select sb from SeatBooking sb where sbUserId = :userid and sbDate >= :date "
        + "and sbShowTime > :time and sbStatus='booked'")
    SeatBooking[] cancelTicket(@Param("userid") long userid, @Param("date") String date,@Param("time") String time);

    /**
     * Go to cancel ticket.
     *
     * @param seatbookingid the seatbookingid
     * @return the int
     */
    @Modifying
    @Query("update SeatBooking set sbStatus='cancel' where seatBookingId=:seatbookingid")
    int goToCancelTicket(@Param("seatbookingid") long seatbookingid);

    @Query("Select seatName from SeatBooking where sbUserId = :userId and sbDate = :date and sbShowTime = :time and sbTheatreId = :theatreId and sbMovieId = :movieId ")
    List<String> getSeatNames(@Param("userId") long userId, @Param("date") String date,@Param("time") String time,@Param("theatreId") String theatreId,@Param("movieId") String movieId);
}
