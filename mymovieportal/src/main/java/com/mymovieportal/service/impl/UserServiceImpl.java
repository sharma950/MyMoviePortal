package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.UserDAO;
import com.mymovieportal.dto.LoginDTO;
import com.mymovieportal.model.User;
import com.mymovieportal.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {

    /** The user dao. */
    @Autowired
    UserDAO userDao;

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#registerUser(com.mymovieportal.model.User)
     */
    @Override
    @Transactional
    public boolean registerUser(User user) {
        // TODO Auto-generated method stub

        return userDao.registerUser(user);

        //return true;
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

        return userDao.getUsers();

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

        User user = userDao.getUser(id);

        return user;
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

        try {
            return userDao.updateUser(id, user);
        } catch (Exception ex) {
            // System.out.println("error in UserServiceImpl updateUser()" + ex);
            return false;
        }
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
            return userDao.deleteUser(id);
        } catch (Exception ex) {
            // System.out.println("error in UserServiceImpl updateUser()" + ex);
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
        return userDao.getContactNumber(contactNumber);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#getEmailExistence(java.lang.String)
     */
    @Override
    @Transactional
    public boolean getEmailExistence(String email) {
        // TODO Auto-generated method stub
        // email = email + ".com";
        return userDao.getEmailExistence(email);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.UserService#getPassword(java.lang.String)
     */
    @Override
    @Transactional
    public String getPassword(String email) {
        // TODO Auto-generated method stub
        // email = email + ".com";
        return userDao.getPassword(email);
    }

    @Override
    @Transactional
    public LoginDTO loginChecking(String email, String password) {
        // TODO Auto-generated method stub
        return userDao.loginChecking(email, password);
    }

}
