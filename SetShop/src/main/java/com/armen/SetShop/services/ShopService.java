package com.armen.SetShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armen.SetShop.models.Shop;
import com.armen.SetShop.repositories.ShopRepository;

@Service
public class ShopService {
	@Autowired
	ShopRepository qRepo;
	
	// CREATE
	public Shop create(Shop newShop) {
		return qRepo.save(newShop);
	}
	
	// READ ALL
	public List<Shop> getAllShops(){
		return qRepo.findAll();
	}
	// READ ONE
	public Shop getOneShop(Long id) {
		return qRepo.findById(id).orElse( null);
	}
	
	// UPDATE
	
	// DELETE
	public void deleteShop(Long id) {
		qRepo.deleteById(id);
	}
}