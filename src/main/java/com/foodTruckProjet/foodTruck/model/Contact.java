package com.foodTruckProjet.foodTruck.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String email;
	
	private String message;

	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Contact(String email, String message) {
		super();
		this.email = email;
		this.message = message;
	}

	

	public Contact(int id, String email, String message) {
		super();
		this.id = id;
		this.email = email;
		this.message = message;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", email=" + email + ", message=" + message + "]";
	}

	
	
	

}
