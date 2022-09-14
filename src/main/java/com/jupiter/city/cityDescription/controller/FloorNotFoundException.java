package com.jupiter.city.cityDescription.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FloorNotFoundException extends RuntimeException {
	
	public FloorNotFoundException(String message){
		super(message);	
	}
}
