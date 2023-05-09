package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hms.model.Owner;
import com.hms.repository.ownerRepository;

@Controller
public class LoginController {
	
	@Autowired
	private ownerRepository ownerRepo;
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "Login";
		
	}
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute Owner owner,Model model) {
		
		owner.setPassword(DigestUtils.md5DigestAsHex(owner.getPassword().getBytes()));
		Owner own = ownerRepo.findByUsernameAndPassword(owner.getUsername(), owner.getPassword());
		
		
		if(own!= null) 
		{
		model.addAttribute("uname",owner.getUsername());
		
		return "DashBoard";
		}
		
		model.addAttribute("message","User Not Found");
		
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logoutForm() {
		
		return "Login";
	}

}
