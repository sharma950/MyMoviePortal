package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movie_price")
public class MoviePrice {
	
	@Column(name = "movie_price_id")
	private String moviePriceId;
	
	@Column(name = "movie_id")
	private String movieId;
	
	@Column(name = "theatre_id")
	private String theatreId;
	
	@Column(name = "city_id")
	private String cityId;
	
	@Column(name = "movie_price")
	private Double moviePrice;

	public String getMoviePriceId() {
		return moviePriceId;
	}

	public void setMoviePriceId(String moviePriceId) {
		this.moviePriceId = moviePriceId;
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

	public Double getMoviePrice() {
		return moviePrice;
	}

	public void setMoviePrice(Double moviePrice) {
		this.moviePrice = moviePrice;
	}
	
}
