package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.registration;
import com.example.demo.repository.registrationrepo;

@Service
public class registrationservice {

	@Autowired
	registrationrepo repo;
	
//	inserting data
	public registration registerstudent(registration rmodel) {
		return repo.save(rmodel);
	}
	
	public Iterable<registration> multiregistration(List<registration> li) {
		
		return repo.saveAll(li);
	}
	
	public List<registration> fetchall(){
		
		return (List<registration>) repo.findAll();
	}
	
	public Optional<registration> getbyid(int id) {
		
		return repo.findById(id);
	}
	
	public registration getbyemail(String email) {
		return repo.findByEmail(email);
	}
	
	public String delete(int id) {
		
		repo.deleteById(id);
		return "Succesfully deleted"+id;
	}
	
	public registration update(registration reg) {
		
		int id = reg.getId();
		registration r = repo.findById(id).get();
		r.setEmail(reg.getEmail());
		r.setBranch(reg.getBranch());
		r.setName(reg.getName());
		return repo.save(r);
	}
}
