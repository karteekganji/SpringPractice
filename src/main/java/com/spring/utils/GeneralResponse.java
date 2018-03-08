package com.spring.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GeneralResponse {

	public String status;

	public Object payLoad;

	public String errorMessage;

	public GeneralResponse(final String status) {
		this.status = status;
	}

	public GeneralResponse(final String status, final Object payload) {
		this.status = status;
		this.payLoad = payload;
	}

	public GeneralResponse(final String status, final String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}
}
