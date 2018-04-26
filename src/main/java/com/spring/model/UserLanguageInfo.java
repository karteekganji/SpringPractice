package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UserLanguageInfo extends BaseEntity{

	@ManyToOne
	public UserRecord appUser;
	
	@ManyToOne
	public Language language;
	
}
