package com.mymovieportal.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfirmSeatMailDTO.
 */
public class ConfirmSeatMailDTO {

    /** The id. */
    private long id;

    /** The date. */
    private String date;

    /** The total seats. */
    private int totalSeats;

    /** The time. */
    private String time;

    /** The seat names. */
    private List<String> seatNames;

    /** The theatre id. */
    private String theatreId;

    /** The movie id. */
    private String movieId;

    private Long userId;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the total seats.
     *
     * @return the total seats
     */
    public int getTotalSeats() {
        return totalSeats;
    }

    /**
     * Sets the total seats.
     *
     * @param totalSeats the new total seats
     */
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    /**
     * Gets the seat names.
     *
     * @return the seat names
     */
    public List<String> getSeatNames() {
        return seatNames;
    }

    /**
     * Sets the seat names.
     *
     * @param seatNames the new seat names
     */
    public void setSeatNames(List<String> seatNames) {
        this.seatNames = seatNames;
    }

    /**
     * Gets the time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time.
     *
     * @param time the new time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets the theatre id.
     *
     * @return the theatre id
     */
    public String getTheatreId() {
        return theatreId;
    }

    /**
     * Sets the theatre id.
     *
     * @param theatreId the new theatre id
     */
    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    /**
     * Gets the movie id.
     *
     * @return the movie id
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * Sets the movie id.
     *
     * @param movieId the new movie id
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
