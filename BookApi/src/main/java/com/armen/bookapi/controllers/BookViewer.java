package com.armen.bookapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookViewer {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
}
