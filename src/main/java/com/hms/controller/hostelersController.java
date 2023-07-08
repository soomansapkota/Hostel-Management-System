package com.hms.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hms.model.Hostelers;
import com.hms.repository.hostelersRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class hostelersController {

	@Autowired
	private hostelersRepository hostelersRepo;

	@GetMapping("/hostelersform")
	public String formEntry(HttpSession session) {

		if (session.getAttribute("owner") == null) {

			return "Login";
		}

		return "HostelersForm";

	}
	
	
	@PostMapping("/hostelersform")
	@Scheduled(fixedRate = 1000)
	public String saveHostelers(@RequestParam("fileone") MultipartFile file, Hostelers hostel, Model model)
			throws IOException {

		if (!file.isEmpty()) {

			FileOutputStream fout = new FileOutputStream(
					"src/main/resources/static/ProductImages/" + file.getOriginalFilename());
			fout.write(file.getBytes());
			fout.close();

		}

		//final String FOLDER_PATH = "src/main/resources/static/ProductImages/";

		String filePath = file.getOriginalFilename();

		String imageString = Base64.getEncoder().encodeToString(filePath.getBytes());
		hostel.setImage(filePath.toString());

		hostelersRepo.save(hostel);

		return "redirect:list";
	}

	@GetMapping("/list")
	public String getAllHos(Model model, HttpSession session, Hostelers hostel) throws IOException {
		String dir = "src/main/resources/static/ProductImages/";
		List<Hostelers> hostelers = hostelersRepo.findAll();
		for (Hostelers hostelers2 : hostelers) {
			
		    String imagePath = hostelers2.getImage(); 
		    Path filePath = Paths.get(dir + imagePath);
			model.addAttribute("hosList", hostelersRepo.findAll());
		  
	}

		
		return "List";
	}

	
	
	@GetMapping("/details")
	public String getDetails(Model model, HttpSession session, Hostelers hostel) throws IOException {
		String dir = "src/main/resources/static/ProductImages/";
		List<Hostelers> hostelers = hostelersRepo.findAll();
		for (Hostelers hostelers2 : hostelers) {
			
		    String imagePath = hostelers2.getImage(); 
		    Path filePath = Paths.get(dir + imagePath);
			model.addAttribute("hosList", hostelersRepo.findAll());
		  
	}

		
		return "hostelersDetails";
	}
	
	
	
	@GetMapping("/delete")
	public String deleteHostelers(@RequestParam int id, HttpSession session) {

		if (session.getAttribute("owner") == null) {

			return "Login";
		}

		hostelersRepo.deleteById(id);
		return "redirect:list";
	}

	@GetMapping("/edit")
	public String editHostelers(@RequestParam int id, Model model, HttpSession session) {

		if (session.getAttribute("owner") == null) {

			return "Login";
		}

		model.addAttribute("hedit", hostelersRepo.findById(id));
		return "EditForm";
	}

	@PostMapping("/update")
	public String updateHostelers(@ModelAttribute Hostelers hostel, HttpSession session) {

		if (session.getAttribute("owner") == null) {

			return "Login";
		}
		// model.addAttribute("hosList",hostelersRepo.findAll());
		// return "Home";

		hostelersRepo.save(hostel);
		return "redirect:list";
	}

}
