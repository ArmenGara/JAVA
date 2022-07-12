package com.armen.DojoNinja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armen.DojoNinja.models.Dojo;
import com.armen.DojoNinja.repositories.DojoRepo;



@Service
public class DojoServices {
	
	@Autowired
	private DojoRepo dRepo;
	
	///------Get All -------///
	public List<Dojo> getAll() {
		return dRepo.findAll();
	}
	
	///------Get One ------///
	public Dojo readOne(Long id) {
		Optional<Dojo> dojoOpt = dRepo.findById(id);
		return dojoOpt.isPresent() ? dojoOpt.get() : null;
	}
	
	///-----Create --------///
	
	public Dojo create(Dojo doj) {
		return dRepo.save(doj);
	}
	
	
	
	///------Update --------////
	public Dojo update(Dojo doj) {
		return dRepo.save(doj);
	}
	
	
	///----Delete -------////
	public void deleteOne(Long id) {
		dRepo.deleteById(id);
	}
}
