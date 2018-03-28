package com.mymovieportal.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieportal.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
