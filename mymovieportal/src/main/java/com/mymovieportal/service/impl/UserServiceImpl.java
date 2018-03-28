package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.UserDAO;
import com.mymovieportal.model.User;
import com.mymovieportal.repository.UserRepository;
import com.mymovieportal.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#registerUser(com.mymovieportal.model.User)
     */
    @Override
    @Transactional
    public boolean registerUser(User user) {
        // TODO Auto-generated method stub

        //userDao.registerUser(user);
    	userRepository.save(user);

        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#getUsers()
     */
    @Override
    @Transactional
    public List<User> getUsers() {
        // TODO Auto-generated method stub
    	List<User> userList = userRepository.findAll();
        return userList;

    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#getUser(long)
     */
    @Override
    @Transactional
    public User getUser(long id) {
        // TODO Auto-generated method stub

        User user = userRepository.findById(id);

        return user;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#loginChecking(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public long loginChecking(String email, String password) {
        // TODO Auto-generated method stub
    	User user = userRepository.findByEmailAndPassword(email, password);
    	
        return user.getId();

    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#updateUser(long, com.mymovieportal.model.User)
     */
    @Override
    @Transactional
    public boolean updateUser(long id, User user) {
        // TODO Auto-generated method stub

        /*try {
            return userDao.updateUser(id, user);
        } catch (Exception ex) {
            System.out.println("error in UserServiceImpl updateUser()" + ex);
            return false;
        }*/
    	
    	User updateUser = userRepository.save(user);
    	if(updateUser != null){
    		return true;
    	}
    	return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#deleteUser(long)
     */
    @Override
    @Transactional
    public boolean deleteUser(long id) {
        // TODO Auto-generated method stub
        try {
            //return userDao.deleteUser(id);
        	return true;
        } catch (Exception ex) {
            System.out.println("error in UserServiceImpl updateUser()" + ex);
            return false;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#getContactNumber(java.lang.String)
     */
    @Override
    @Transactional
    public boolean getContactNumber(String contactNumber) {
        // TODO Auto-generated method stub
      //  return userDao.getContactNumber(contactNumber);
    	return true;
    }

    @Override
    @Transactional
    public boolean getEmailExistence(String email) {
        // TODO Auto-generated method stub
        email = email + ".com";
        User user = userRepository.findByEmail(email);
        if(user != null)
        {
        	return true;
        }
        return false;
    }

    public boolean deleteUser(User user){
    	userRepository.delete(user);
    	return true;
    }
}
