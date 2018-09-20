package com.spring.model.user;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.spring.beans.user.LanguageBean;

import lombok.Data;
@Data
@Entity
public class UserLanguageInfo extends BaseEntity{

	@ManyToOne
	public UserRecord appUser;
	
	@ManyToOne
	public Language language;
	
}
