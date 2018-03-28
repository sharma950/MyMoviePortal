package com.mymovieportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieportal.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findById(long userId);
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
}
