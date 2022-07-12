package com.armen.BookClub.controllers;

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

import com.armen.BookClub.models.Book;
import com.armen.BookClub.models.User;
import com.armen.BookClub.services.BookService;
import com.armen.BookClub.services.UserService;

@Controller
	public class BookController {
		@Autowired
		BookService qServ;
		
		@Autowired
		UserService uServ;
		
		// --------------------- READ ------------------------------//
		@GetMapping("/books")
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
			model.addAttribute("allBooks", qServ.getAllBooks());
			return "dashboard.jsp";
		}
		
		@GetMapping("/profile")
		public String profile(
			Model model, HttpSession session
		) {
			// MAKE SURE THE USER IS LOGGED IN
			if(session.getAttribute("user_id") == null) {
				return "redirect:/";
			}
			Long user_id = (Long) session.getAttribute("user_id");
			User user = uServ.getOneUser(user_id);
			
			model.addAttribute("watermelon", user);
			return "profile.jsp";
		}
		
		// --------------------- READ ------------------------------//
		// -------------------- CREATE ------------------------//
		@GetMapping("/books/new")
		public String newBook(
			@ModelAttribute("bookObj") Book emptyBook,
			HttpSession session
		) {
			// MAKE SURE THE USER IS LOGGED IN
			if(session.getAttribute("user_id") == null) {
				return "redirect:/";
			}
			return "newBook.jsp";
		}
		
		@PostMapping("/books/new")
		public String createBook(
			@Valid @ModelAttribute("bookObj") Book filledBook,
			BindingResult results
		) {
			// VALIDATIONS FAIL
			if(results.hasErrors()) {
				return "newBook.jsp";
			}
			// VALIDATIONS PASS
			qServ.create(filledBook);
			return "redirect:/books";
		}
		// -------------------- CREATE ------------------------//
		
		// -------------------- UPDATE ------------------------//
		@GetMapping("/books/{id}/edit")
		public String editBook(
			@PathVariable("id") Long id, Model model,
			HttpSession session
		) {
			// MAKE SURE THE USER IS LOGGED IN
			if(session.getAttribute("user_id") == null) {
				return "redirect:/";
			}
			// GET THE BOOK FROM DB
			Book editBook = qServ.getOneBook(id);
			model.addAttribute("bookObj", editBook);
			return "editBook.jsp";
		}
		
		@PutMapping("/books/{id}/edit")
		public String updateBook(
			@Valid @ModelAttribute("bookObj") Book updatedBook,
			BindingResult results
		) {
			if(results.hasErrors()) {
				return "editBook.jsp";
			}
			qServ.create(updatedBook);
			return "redirect:/books";
		}
		
		
		// -------------------- UPDATE ------------------------//
		
		// -------------------- DELETE ------------------------//
		@DeleteMapping("/books/{id}")
		public String deleteBook(
			@PathVariable("id") Long id
		) {
			qServ.deleteBook(id);
			return "redirect:/books";
		}
		
		@GetMapping("/books/{id}")
		public String deleteBookGET(
				@PathVariable("id") Long id
			) {
				qServ.deleteBook(id);
				return "redirect:/books";
			}
		
		// -------------------- DELETE ------------------------//
		
		
		
		
		
	}

