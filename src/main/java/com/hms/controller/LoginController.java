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

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private ownerRepository ownerRepo;
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "Login";
		
	}
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute Owner owner,Model model,HttpSession session) {
		
		owner.setPassword(DigestUtils.md5DigestAsHex(owner.getPassword().getBytes()));
		Owner own = ownerRepo.findByUsernameAndPassword(owner.getUsername(), owner.getPassword());
		
		
		if(own!= null) 
		{
			
			session.setAttribute("owner", own);
			session.setMaxInactiveInterval(120);
		//model.addAttribute("uname",owner.getUsername());
		
		return "DashBoard";
		}
		
		model.addAttribute("message","User Not Found");
		
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logoutForm(HttpSession session) {
		
		session.invalidate();		
		return "Login";
	}

}
