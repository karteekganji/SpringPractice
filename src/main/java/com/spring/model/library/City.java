package com.spring.model.library;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity	
public class City extends BaseEntity {
	
	private String cityName;
	private String cityCode;
}
