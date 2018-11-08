package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class UserActivity extends BaseEntity{

	@ManyToOne
	public AppUser appUser;
	@ManyToOne
	public Library library;
	@ManyToOne
	public Books book;
	
	public Integer copies;
	
	
}
