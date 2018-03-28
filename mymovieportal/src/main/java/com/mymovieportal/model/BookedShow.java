package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "booked_show")
public class BookedShow {
	
	@Column(name = "booked_show_id")
	private String bookedShowId;
	
	@Column(name = "movie_id")
	private String movieId;
	
	@Column(name = "theatre_id")
	private String theatreId;
	
	@Column(name = "city_id")
	private String cityId;
	
	@Column(name = "seat_id")
	private String seatId;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "booking_status")
	private String bookingStatus;

	public String getBookedShowId() {
		return bookedShowId;
	}

	public void setBookedShowId(String bookedShowId) {
		this.bookedShowId = bookedShowId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
}
