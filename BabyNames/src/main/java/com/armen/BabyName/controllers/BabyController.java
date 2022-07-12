package com.armen.BabyName.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.armen.BabyName.models.Baby;
import com.armen.BabyName.models.User;
import com.armen.BabyName.services.BabyService;
import com.armen.BabyName.services.UserService;

@Controller
public class BabyController {
	@Autowired
	BabyService qServ;
	
	@Autowired
	UserService uServ;
	
	// --------------------- READ ------------------------------//
	@GetMapping("/babys")
	public String dashboard(
		Model model, HttpSession session
	) {
		// MAKE SURE THE USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		// GRAB THE LOGGED IN USER'S ID
		Long user_id = (Long) session.getAttribute("user_id");
		
		// GRAB THE USER OBJECT FROM DB AND PASS TO JSP
		model.addAttribute("user", uServ.getOneUser(user_id));
		
		// GRAB THE USER OBJECT FROM DB AND PASS TO JSP
		model.addAttribute("allBabys", qServ.getAllBabys());
		return "dashboard.jsp";
	}
	
	@GetMapping("/profile/{id}")
	public String profile(
		Model model,
		HttpSession session,
		@PathVariable("id") Long id
	) {
		
		// MAKE SURE THE USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long user_id = (Long) session.getAttribute("user_id");
		User user = uServ.getOneUser(user_id);
		Baby OkayBaby = qServ.getOneBaby(id);
		
		model.addAttribute("babyObj", OkayBaby);
		model.addAttribute("watermelon", user);
		return "profile.jsp";
	}
	
	// --------------------- READ ------------------------------//
	// -------------------- CREATE ------------------------//
	@GetMapping("/babys/new")
	public String newBaby(
		@ModelAttribute("babyObj") Baby emptyBaby,
		HttpSession session
	) {
		// MAKE SURE THE USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "newBaby.jsp";
	}
	
	@PostMapping("/babys/new")
	public String createBaby(
		@Valid @ModelAttribute("babyObj") Baby filledBaby,
		BindingResult results
	) {
		// VALIDATIONS FAIL
		if(results.hasErrors()) {
			return "newBaby.jsp";
		}
		// VALIDATIONS PASS
		qServ.create(filledBaby);
		return "redirect:/babys";
	}
	// -------------------- CREATE ------------------------//
	
	// -------------------- UPDATE ------------------------//
	@GetMapping("/babys/{id}/edit")
	public String editBaby(
		@PathVariable("id") Long id, Model model,
		HttpSession session
	) {
		// MAKE SURE THE USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		// GET THE BABY FROM DB
		Baby editBaby = qServ.getOneBaby(id);
		model.addAttribute("babyObj", editBaby);
		return "editBaby.jsp";
	}
	
	@PutMapping("/babys/{id}/edit")
	public String updateBaby(
		@Valid @ModelAttribute("babyObj") Baby updatedBaby,
		BindingResult results
	) {
		if(results.hasErrors()) {
			return "editBaby.jsp";
		}
		qServ.create(updatedBaby);
		return "redirect:/babys";
	}
	
	
	// -------------------- UPDATE ------------------------//
	
	// -------------------- DELETE ------------------------//
	@DeleteMapping("/babys/{id}")
	public String deleteBaby(
		@PathVariable("id") Long id
	) {
		qServ.deleteBaby(id);
		return "redirect:/babys";
	}
	
	@GetMapping("/babys/{id}")
	public String deleteBabyGET(
			@PathVariable("id") Long id
		) {
			qServ.deleteBaby(id);
			return "redirect:/babys";
		}
	
	// -------------------- DELETE ------------------------//
	
	
	
	
	
}
