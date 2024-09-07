package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.registration;
import com.example.demo.services.registrationservice;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")

public class registrationcontroller {

	@Autowired
	registrationservice service;
	
	@PostMapping("/insertion")
	public registration registerstudent(@RequestBody registration rmodel) {
		
		return service.registerstudent(rmodel);
		
	}
	
	@PostMapping("/multiinsertion")
	public Iterable<registration> multireRegistration(@RequestBody List<registration> li) {
		
		return service.multiregistration(li);
	}
	
	@GetMapping("/multifetch")
	public List<registration> fetchall(){
		
		return service.fetchall();
	}
	
	@GetMapping("/fetchbyid/{id}")
	public Optional<registration> getbyid(@PathVariable int id) {
		
		return service.getbyid(id);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String delete(@PathVariable int id) {
		
		return service.delete(id);
	}
	
	@GetMapping("/findbyemail/{email}")
	public registration getbyemail(@PathVariable String email) {
		return service.getbyemail(email);
	}
	
	@PutMapping("/update/{id}")
	public registration update(@RequestBody registration reg) {
		return service.update(reg);
	}
}
