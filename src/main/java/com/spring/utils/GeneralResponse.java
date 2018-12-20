package com.spring.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class GeneralResponse {

	private String status;

	private Object payLoad;

	private String errorMessage;
	
	private Exception exception;

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
	public GeneralResponse(final String status, final Exception errorMessage) {
		this.status = status;
		this.exception = errorMessage;
	}
}
