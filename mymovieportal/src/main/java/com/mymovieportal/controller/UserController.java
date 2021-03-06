package com.mymovieportal.controller;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mymovieportal.dao.UserDAO;
import com.mymovieportal.dto.LoginDTO;
import com.mymovieportal.dto.ResultDTO;
import com.mymovieportal.dto.UserDTO;
import com.mymovieportal.model.User;
import com.mymovieportal.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/mymovieportal/user")
public class UserController {

    /** The user service. */
    @Autowired
    UserService userService;

    /** The user dao. */
    @Autowired
    UserDAO userDao;

    /**
     * Save.
     *
     * @param userDTO the user DTO
     * @return the response entity
     */

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Boolean> save(@RequestBody UserDTO userDTO) {

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        boolean result = userService.registerUser(user);
        userDTO = modelMapper.map(user, UserDTO.class);
        return ResponseEntity.ok().body(result);

    }

    /**
     * Gets the.
     *
     * @param id the id
     * @return the response entity
     */

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> get(@PathVariable("id") long id) {
        User user = userService.getUser(id);

        return ResponseEntity.ok().body(user);
    }

    /**
     * Gets the for logging.
     *
     * @param userDTO the user DTO
     * @return the for logging
     */

    @RequestMapping(value = "/loginChecking", method = RequestMethod.POST)
    public ResponseEntity<String> loginChecking(@RequestBody UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();

        LoginDTO loginDTO = userService.loginChecking(email, password);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
        if (loginDTO != null) {
            return new ResponseEntity<>(gson.toJson(loginDTO), HttpStatus.CREATED);
        } else {
            loginDTO = new LoginDTO();
            loginDTO.setId(0L);
            loginDTO.setRole("farji");
            return new ResponseEntity<>(gson.toJson(loginDTO), HttpStatus.FORBIDDEN);

        }
    }

    /**
     * Update.
     *
     * @param id the id
     * @param userDTO the user DTO
     * @param request the request
     * @return the response entity
     */

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Boolean> update(@PathVariable("id") long id, @RequestBody UserDTO userDTO,
        final HttpServletRequest request) {
        boolean result;
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        result = userService.updateUser(id, user);
        return ResponseEntity.ok().body(result);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return the response entity
     */

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
        boolean result;
        result = userService.deleteUser(id);
        return ResponseEntity.ok().body(result);
    }

    /**
     * Gets the contact number.
     *
     * @param contactNumber the contact number
     * @return the contact number
     */

    @RequestMapping(value = "/getContactExistence/{contactNumber}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getContactNumber(@PathVariable("contactNumber") String contactNumber) {

        boolean result = userService.getContactNumber(contactNumber);
        return ResponseEntity.ok().body(result);
    }

    /**
     * Gets the email existence.
     *
     * @param email the email
     * @return the email existence
     */

    @RequestMapping(value = "/getEmailExistence/{email:.+}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> getEmailExistence(@PathVariable("email") String email) {
        boolean result = userService.getEmailExistence(email);
        return ResponseEntity.ok().body(result);
    }

    /**
     * Gets the password.
     *
     * @param email the email
     * @return the password
     */
    @RequestMapping(value = "/getPassword/{email:.+}", method = RequestMethod.GET)
    public ResponseEntity<ResultDTO> getPassword(@PathVariable("email") String email) {
        String result = userService.getPassword(email);
        ResultDTO rs = new ResultDTO();
        rs.setResult(result);
        return ResponseEntity.ok().body(rs);

    }

}