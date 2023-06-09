package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class contactCotroller {

	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/contact")
	public String getEmail(HttpSession session) {

		if (session.getAttribute("owner") == null) {

			return "Login";
		}

		return "contact";

	}

	@PostMapping("/contact")
	public String postEmail(@RequestParam String fromEmail, @RequestParam String subject, @RequestParam String Message) {
		String ownerEmail = "suman2000j@gmail.com";
		sendEmail(ownerEmail,subject,Message);
		return "contact";

	}

	private void sendEmail(String fromEmail, String subject, String Message) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromEmail);
		msg.setSubject(subject);
		msg.setText(Message);

		javaMailSender.send(msg);

	}

}
