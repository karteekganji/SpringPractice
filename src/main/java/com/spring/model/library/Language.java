package com.spring.model.library;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.beans.Library.LanguageBean;

import lombok.Data;

@Data
@Entity
public class Language extends BaseEntity{


	@Column(unique=true)
	public String name;
	
	@JsonIgnore
	public Boolean isActive = Boolean.FALSE;

}
