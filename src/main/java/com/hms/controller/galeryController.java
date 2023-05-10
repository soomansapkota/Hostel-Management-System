package com.hms.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class galeryController {

	@GetMapping("/gallery")
	public String galleryForm(Model model, HttpSession session) {

		if (session.getAttribute("owner") == null) {

			return "Login";
		}
		File dir = new File("src/main/resources/static/images");
		String[] imgnames=dir.list();
		model.addAttribute("imgList",imgnames);
		
	return "gallery";
	
	}
}
