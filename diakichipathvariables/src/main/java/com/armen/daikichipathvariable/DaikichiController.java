package com.armen.daikichipathvariable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

	
	
	@RequestMapping("/daikichi")
	public class DaikichiController {
	        @RequestMapping("")
	        public String welcome() {
	                return "Welcome!";
	        }
	        @RequestMapping("/today")
	        public String today() {
	                return "Today you will find luck in all your endevors!";
	        }
	        @RequestMapping("/tomorrow")
	        public String tomorrow() {
	                return "Today you will find luck in all your endevors!";
	        }
	        @RequestMapping("/travel/{city}")
	        public String city(@PathVariable("city") String city) {
	                return "Guess What!?!?!?!, Youre Going tooo" + city;
	        }
	        
	        @RequestMapping("/lotto/{number}")
	        public String lotto(@PathVariable("number") int number) {
	                if( number % 2 == 0) {
	                	return "You will take a grand joorney in the near future";
	                }
					return "You have enjoyed the fruits of your labor";
	        }
	        
	        

	}
	
	
	
	

