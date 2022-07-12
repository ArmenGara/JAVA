package com.armen.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiForm {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/finished")
	public String FormProcess(
			HttpSession session, Model model,
		@RequestParam(value="city") String paramCity,
		@RequestParam(value="person") String paramPerson,
		@RequestParam(value="animal") String paramAnimal,
		@RequestParam(value="description") String paramDescript )
	{
		boolean formCredentials = true;
		//Store my values in session
		session.setAttribute("city", paramCity);
		session.setAttribute("person", paramPerson);
		session.setAttribute("animal", paramAnimal);
		session.setAttribute("description", paramDescript);
		// IS YOUR LOGIN CREDENTIALS GOOD
		if(formCredentials == true) {
			return "redirect:/dashboard";
		}
		else {
			return "redirect:/";
		}
		

	}
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		session.setAttribute("FormProcess", session);
		return "dashboard.jsp";
	}
}
	