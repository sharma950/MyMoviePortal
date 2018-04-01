package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Register user.
	 *
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	boolean registerUser(User user);

	/**
	 * Gets the user.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 */
	User getUser(long id);

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	List<User> getUsers();

	/**
	 * Login checking.
	 *
	 * @param email
	 *            the email
	 * @param password
	 *            the password
	 * @return the long
	 */
	long loginChecking(String email, String password);

	/**
	 * Update user.
	 *
	 * @param id
	 *            the id
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	boolean updateUser(long id, User user);

	/**
	 * Delete user.
	 *
	 * @param id
	 *            the id
	 * @return true, if successful
	 */
	boolean deleteUser(long id);

	/**
	 * Gets the contact number.
	 *
	 * @param contactNumber
	 *            the contact number
	 * @return the contact number
	 */
	boolean getContactNumber(String contactNumber);

	/**
	 * Gets the email existence.
	 *
	 * @param email
	 *            the email
	 * @return the email existence
	 */
	boolean getEmailExistence(String email);

	/**
	 * Gets the password.
	 *
	 * @param email
	 *            the email
	 * @return the password
	 */
	String getPassword(String email);

}
