package com.spring.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class LanguageInfoBean {
	

	public Long languageId;

	public Long appUserId;


}
