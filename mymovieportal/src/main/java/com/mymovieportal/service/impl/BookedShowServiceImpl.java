package com.mymovieportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.model.BookedShow;
import com.mymovieportal.repository.BookedShowRepository;
import com.mymovieportal.service.BookedShowService;

@Service
public class BookedShowServiceImpl implements BookedShowService{

	@Autowired
	BookedShowRepository bookedShowRepository;
	
	@Override
	public List<BookedShow> getAllBookedShowByUserId(String userId) {
		// TODO Auto-generated method stub
		
		return bookedShowRepository.findByUserId(userId);
	}

	@Override
	public List<BookedShow> getAllBookedShowByMovieId(String movieId) {
		// TODO Auto-generated method stub
		return bookedShowRepository.findByMovieId(movieId);
	}

	@Override
	public List<BookedShow> getAllBookedShowByTheatreId(String theatreId) {
		// TODO Auto-generated method stub
		return bookedShowRepository.findByTheatreId(theatreId);
	}

	@Override
	public BookedShow saveBookedShow(BookedShow bookedShow) {
		// TODO Auto-generated method stub
		BookedShow show = bookedShowRepository.save(bookedShow);
		return show;
	}
	
}
