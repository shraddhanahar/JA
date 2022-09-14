package com.jupiter.city.cityDescription.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jupiter.city.cityDescription.controller.CityNotFoundException;
import com.jupiter.city.cityDescription.controller.FloorNotFoundException;
import com.jupiter.city.cityDescription.controller.SeatNotFoundException;

@ControllerAdvice
@RestController
public class CustomisedResponseEntityExceptionHandler
extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object>
	handleAllException(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CityNotFoundException.class)
	public final ResponseEntity<Object>
	handleCityNotFoundException(CityNotFoundException ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FloorNotFoundException.class)
	public final ResponseEntity<Object>
	handleFloorNotFoundException(FloorNotFoundException ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SeatNotFoundException.class)
	public final ResponseEntity<Object>
	handleSeatNotFoundException(SeatNotFoundException ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
}
