package com.spring.model.library;

import javax.persistence.Entity;

import com.spring.model.user.BaseEntity;

@Entity
public class Category extends BaseEntity{

	public String name;
	public String description;
	
}
