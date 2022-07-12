package com.armen.DojoNinja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.armen.DojoNinja.models.Dojo;
import com.armen.DojoNinja.services.DojoServices;

@Controller
public class DojoController {
	
	
	
	/// CALL ON THE SERVICES
	@Autowired
	private DojoServices dServ;
	
	
//////-------------READ----------------------////////
	@GetMapping("/dojos/new")
	public String index(
			Model model,
			@ModelAttribute("dojoObj") Dojo emptyDojo
			) {
		//GRAB ALL DOJOS FROM DB
		List<Dojo> allDojos = dServ.getAll();
		
		//PASS THE ERRORS TO JSP
		model.addAttribute("dojos", allDojos);
		
		return "newDojo.jsp";
	}
	
	
	@GetMapping("/dojo/{id}")
	public String getOne(
			@PathVariable("id") Long id,
			Model model
			) {
		//GRAB ONE DOJO FROM DB//
		Dojo oneDojo = dServ.readOne(id);
		
		//PASS THE DOJO TO JSP//
		model.addAttribute("dojo", oneDojo);
		
		return "viewDojo.jsp";
	}
//////-------------READ----------------------////////
	

//////-------------CREATE----------------------////////
	@PostMapping("/dojos/new")
	public String createDojo(
			@Valid @ModelAttribute("dojoObj") Dojo completedDojo,
			BindingResult results,
			Model model
			) {
		//VALIDATIONS FAILED//
		if(results.hasErrors()) {
			//GRAB ALL ERRORS //
			List<Dojo> allDojos = dServ.getAll();
			
			//PASS THE ERRORS TO JSP///
			model.addAttribute("dojo", allDojos);
			return "viewDojo.jsp";
		}
		//VALIDATIONS PASSED
		dServ.create(completedDojo);
		return "redirect:/dojos/new";	
	}
	
	
//////-------------CREATE----------------------////////
	

	
}
