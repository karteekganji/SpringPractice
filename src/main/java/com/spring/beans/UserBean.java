package com.spring.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class UserBean {

	public Long appUserId;

	public String name;

	public String email;

	public String mobileNumber;
	
	public String password;
	
	public String Auth;

	public String employeeId;

	public List<Object> userData = new ArrayList<>();
	
	public List<LanguageBean> userLanguageInfos;
	
}
