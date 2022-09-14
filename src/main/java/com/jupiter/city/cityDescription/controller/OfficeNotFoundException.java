package com.jupiter.city.cityDescription.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OfficeNotFoundException extends RuntimeException {
	
	public OfficeNotFoundException(String message){
		super(message);	
	}
}
