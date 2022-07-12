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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="shops")
public class Shop {
	// MEMBER VARIABLES
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	
	@NotEmpty(message="Shop Name is required!")
	@Size(min=2, max=15, message="Shop Name must be between 2 and 15 characters")
    private String name;
	
	@NotEmpty(message="Description is required!")
    @Size(min = 5)
    private String description;
	
	

	// RELATIONSHIPS
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User creator;

	
	//RELATIONSHIPS
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//RELATIONSHIP WITH ITEMS 
	@OneToMany(mappedBy="items", fetch=FetchType.LAZY)
	private List<Item> items;
	
	//RELATIONSHIP WITH RATING
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "ratings", 
        joinColumns = @JoinColumn(name = "shop_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
	
	
	//CONTRUCTORS
	
	public Shop() {
		
	}
	
	public Shop(Long id,
			@NotEmpty(message = "Shop Name is required!") @Size(min = 2, max = 15, message = "Shop Name must be between 2 and 15 characters") String name,
			@NotEmpty(message = "Description is required!") @Size(min = 5) String description, User creator,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.creator = creator;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	///GETTERS //SETTERS //OTHER METHODS

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
}
