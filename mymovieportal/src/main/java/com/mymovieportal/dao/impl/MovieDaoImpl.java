package com.mymovieportal.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mymovieportal.dao.MovieDao;
import com.mymovieportal.model.Movie;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean registerMovie(Movie movie) {
		try {
			getSession().save(movie);
			return true;
		} catch (Exception ex) {
			System.out.println("error in MovieDAOImpl registerMovie() " + ex);
			return false;
		}

	}

}
