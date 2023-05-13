package com.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//controller is used to request processing
public class IndexController {

	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/index")
	public String homePage() {
		return "Login";
	}
	
	
	@GetMapping("/rest")
	public String REstAPI() {
		
		return "REstAPI";
		
	}
	
	@GetMapping("/home")
	public String Home()
	{
		
		return "Home";
	}
	

}
