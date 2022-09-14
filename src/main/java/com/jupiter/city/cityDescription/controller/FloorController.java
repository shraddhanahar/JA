package com.jupiter.city.cityDescription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jupiter.city.cityDescription.service.FloorService;
import com.jupiter.city.cityDescription.Entity.Building;
//import com.jupiter.floor.floorDescription.Entity.Building;
//import com.jupiter.floor.floorDescription.Entity.floor;
import com.jupiter.city.cityDescription.Entity.Floor;
import com.jupiter.city.cityDescription.service.FloorService;

@RestController
public class FloorController {
	@Autowired	
	private FloorService floorservice;	
		
		@GetMapping("/floor")
		public java.util.List<Floor> find(){
			return floorservice.findAllFloor();
			
		}
		
		@GetMapping("/floor/id")
		public Floor findById(@RequestHeader(value="id") Integer floorId){
			return floorservice.findFloorById(floorId);
			
		}
		
		@DeleteMapping("/floor/{id}")
		public String deleteById(@PathVariable("id") Integer floorId){
			 floorservice.deleteFloorById(floorId);
			 return "Floor record deleted successfully";
			
		}
		
		@PutMapping("/floor/{id}")
		public Floor UpdateById(@PathVariable("id") Integer floorId,@RequestBody Floor floor){
			return floorservice.updateFloorById(floorId,floor);
			  
			
		}
		
		@PostMapping("/floor")
		public Floor add(@RequestBody Floor floor)
		{
			return floorservice.saveFloor(floor);
			
		 
			//return ResponseEntity.created(location).build();
		}
		
		@GetMapping("floor/building/id")
		public List<Floor> getByBuildingId(@RequestHeader(value="id") Building Id)
		{
			return floorservice.getFloorByBuildingId(Id);
		}
}
