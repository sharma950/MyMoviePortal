package com.mymovieportal.dto;

import javax.persistence.Column;

public class MoviePriceDTO {

	private String moviePriceId;
	
	private String movieId;
	
	private String theatreId;
	
	private String cityId;
	
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
