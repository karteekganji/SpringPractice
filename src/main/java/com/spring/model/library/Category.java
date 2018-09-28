package com.spring.model.library;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Category extends BaseEntity{

	public String name;
	public String description;
	
	
}
