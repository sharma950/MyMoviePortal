package com.mymovieportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieportal.model.BookedShow;

public interface BookedShowRepository extends JpaRepository<BookedShow,Integer>{
	
	List<BookedShow> findByUserId(String userId);
	
	List<BookedShow> findByTheatreId(String theatreId); 
	
	List<BookedShow> findByMovieId(String movieId);
	
}
