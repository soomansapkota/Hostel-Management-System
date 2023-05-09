package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hms.model.Owner;
import com.hms.repository.ownerRepository;

@Controller
public class signupController {
	
	@Autowired
	private ownerRepository ownerRepo;
	
	@GetMapping("/signup")
	public String signupPage() {
		return "Signup";
	}
	
	@PostMapping("/signup")
	public String saveOwner(@ModelAttribute Owner owner) {
		owner.setPassword(DigestUtils.md5DigestAsHex(owner.getPassword().getBytes()));
		ownerRepo.save(owner);
		return "Login";
	}
}
