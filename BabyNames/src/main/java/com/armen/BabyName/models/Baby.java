package com.armen.BabyName.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="babys")
public class Baby {
	// MEMBER VARIABLES
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	
	@NotEmpty(message="Baby Name is required!")
	@Size(min=2, max=15, message="Baby Name must be between 2 and 15 characters")
    private String name;
	
	@NotEmpty(message="Gender is required!")
    @Size(min = 0)
    private String gender;
	
	@NotEmpty(message="Orgin of name is required!")
    @Size(min = 5)
    private String orgin;
	
	@NotEmpty(message="Orgin of name is required!")
    @Size(min = 5)
    private String meaning;
	

	// RELATIONSHIPS
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User creator;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	//CONTRUCTORS
	
	public Baby() {
		
	}
	
	public Baby(Long id,
			@NotEmpty(message = "Baby Name is required!") @Size(min = 2, max = 15, message = "Baby Name must be between 2 and 15 characters") String name,
			@NotEmpty(message = "Gender is required!") @Size(min = 5) String gender,
			@NotEmpty(message = "Orgin of name is required!") @Size(min = 5) String orgin,
			@NotEmpty(message = "Orgin of name is required!") @Size(min = 5) String meaning, User creator,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.orgin = orgin;
		this.meaning = meaning;
		this.creator = creator;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	
	//GETTERS AND SETTERS //OTHER METHODS
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrgin() {
		return orgin;
	}

	public void setOrgin(String orgin) {
		this.orgin = orgin;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
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
