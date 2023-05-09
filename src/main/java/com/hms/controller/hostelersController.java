package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hms.model.Hostelers;
import com.hms.repository.hostelersRepository;



@Controller
public class hostelersController {

	@Autowired
	private hostelersRepository hostelersRepo;
	
	
	@GetMapping("/hostelersform")
	public String formEntry()
	{
		return "HostelersForm";
	}
	
	@PostMapping("/hostelersform")
	public String saveHostelers(@ModelAttribute Hostelers hostel) {
		hostelersRepo.save(hostel);
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String getAllHos(Model model)
	{
		model.addAttribute("hosList",hostelersRepo.findAll());
		return "Home";
	}
	
	@GetMapping("/delete")
	public String deleteHostelers(@RequestParam int id) {
		hostelersRepo.deleteById(id);
		return "redirect:list";
	}
	
	@GetMapping("/edit")
	public String editHostelers(@RequestParam int id,Model model)
	{
		model.addAttribute("hedit",hostelersRepo.findById(id));
		return "EditForm";
	}
	
	@PostMapping("/update")
	public String updateHostelers(@ModelAttribute Hostelers hostel) {
		hostelersRepo.save(hostel);
		return "redirect:list";
	}
	
}
