package com.mail.Mail.OTP.MailController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping("/sendEmail/{to}")
	public String sendEmail(@PathVariable("to") String to, @RequestBody String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("darshanlonkar2023@gmail.com");
		message.setTo(to);
		message.setSubject("Your Subject Here");

		message.setText(body);

		javaMailSender.send(message);
		return "Email Sent Successfully to " + to;

	}

}
