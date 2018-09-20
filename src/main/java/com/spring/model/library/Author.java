package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.spring.model.user.BaseEntity;

@Entity
public class Author extends BaseEntity{
	
	@OneToMany
	public Books bookName;
	public String firstName;
	public String lastName;
	public String description;
}
