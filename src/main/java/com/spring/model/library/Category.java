package com.spring.model.library;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Category extends BaseEntity{

	private String name;
	private String description;
	
	
}
