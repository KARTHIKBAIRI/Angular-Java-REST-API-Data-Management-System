package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.registration;

@Repository
public interface registrationrepo extends CrudRepository<registration, Integer>{

	registration findByEmail(String email);

}
