package com.armen.safetravels.controllers;

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

import com.armen.safetravels.models.Expenses;
import com.armen.safetravels.services.ExpenseService;

@Controller 
public class ExpensesController {
	
	@Autowired
	private ExpenseService expenseService;
	


	// --- READ ---// 
	@GetMapping("/")
	public String index(
			Model model,
			@ModelAttribute("expenseObj") Expenses exmeptyExpenses
			){
		
		//GRAB VARIABLES FROM DB
		List<Expenses> allExpenses = expenseService.allExpenses();
		
		//PASS THE ERRORS TO JSP
		model.addAttribute("expenses", allExpenses);
 		
		return"index.jsp";
	}
	
	//READ ONE//
	@GetMapping("/{id}")
	public String getOne(
			@PathVariable("id") Long id,
			Model model
			) {
		//GRAB ONE TRAVEL FROM DB
		Expenses oneExpense = expenseService.findExpense(id);
		
		//PASS THE TRAVEL TO JSP
		model.addAttribute("expenses", oneExpense);
		
		return "show.jsp";

	}
	
	
	//CREATE////
	@PostMapping("/new")
	public String createExpenses(
			@Valid @ModelAttribute("expenseObj") Expenses completedExpenses,
			BindingResult results,
			Model model
			) {
		//VALIDATIONS FAILED
		if(results.hasErrors()) {
			//GRAB ALL ERRORS 
			List<Expenses> allExpenses = expenseService.allExpenses();
			
			//PASS THE ERRORS TO JSP
			model.addAttribute("expenses", allExpenses);
			return "index.jsp";
		}
		//VALIDATIONS PASSED
		expenseService.createExpense(completedExpenses);
		return "redirect:/";	
	}
	
	
	// ------ UPDATE -------- //
	@GetMapping("/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model
			){
		// Find one object from DB
		Expenses editExpenses = expenseService.findExpense(id);
		// Pass the travel object to jsp
		model.addAttribute("expenses", editExpenses);
		
		return "edit.jsp";
	}
	
	//DELETE
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable("id") Long id
			) {
			expenseService.deleteExpense(id);
			return "redirect:/";
	
	}
	
}
