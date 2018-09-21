package com.spring.beans.Library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class LanguageBean{
	
	public Long languageId;

	public String languageTitle;
	
	public boolean isDeleted;

	
	
}
