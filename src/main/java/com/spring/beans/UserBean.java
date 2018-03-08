package com.spring.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class UserBean {
	
	public Long appUserId;

	public String name;

	public String email;

	public String mobileNumber;
	
	public String employeeId;
}
