package com.armen.SetShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.armen.SetShop.models.Item;
import com.armen.SetShop.repositories.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository qRepo;
	
	// CREATE
	public Item create(Item newItem) {
		return qRepo.save(newItem);
	}
	
	// READ ALL
	public List<Item> getAllItems(){
		return qRepo.findAll();
	}
	// READ ONE
	public Item getOneItem(Long id) {
		return qRepo.findById(id).orElse( null);
	}
	
	// UPDATE
	
	// DELETE
	public void deleteItem(Long id) {
		qRepo.deleteById(id);
	}
}
