package com.jupiter.city.cityDescription.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SeatNotFoundException extends RuntimeException {
	
	public SeatNotFoundException(String message){
		super(message);	
	}
}
