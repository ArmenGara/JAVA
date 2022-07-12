package com.armen.SetShop.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="items")
public class Item {

	
	
	//MEMBER VARIABLES 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Shop Name is required!")
	@Size(min=2, max=15, message="Shop Name must be between 2 and 15 characters")
	private String itemName;
	
	
	
	@NotEmpty(message="Shop description is required!")
	@Size(min=2, max=15, message="Shop description must be between 2 and 15 characters")
	private String description;
	
	@NotEmpty(message="Shop qautity is required!")
	@Size(min=2, max=15, message="Shop description must be between 2 and 15 characters")
	private Integer quantity;
	
	@NotEmpty(message="Description is required!")
    @Size(min = 5)
	private Integer price;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	//RELATIONSHIPS
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="items")
    private Item items;
    
    
	//RELATIONSHIP WITH RATING
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ratings", 
        joinColumns = @JoinColumn(name = "shops_id"), 
        inverseJoinColumns = @JoinColumn(name = "items_id")
    )
    private List<User> users;
	
	
	
	//CONSTRUCTORS 
	//FULL
	public Item(Long id,
			@NotEmpty(message = "Shop Name is required!") @Size(min = 2, max = 15, message = "Shop Name must be between 2 and 15 characters") String itemName,
			@NotEmpty(message = "Shop description is required!") @Size(min = 2, max = 15, message = "Shop description must be between 2 and 15 characters") String description,
			@NotEmpty(message = "Shop qautity is required!") @Size(min = 2, max = 15, message = "Shop description must be between 2 and 15 characters") Integer quantity,
			@NotEmpty(message = "Description is required!") @Size(min = 5) Integer price) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	
	//EMPTY
	public Item() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}	
	
	
}
