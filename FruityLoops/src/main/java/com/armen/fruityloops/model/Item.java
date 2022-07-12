package com.armen.fruityloops.model;

public class Item{
	
	public String name;
	public double price;
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	
	public Item() {
		
	}


	
//GETTERS AND SETTERS 	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
}
