package com.spring.model.library;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Entity
@JsonInclude(Include.NON_NULL)
public class Publisher extends BaseEntity{

	private String name;
	private String description;
	private Boolean isActive = Boolean.TRUE;
	
}
