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

import com.jupiter.city.cityDescription.Entity.Building;
import com.jupiter.city.cityDescription.Entity.City;
import com.jupiter.city.cityDescription.Entity.Office;
import com.jupiter.city.cityDescription.repository.BuildingRepository;
import com.jupiter.city.cityDescription.repository.CityRepository;
import com.jupiter.city.cityDescription.service.BuildingService;
import com.jupiter.city.cityDescription.service.CityService;

@RestController
public class BuildingController {

			
	@Autowired	
	private BuildingService cityservice;	
		
		@GetMapping("/building")
		public java.util.List<Building> find(){
			return cityservice.findAllBuilding();
			
		}
		
		@GetMapping("/building/id")
		public Building findById(@RequestHeader(value="id") Integer buildingId){
			return cityservice.findBuildingById(buildingId);
			
		}
		
		@DeleteMapping("/building/{id}")
		public String deleteById(@PathVariable("id") Integer buildingId){
			 cityservice.deleteBuildingById(buildingId);
			 return "Building record deleted successfully";
			
		}
		
		@PutMapping("/building/{id}")
		public Building UpdateById(@PathVariable("id") Integer buildingId,@RequestBody Building building){
			return cityservice.updateBuildingById(buildingId,building);
			  
			
		}
		
		@PostMapping("/building")
		public Building add(@RequestBody Building building)
		{
			return cityservice.saveBuilding(building);
			
		 
			//return ResponseEntity.created(location).build();
		}

		@GetMapping("building/office/id")
		public List<Building> get(@RequestHeader(value="id") Office officeId)
		{
			return cityservice.getBuildingByOfficeId(officeId);
		}
		

}
