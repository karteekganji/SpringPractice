package com.spring.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class LanguageBean{
	
	public Long languageId;

	public String languageTitle;
	
	public boolean isDeleted;

	
	
}
