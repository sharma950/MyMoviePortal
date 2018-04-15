package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class SeatBooking.
 */
@Entity
@Table(name = "seatbooking")
public class SeatBooking {

    /** The seat booking id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seatbooking_id")
    private Long seatBookingId;

    /** The sb city id. */
    @Column(name = "sb_city_id")
    private String sbCityId;

    /** The sb theatre id. */
    @Column(name = "sb_theatre_id")
    private String sbTheatreId;

    /** The sb movie id. */
    @Column(name = "sb_movie_id")
    private String sbMovieId;

    /** The sb showtime id. */
    @Column(name = "sb_showtime")
    private String sbShowTime;

    /** The seat name. */
    @Column(name = "seat_name")
    private String seatName;

    /** The sb date. */
    @Column(name = "sb_date")
    private String sbDate;

    /** The sb status. */
    @Column(name = "status")
    private String sbStatus;

    /** The sb user id. */
    @Column(name = "sb_user_id")
    private long sbUserId;

    /** The sb city name. */
    private transient String sbCityName;

    /** The sb theatre name. */
    private transient String sbTheatreName;

    /** The sb movie name. */
    private transient String sbMovieName;

    /**
     * Instantiates a new seat booking.
     */
    public SeatBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Gets the seat booking id.
     *
     * @return the seat booking id
     */
    public Long getSeatBookingId() {
        return seatBookingId;
    }

    /**
     * Sets the seat booking id.
     *
     * @param seatBookingId the new seat booking id
     */
    public void setSeatBookingId(Long seatBookingId) {
        this.seatBookingId = seatBookingId;
    }

    /**
     * Gets the sb city id.
     *
     * @return the sb city id
     */
    public String getSbCityId() {
        return sbCityId;
    }

    /**
     * Sets the sb city id.
     *
     * @param sbCityId the new sb city id
     */
    public void setSbCityId(String sbCityId) {
        this.sbCityId = sbCityId;
    }

    /**
     * Gets the sb theatre id.
     *
     * @return the sb theatre id
     */
    public String getSbTheatreId() {
        return sbTheatreId;
    }

    /**
     * Sets the sb theatre id.
     *
     * @param sbTheatreId the new sb theatre id
     */
    public void setSbTheatreId(String sbTheatreId) {
        this.sbTheatreId = sbTheatreId;
    }

    /**
     * Gets the sb movie id.
     *
     * @return the sb movie id
     */
    public String getSbMovieId() {
        return sbMovieId;
    }

    /**
     * Sets the sb movie id.
     *
     * @param sbMovieId the new sb movie id
     */
    public void setSbMovieId(String sbMovieId) {
        this.sbMovieId = sbMovieId;
    }

    /**
     * Gets the sb showtime id.
     *
     * @return the sb showtime id
     */
    public String getSbShowTime() {
        return sbShowTime;
    }

    /**
     * Sets the sb showtime id.
     *
     * @param sbShowTime the new sb show time
     */
    public void setSbShowTime(String sbShowTime) {
        this.sbShowTime = sbShowTime;
    }

    /**
     * Gets the seat name.
     *
     * @return the seat name
     */
    public String getSeatName() {
        return seatName;
    }

    /**
     * Sets the seat name.
     *
     * @param seatName the new seat name
     */
    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    /**
     * Gets the sb date.
     *
     * @return the sb date
     */
    public String getSbDate() {
        return sbDate;
    }

    /**
     * Sets the sb date.
     *
     * @param sbDate the new sb date
     */
    public void setSbDate(String sbDate) {
        this.sbDate = sbDate;
    }

    /**
     * Gets the sb status.
     *
     * @return the sb status
     */
    public String getSbStatus() {
        return sbStatus;
    }

    /**
     * Sets the sb status.
     *
     * @param sbStatus the new sb status
     */
    public void setSbStatus(String sbStatus) {
        this.sbStatus = sbStatus;
    }

    /**
     * Gets the sb user id.
     *
     * @return the sb user id
     */
    public long getSbUserId() {
        return sbUserId;
    }

    /**
     * Sets the sb user id.
     *
     * @param sbUserId the new sb user id
     */
    public void setSbUserId(long sbUserId) {
        this.sbUserId = sbUserId;
    }

    public String getSbCityName() {
        return sbCityName;
    }

    public void setSbCityName(String sbCityName) {
        this.sbCityName = sbCityName;
    }

    public String getSbTheatreName() {
        return sbTheatreName;
    }

    public void setSbTheatreName(String sbTheatreName) {
        this.sbTheatreName = sbTheatreName;
    }

    public String getSbMovieName() {
        return sbMovieName;
    }

    public void setSbMovieName(String sbMovieName) {
        this.sbMovieName = sbMovieName;
    }

}
