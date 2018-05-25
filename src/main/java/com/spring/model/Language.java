package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Language extends BaseEntity{


	@Column(unique=true)
	public String name;
	
	public Boolean isDeleted = Boolean.FALSE;

}
