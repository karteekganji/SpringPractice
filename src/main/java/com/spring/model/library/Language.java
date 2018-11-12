package com.spring.model.library;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class Language extends BaseEntity{


	@Column(unique=true)
	private String name;
	
	@JsonIgnore
	private Boolean isActive = Boolean.FALSE;

}
