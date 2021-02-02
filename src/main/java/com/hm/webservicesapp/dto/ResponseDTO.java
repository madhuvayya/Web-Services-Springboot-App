package com.hm.webservicesapp.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	
	private int statusCode;
	
	private String message;
	
	private Object data;

	public ResponseDTO(int statusCode, String message, Object data) {
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}
}
