package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRecord {

		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    public Long id;  
		public String name; 
		public String email;  
		public String mobileNumber;
		public String employeeId;
		
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
	    public String getEmail() {
	        return email;  
	    }  
	    public void setEmail(String email) {
	        this.email = email;  
	    }  

}
