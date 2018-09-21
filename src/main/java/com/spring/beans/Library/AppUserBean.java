package com.spring.beans.Library;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.model.library.City;

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
	
	public String city;
	
	public String gender;
	
	public Boolean isActive;

	public List<Object> userData = new ArrayList<>();
	
	
}
