package com.jupiter.city.cityDescription.exception;

import java.util.Date;

//import com.jupiter.city.citydetails.Entity.City;

public class ExceptionResponse{
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getdetails() {
		return details;
	}
	public void setdetails(String details) {
		this.details = details;
	}
	private Date timestamp;
	private String message;
	private String details;
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
