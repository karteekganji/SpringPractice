package com.spring.beans.Library;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.enums.Role;

import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class AppUserBean {

	public Long appUserId;

	public String name;

	public String email;

	public String mobileNumber;
	
	public String password;
	
	public String Auth;
	
	public String cityCode;
	
	public String cityName;
	
	public String gender;
	
	public Boolean isActive;
	
	public Role role;
	
}
