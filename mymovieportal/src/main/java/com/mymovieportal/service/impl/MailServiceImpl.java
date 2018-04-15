package com.mymovieportal.service.impl;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mymovieportal.dto.ConfirmSeatMailDTO;
import com.mymovieportal.dto.UserDTO;
import com.mymovieportal.model.Movie;
import com.mymovieportal.model.Theatre;
import com.mymovieportal.model.User;
import com.mymovieportal.service.MailService;
import com.mymovieportal.service.MovieService;
import com.mymovieportal.service.TheatreService;
import com.mymovieportal.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class MailServiceImpl.
 */
@Service
public class MailServiceImpl implements MailService {

    /** The theatre service. */
    @Autowired
    TheatreService theatreService;

    /** The movie service. */
    @Autowired
    MovieService movieService;

    /** The sender. */
    @Autowired
    private JavaMailSender sender;

    @Autowired
    private UserService userService;

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.MailService#forgotPasswordMail(java.lang.String)
     */

    @Override
    @Transactional
    public void forgotPasswordMail(UserDTO userDTO) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(userDTO.getEmail());
        helper.setText("Hey your password for impetus movie portal is:" + userDTO.getPassword());
        helper.setSubject("forgotton passsword");

        sender.send(message);

    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.MailService#confirmSeatMail(com.mymovieportal.dto.ConfirmSeatMailDTO)
     */
    @Override
    @Transactional
    public String confirmSeatMail(ConfirmSeatMailDTO confirmSeatMailDTO) throws Exception {
        // TODO Auto-generated method stub

        String date = confirmSeatMailDTO.getDate();
        // int totalSeat = confirmSeatMailDTO.getTotalSeats();
        String time = confirmSeatMailDTO.getTime();
        String theatreId = confirmSeatMailDTO.getTheatreId();
        String movieId = confirmSeatMailDTO.getMovieId();
        List<String> seatsName = confirmSeatMailDTO.getSeatNames();

        User user = userService.getUser(confirmSeatMailDTO.getId());

        Theatre theatre = theatreService.getTheatre(theatreId);
        String theatreName = theatre.getTheatreName();
        // System.out.println(movieId);
        Movie movie = movieService.getMovie(movieId);
        String movieName = movie.getMovieName();

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        StringBuffer sb = new StringBuffer();

        helper.setTo(user.getEmail());
        sb.append("Hey you have booked ticket for : " + movieName + " for  " + date);
        sb.append("\n Please reach before 15 min of show time at : " + theatreName + "\n show time : " + time);
        sb.append("\n your seats are : ");
        for (String seatName : seatsName) {
            sb.append(" " + seatName);
        }

        helper.setText("Plain Message", sb.toString());
        helper.setSubject("Movie Booking Confirm Email");

        sender.send(message);
        return "email sent";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.MailService#cancelSeatMail(com.mymovieportal.dto.ConfirmSeatMailDTO)
     */
    @Override
    @Transactional
    public String cancelSeatMail(ConfirmSeatMailDTO confirmSeatMailDTO) throws Exception {
        // TODO Auto-generated method stub
        String date = confirmSeatMailDTO.getDate();
        String time = confirmSeatMailDTO.getTime();
        String theatreName = confirmSeatMailDTO.getTheatreId();
        String movieName = confirmSeatMailDTO.getMovieId();
        List<String> seatsName = confirmSeatMailDTO.getSeatNames();

        User user = userService.getUser(confirmSeatMailDTO.getId());

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        StringBuffer sb = new StringBuffer();

        helper.setTo(user.getEmail());
        sb.append("Hey you have cancelled ticket for : " + movieName + " for  " + date);
        sb.append("\n at : " + theatreName + "\n show time : " + time);
        sb.append("\n your seat were : ");

        for (String seatName : seatsName) {
            sb.append(" " + seatName);
        }
        helper.setText("Plain Message", sb.toString());
        helper.setSubject("Movie Booking Cancel Email");

        sender.send(message);
        return "email sent";
    }

    @Override
    @Transactional
    public String showTimeAlertMail(ConfirmSeatMailDTO confirmSeatMailDTO) throws Exception {

        // TODO Auto-generated method stub

        String date = confirmSeatMailDTO.getDate();
        // int totalSeat = confirmSeatMailDTO.getTotalSeats();
        String time = confirmSeatMailDTO.getTime();
        String theatreId = confirmSeatMailDTO.getTheatreId();
        String movieId = confirmSeatMailDTO.getMovieId();
        List<String> seatsName = confirmSeatMailDTO.getSeatNames();

        Theatre theatre = theatreService.getTheatre(theatreId);
        String theatreName = theatre.getTheatreName();
        System.out.println(movieId);
        Movie movie = movieService.getMovie(movieId);
        String movieName = movie.getMovieName();

        User user = userService.getUser(confirmSeatMailDTO.getUserId());
        String userEmail = user.getEmail();

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        StringBuffer sb = new StringBuffer();

        helper.setTo(userEmail);
        sb.append("Hey you have booked ticket for : " + movieName + " for  " + date);
        sb.append("\n Please reach before 15 min of show time at : " + theatreName + "\n show time : " + time);
        sb.append("\n your seats are : ");

        for (String seatName : seatsName) {
            sb.append(" " + seatName);
        }

        helper.setText("Plain Message", sb.toString());
        helper.setSubject("Movie Booking Confirm Email");

        sender.send(message);
        return "email sent";
    }
}
