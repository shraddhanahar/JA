package com.jupiter.city.cityDescription.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SeatTypeNotFoundException extends RuntimeException {
	
	public SeatTypeNotFoundException(String message){
		super(message);	
	}
}
