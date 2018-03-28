package com.mymovieportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieportal.model.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer>{
	Theatre findByTheatreId(String theatreId);
	List<Theatre> findByCityId(String cityId);
}
