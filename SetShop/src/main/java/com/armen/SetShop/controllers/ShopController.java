package com.armen.SetShop.controllers;

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

import com.armen.SetShop.models.Shop;
import com.armen.SetShop.models.User;
import com.armen.SetShop.services.ShopService;
import com.armen.SetShop.services.UserService;

@Controller
public class ShopController {
	@Autowired
	ShopService qServ;
	
	@Autowired
	UserService uServ;
	
	// --------------------- READ ------------------------------//
	@GetMapping("/shops")
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
		model.addAttribute("allShops", qServ.getAllShops());
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
		Shop OkayShop = qServ.getOneShop(id);
		
		model.addAttribute("shopObj", OkayShop);
		model.addAttribute("watermelon", user);
		return "profile.jsp";
	}
	
	// --------------------- READ ------------------------------//
	// -------------------- CREATE ------------------------//
	@GetMapping("/shops/new")
	public String newShop(
		@ModelAttribute("shopObj") Shop emptyShop,
		HttpSession session
	) {
		// MAKE SURE THE USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "newShop.jsp";
	}
	
	@PostMapping("/shops/new")
	public String createShop(
		@Valid @ModelAttribute("shopObj") Shop filledShop,
		BindingResult results
	) {
		// VALIDATIONS FAIL
		if(results.hasErrors()) {
			return "newShop.jsp";
		}
		// VALIDATIONS PASS
		qServ.create(filledShop);
		return "redirect:/shops";
	}
	// -------------------- CREATE ------------------------//
	
	// -------------------- UPDATE ------------------------//
	@GetMapping("/shops/{id}/edit")
	public String editShop(
		@PathVariable("id") Long id, Model model,
		HttpSession session
	) {
		// MAKE SURE THE USER IS LOGGED IN
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		// GET THE SHOP FROM DB
		Shop editShop = qServ.getOneShop(id);
		model.addAttribute("shopObj", editShop);
		return "editShop.jsp";
	}
	
	@PutMapping("/shops/{id}/edit")
	public String updateShop(
		@Valid @ModelAttribute("shopObj") Shop updatedShop,
		BindingResult results
	) {
		if(results.hasErrors()) {
			return "editShop.jsp";
		}
		qServ.create(updatedShop);
		return "redirect:/shops";
	}
	
	
	// -------------------- UPDATE ------------------------//
	
	// -------------------- DELETE ------------------------//
	@DeleteMapping("/shops/{id}")
	public String deleteShop(
		@PathVariable("id") Long id
	) {
		qServ.deleteShop(id);
		return "redirect:/shops";
	}
	
	@GetMapping("/shops/{id}")
	public String deleteShopGET(
			@PathVariable("id") Long id
		) {
			qServ.deleteShop(id);
			return "redirect:/shops";
		}
	
	// -------------------- DELETE ------------------------//
	
	
	
	
	
}