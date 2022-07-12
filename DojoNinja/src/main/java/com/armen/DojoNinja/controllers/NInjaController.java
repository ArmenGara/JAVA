package com.armen.DojoNinja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.armen.DojoNinja.models.Dojo;
import com.armen.DojoNinja.models.Ninja;
import com.armen.DojoNinja.services.DojoServices;
import com.armen.DojoNinja.services.NinjaServices;

@Controller
public class NInjaController {
	@Autowired
	private DojoServices dServ;
	
	@Autowired
	private NinjaServices nServ;
	
	
	///---------------------READ----------------------------////
	@GetMapping("ninjas/new")
	public String index(
			Model model,
			@ModelAttribute("ninjaObj") Ninja emptyNinja
			) {
		//GRAB ALL DOJOS FROM DB
		List<Dojo> allDojos = dServ.getAll();
		
		//PASS THE DOJOS TO JSP
		model.addAttribute("dojos", allDojos);
		
		return "newNinja.jsp";
	}
	
	///---------------------READ----------------------------////
	
	
	///---------------------CREATE------------------------------////
	@PostMapping("/ninja/new")
	public String createNinja(
			@Valid @ModelAttribute("ninjaObj") Ninja completedNinja,
			BindingResult results,
			Model model
			) {
		//VALIDATIONS FAILED
		if(results.hasErrors()) {
			//GRAB ALL ERRORS 
			List<Ninja> allNinjas = nServ.getAll();
			
			//PASS THE ERRORS TO JSP
			model.addAttribute("ninjas", allNinjas);
			//GRAB ALL DOJOA FROM DB
			List<Dojo> allDojos = dServ.getAll();
			
			//PASS THE DOJOS TO JSP
			model.addAttribute("dojos", allDojos);
			
			return "newNinja.jsp";
		}
		//VALIDATIONS PASSED
		nServ.create(completedNinja);
		return "redirect:/ninjas/new";	
	}
	///---------------------CREATE------------------------------////

}
