package com.armen.DojoNinja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armen.DojoNinja.models.Ninja;
import com.armen.DojoNinja.repositories.NinjaRepo;


@Service
public class NinjaServices {
	@Autowired
	private NinjaRepo nRepo;
	
	///-------GET ALL---------///
	
	public List<Ninja> getAll() {
		return nRepo.findAll();
	}
	
	///-------GET ONE --------///
	
	public Ninja readOne(Long id) {
		Optional<Ninja> ninjaOpt = nRepo.findById(id);
		return ninjaOpt.isPresent() ? ninjaOpt.get() : null ;
		
	}
	
	/// ------Create ---------- ///
	public Ninja create(Ninja nin) {
		return nRepo.save(nin);
	}
	
	///-------Update -----------///
	public Ninja updateOne(Ninja nin) {
		return nRepo.save(nin);
	}
		
		
	///-------Delete------------///
		
	public void deleteOne(long id) {
		nRepo.deleteById(id);
	}
	
	
	
}
