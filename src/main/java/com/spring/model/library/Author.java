package com.spring.model.library;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Entity
@JsonInclude(Include.NON_NULL)
public class Author extends BaseEntity{
	
	@OneToOne(cascade = CascadeType.ALL)
	private AppUser appUser;
}
