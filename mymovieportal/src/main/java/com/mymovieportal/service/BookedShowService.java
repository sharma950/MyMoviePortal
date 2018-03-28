package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.model.BookedShow;

public interface BookedShowService {
	
	public List<BookedShow> getAllBookedShowByUserId(String userId);
	
	public List<BookedShow> getAllBookedShowByMovieId(String movieId);
	
	public List<BookedShow> getAllBookedShowByTheatreId(String theatreId);
	
	public BookedShow saveBookedShow(BookedShow bookedShow);
}
