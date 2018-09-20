package com.spring.beans.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class LanguageInfoBean {
	

	public Long languageId;

	public Long appUserId;


}
