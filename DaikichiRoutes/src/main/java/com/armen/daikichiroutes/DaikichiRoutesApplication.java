package com.armen.daikichiroutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
public class DaikichiRoutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiRoutesApplication.class, args);
	}
	
	
	@RestController
	@RequestMapping("/daikichi")
	public class DikichiController {
	        @RequestMapping("")
	        public String welcome() {
	                return "Welcome!";
	        }
	        @RequestMapping("/today")
	        public String todat() {
	                return "Today you will find luck in all your endevors!";
	        }
	        @RequestMapping("/tomorrow")
	        public String tomorrow() {
	                return "Today you will find luck in all your endevors!";
	        }
	}
}
