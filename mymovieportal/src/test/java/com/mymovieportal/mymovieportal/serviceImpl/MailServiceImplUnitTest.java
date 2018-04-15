package com.mymovieportal.mymovieportal.serviceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;

import com.mymovieportal.dto.UserDTO;
import com.mymovieportal.service.MailService;
import com.mymovieportal.service.MovieService;
import com.mymovieportal.service.TheatreService;
import com.mymovieportal.service.UserService;
import com.mymovieportal.service.impl.MailServiceImpl;

public class MailServiceImplUnitTest {

    @InjectMocks
    private MailService mailService = new MailServiceImpl();

    @Mock
    TheatreService theatreService;

    @Mock
    MovieService movieService;

    @Mock
    private JavaMailSender sender;

    @Mock
    private UserService userService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testForgetPasswordMail() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("piyushkushwah13592@gmail.com");
        userDTO.setPassword("1wwWWW");

       // MimeMessage message = ;

        //when(sender.createMimeMessage()).thenReturn(message);


        mailService.forgotPasswordMail(userDTO);

        // when(sender.send(message))
    }

}
