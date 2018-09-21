package com.spring.model.library;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Library extends BaseEntity{

	public String name;
	public String address;
	public String city;
	public Boolean isActive = Boolean.TRUE;
	
}
