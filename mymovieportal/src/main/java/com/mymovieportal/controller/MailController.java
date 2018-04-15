package com.mymovieportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieportal.dto.ConfirmSeatMailDTO;
import com.mymovieportal.dto.ResultDTO;
import com.mymovieportal.dto.UserDTO;
import com.mymovieportal.service.MailService;

// TODO: Auto-generated Javadoc
/**
 * The Class MailController.
 */
@RestController
@RequestMapping("/mymovieportal/mail")
public class MailController {

    /** The mail service. */
    @Autowired
    MailService mailService;

    /**
     * Mail.
     *
     * @param password the password
     * @return the string
     * @throws Exception
     */
    @RequestMapping(value = "/forgotPasswordMail", method = RequestMethod.POST)
    public ResponseEntity<ResultDTO> forgotPasswordMail(@RequestBody UserDTO userDTO) throws Exception {

        // sendEmail(password);
        mailService.forgotPasswordMail(userDTO);
        String result = "Email Sent!";
        ResultDTO rs = new ResultDTO();
        rs.setResult(result);
        return ResponseEntity.ok().body(rs);

    }

    /**
     * Confim seat mail.
     *
     * @param confirmSeatMailDTO the confirm seat mail DTO
     * @return the response entity
     * @throws Exception the exception
     */
    @RequestMapping(value = "/confirmSeatMail", method = RequestMethod.POST)
    public ResponseEntity<ResultDTO> confimSeatMail(@RequestBody ConfirmSeatMailDTO confirmSeatMailDTO)
        throws Exception {

        String result = mailService.confirmSeatMail(confirmSeatMailDTO);
        ResultDTO rs = new ResultDTO();
        rs.setResult(result);
        return ResponseEntity.ok().body(rs);
    }

    /**
     * Cancel seat mail.
     *
     * @param confirmSeatMailDTO the confirm seat mail DTO
     * @return the response entity
     * @throws Exception the exception
     */
    @RequestMapping(value = "/cancelSeatMail", method = RequestMethod.POST)
    public ResponseEntity<ResultDTO> cancelSeatMail(@RequestBody ConfirmSeatMailDTO confirmSeatMailDTO)
        throws Exception {

        String result = mailService.cancelSeatMail(confirmSeatMailDTO);
        ResultDTO rs = new ResultDTO();
        rs.setResult(result);
        return ResponseEntity.ok().body(rs);
    }
}
