package com.spring.beans.Library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.enums.Role;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class AppUserBean {

	private Long appUserId;

	private String name;

	private String email;

	private String mobileNumber;
	
	private String password;
	
	private String confirmPassword;
	
	private String Auth;
	
	private String cityCode;
	
	private String cityName;
	
	private String gender;
	
	private Boolean isActive;
	
	private Role role;
	
	private String passwordKey;
	
}
