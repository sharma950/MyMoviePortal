package com.mymovieportal.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class MailController.
 */
@RestController
@RequestMapping("/mymovieportal/mail")
public class MailController {

	/** The sender. */
	@Autowired
	private JavaMailSender sender;

	/**
	 * Mail.
	 *
	 * @param password
	 *            the password
	 * @return the string
	 */
	@RequestMapping("/passwordmail/{password}")
	@ResponseBody
	public String mail(@PathVariable("password") String password) {
		try {
			sendEmail(password);
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
	}

	/**
	 * Send email.
	 *
	 * @param password
	 *            the password
	 * @throws Exception
	 *             the exception
	 */
	private void sendEmail(String password) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo("piyushkushwah13592@gmail.com");
		helper.setText("Hey your password for impetus movie portal is:" + password);
		helper.setSubject("forgotton passsword");

		sender.send(message);
	}
}