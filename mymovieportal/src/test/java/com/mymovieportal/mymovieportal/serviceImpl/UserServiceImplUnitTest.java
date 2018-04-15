package com.mymovieportal.mymovieportal.serviceImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mymovieportal.dao.UserDAO;
import com.mymovieportal.dto.LoginDTO;
import com.mymovieportal.model.User;
import com.mymovieportal.service.UserService;
import com.mymovieportal.service.impl.UserServiceImpl;

public class UserServiceImplUnitTest {

    @InjectMocks
    UserService userService = new UserServiceImpl();

    @Mock
    UserDAO userDao;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setId(1L);

        when(userDao.registerUser(anyObject())).thenReturn(true);

        boolean flag = userService.registerUser(user);

        assertTrue(flag);
    }

    @Test
    public void testRegisterUserInvalid() {
        User user = new User();
        user.setId(0L);

        when(userDao.registerUser(anyObject())).thenReturn(false);

        boolean flag = userService.registerUser(user);

        assertFalse(flag);
    }

    @Test
    public void testGetUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());

        when(userDao.getUsers()).thenReturn(userList);

        List<User> users = userService.getUsers();

        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setId(1L);

        when(userDao.getUser(anyLong())).thenReturn(user);

        User user2 = userService.getUser(1L);

        assertSame(user2.getId(), user.getId());
    }

    @Test
    public void testGetUserInvalid() {
        User user = new User();
        user.setId(1L);

        when(userDao.getUser(anyLong())).thenReturn(new User());

        User user2 = userService.getUser(1L);

        assertNotSame(user2.getId(), user.getId());
    }

    @Test
    public void testUpdateUser() {

        User user = new User();
        user.setId(1L);
        user.setName("Ram");

        when(userDao.updateUser(anyLong(), anyObject())).thenReturn(true);

        /*
         * User user2 = new User();
         * user2.setId(1L);
         * user2.setName("Lakhan");
         */

        boolean flag = userService.updateUser(1L, user);
        assertTrue(flag);

    }

    @Test
    public void testUpdateUserInvalid() {

        User user = new User();
        user.setId(1L);
        user.setName("Ram");

        when(userDao.updateUser(anyLong(), anyObject())).thenReturn(false);

        /*
         * User user2 = new User();
         * user2.setId(1L);
         * user2.setName("Lakhan");
         */

        boolean flag = userService.updateUser(0L, user);
        assertFalse(flag);

    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Ram");

        when(userDao.deleteUser(anyLong())).thenReturn(true);

        boolean flag = userService.deleteUser(1L);

        assertTrue(flag);

    }

    @Test
    public void testDeleteUserInvalid() {
        User user = new User();
        user.setId(1L);
        user.setName("Ram");

        when(userDao.deleteUser(anyLong())).thenReturn(false);

        boolean flag = userService.deleteUser(0L);

        assertFalse(flag);

    }

    @Test
    public void testGetContactNumber() {

        User user = new User();
        user.setId(1L);
        user.setContactNumber("9009897989");

        when(userDao.getContactNumber(anyString())).thenReturn(true);
        boolean flag = userService.getContactNumber("9009897989");

        assertTrue(flag);
    }

    @Test
    public void testGetContactNumberInvalid() {

        User user = new User();
        user.setId(1L);
        user.setContactNumber("9009897989");

        when(userDao.getContactNumber(anyString())).thenReturn(false);
        boolean flag = userService.getContactNumber("0000000000");

        assertFalse(flag);
    }

    @Test
    public void testGetEmailExistence() {

        User user = new User();
        user.setId(1L);
        user.setContactNumber("9009897989");
        user.setEmail("piyushkushwah13592@gmail.com");

        when(userDao.getEmailExistence(anyString())).thenReturn(true);
        boolean flag = userService.getEmailExistence("piyushkushwah13592@gmail.com");

        assertTrue(flag);
    }

    @Test
    public void testGetEmailExistenceInvalid() {

        User user = new User();
        user.setId(1L);
        user.setContactNumber("9009897989");
        user.setEmail("piyushkushwah13592@gmail.com");

        when(userDao.getEmailExistence(anyString())).thenReturn(false);
        boolean flag = userService.getEmailExistence("piyushkushwah@gmail.com");

        assertFalse(flag);
    }

    @Test
    public void testGetPassword() {

        User user = new User();
        user.setId(1L);
        user.setContactNumber("9009897989");
        user.setEmail("piyushkushwah13592@gmail.com");
        user.setPassword("1wwWWW");

        when(userDao.getPassword(anyString())).thenReturn(user.getPassword());

        String password = userService.getPassword("piyushkushwah13592@gmail.com");

        assertSame(password, user.getPassword());
    }

    @Test
    public void testGetPasswordInvalid() {

        User user = new User();
        user.setId(1L);
        user.setContactNumber("9009897989");
        user.setEmail("piyushkushwah13592@gmail.com");
        user.setPassword("1wwWWW");

        when(userDao.getPassword(anyString())).thenReturn(null);

        String password = userService.getPassword("piyushkushwah@gmail.com");

        assertNull(password);
    }

    @Test
    public void testLoginChecking() {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(1L);
        loginDTO.setRole("user");

        when(userDao.loginChecking(anyString(), anyString())).thenReturn(loginDTO);

        LoginDTO login = userService.loginChecking("piyushkushwah13592@gmail.com", "1wwWWW");

        assertSame(login.getId(),loginDTO.getId());
        assertSame(login.getRole(),loginDTO.getRole());

    }

    @Test
    public void testLoginCheckingInvalid() {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setId(1L);
        loginDTO.setRole("user");

        when(userDao.loginChecking(anyString(), anyString())).thenReturn(new LoginDTO());

        LoginDTO login = userService.loginChecking("piyushkushwah@gmail.com", "0000");

        assertNotSame(login.getId(),loginDTO.getId());
        assertNotSame(login.getRole(),loginDTO.getRole());

    }
}
