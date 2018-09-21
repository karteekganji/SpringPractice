package com.spring.model.library;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Author extends BaseEntity{
	
	public String firstName;
	public String lastName;
	public String description;
}
