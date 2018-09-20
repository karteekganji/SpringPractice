package com.spring.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.spring.beans.user.LanguageBean;

import lombok.Data;

@Data
@Entity
public class Language extends BaseEntity{


	@Column(unique=true)
	public String name;
	
	public Boolean isDeleted = Boolean.FALSE;

}
