package com.armen.BabyName.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armen.BabyName.models.Baby;
import com.armen.BabyName.repositories.BabyRepository;

@Service
public class BabyService {
	@Autowired
	BabyRepository qRepo;
	
	// CREATE
	public Baby create(Baby newBaby) {
		return qRepo.save(newBaby);
	}
	
	// READ ALL
	public List<Baby> getAllBabys(){
		return qRepo.findAll();
	}
	// READ ONE
	public Baby getOneBaby(Long id) {
		return qRepo.findById(id).orElse( null);
	}
	
	// UPDATE
	
	// DELETE
	public void deleteBaby(Long id) {
		qRepo.deleteById(id);
	}
}
