package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class UserActivity extends BaseEntity{

	@ManyToOne
	private AppUser appUser;
	@ManyToOne
	private Library library;
	@ManyToOne
	private Books book;
	private Integer copies;
	
	
}
