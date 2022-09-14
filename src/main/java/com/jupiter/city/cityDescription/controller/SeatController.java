package com.jupiter.city.cityDescription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jupiter.city.cityDescription.Entity.Building;
import com.jupiter.city.cityDescription.Entity.City;
import com.jupiter.city.cityDescription.Entity.Floor;
import com.jupiter.city.cityDescription.Entity.Office;
import com.jupiter.city.cityDescription.Entity.Seat;
import com.jupiter.city.cityDescription.repository.BuildingRepository;
import com.jupiter.city.cityDescription.repository.SeatRepository;
import com.jupiter.city.cityDescription.service.SeatService;


@RestController
public class SeatController {

	@Autowired	
	private SeatService seatservice;	
		
		@GetMapping("/seat")
		public List<Seat> find(){
			return seatservice.findAllSeat();
			
		}
		@GetMapping("/seat/{id}")
		public Seat findById(@PathVariable("id") Integer seatId){
			return seatservice.findSeatById(seatId);
			
		}
		
		@DeleteMapping("/seat/{id}")
		public String deleteById(@PathVariable("id") Integer seatId){
			 seatservice.deleteSeatById(seatId);
			 return "seat record deleted successfully";
			
		}
		
		@PutMapping("/seat/{id}")
		public Seat UpdateById(@PathVariable("id") Integer seatId,@RequestBody Seat seat){
			return seatservice.updateSeatById(seatId, seat);
			  
			
		}
		
		@PostMapping("/seat")
		public Seat add(@RequestBody Seat seat)
		{
			return seatservice.saveSeat(seat);
		}
		
		@GetMapping("seat/floor/{Id}")
		public List<Seat> get(@PathVariable Floor Id)
		{
			return seatservice.getOfficeByFloorId(Id);
		}
		
}