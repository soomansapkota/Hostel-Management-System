package com.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//controller is used to request processing
public class IndexController {

	@GetMapping("/")
	public String homePage() {
		return "Login";
	}

}
