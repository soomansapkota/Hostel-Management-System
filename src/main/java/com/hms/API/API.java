package com.hms.API;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hms.model.Hostelers;
import com.hms.model.Owner;
import com.hms.repository.hostelersRepository;
import com.hms.repository.ownerRepository;

@RestController
@RequestMapping("/hostelers")
public class API {

	@Autowired
	private hostelersRepository hostelersRepo;

	@GetMapping("/list")
	public List<Hostelers> getHostelersData() {
		return hostelersRepo.findAll();
	}

	@PostMapping("/save")
	public String saveHostelersData(@RequestBody Hostelers hostel) {
		hostelersRepo.save(hostel);
		return "Added Success";
	}

	@DeleteMapping("/{StudentId}")
	public String deleteHostelersData(@PathVariable int StudentId) {
		hostelersRepo.deleteById(StudentId);
		return "Successfully Deleted";
	}

	@GetMapping("/{StudentId}")
	public Optional<Hostelers> getOneData(@PathVariable int StudentId)

	{
		return hostelersRepo.findById(StudentId);
	}
	
	@PostMapping("/{StudentId}")
	public String updateHostelers(@RequestBody Hostelers hostel) {
		
		hostelersRepo.save(hostel);
		
		return "Updated Successfully";
	
	}
	
	//To change json data into object
	
	@GetMapping("/jto")
	public String jsonToObj() {
		
		RestTemplate temp = new RestTemplate();
		Hostelers hostel=temp.getForObject("http://localhost:80/hostelers/152", Hostelers.class);
		
		return "First Name = "+ hostel.getFname();
	}
	
	@GetMapping("/jAtoA")
	public String jsonArraytoObjectArray() {
		
		RestTemplate temp =new RestTemplate();
		Hostelers[] hostelList = temp.getForObject("http://localhost:80/hostelers/list", Hostelers[].class);
		return "FirstName : "+ hostelList[0].getFname();
	}

}
