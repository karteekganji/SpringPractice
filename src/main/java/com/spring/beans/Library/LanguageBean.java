package com.spring.beans.Library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class LanguageBean{
	private Long id;
	private String name;
	private Boolean isActive = Boolean.TRUE;

	
	
}
