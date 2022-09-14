package com.jupiter.city.cityDescription.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jupiter.city.cityDescription.Entity.SeatType;
import com.jupiter.city.cityDescription.service.SeatTypeService;

@RestController
public class SeatTypeController {

	@Autowired	
	private SeatTypeService seatTypeservice;	
		
		@GetMapping("/seatType")
		public java.util.List<SeatType> find(){
			return seatTypeservice.findAllSeatType();
			
		}
		@GetMapping("/seatType/{id}")
		public SeatType findById(@PathVariable("id") Integer seatTypeId){
			return seatTypeservice.findSeatTypeById(seatTypeId);
			
		}
		
		@DeleteMapping("/seatType/{id}")
		public String deleteById(@PathVariable("id") Integer seatTypeId){
			 seatTypeservice.deleteSeatTypeById(seatTypeId);
			 return "seatType record deleted successfully";
			
		}
		
		@PutMapping("/seatType/{id}")
		public SeatType UpdateById(@PathVariable("id") Integer seatTypeId,@RequestBody SeatType seatType){
			return seatTypeservice.updateSeatTypeById(seatTypeId,seatType);
			  
			
		}
		
		@PostMapping("/seatType")
		public SeatType add(@RequestBody SeatType seatType)
		{
			return seatTypeservice.saveSeatType(seatType);
			
		 
			//return ResponseEntity.created(location).build();
		}
}
