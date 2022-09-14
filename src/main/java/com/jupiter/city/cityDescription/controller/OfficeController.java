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
import com.jupiter.city.cityDescription.repository.OfficeRepository;
import com.jupiter.city.cityDescription.service.OfficeService;
@RestController
public class OfficeController {

	@Autowired	
	private OfficeService officeservice;	
		
		@GetMapping("/office")
		public java.util.List<Office> find(){
			return officeservice.findAllOffice();
			
		}
		@GetMapping("/office/id")
		public Office findById(@RequestHeader(value="id") Integer officeId){
			return officeservice.findOfficeById(officeId);
			
		}
		
		@DeleteMapping("/office/{id}")
		public String deleteById(@PathVariable("id") Integer officeId){
			 officeservice.deleteOfficeById(officeId);
			 return "office record deleted successfully";
			
		}
		
		@PutMapping("/office/{id}")
		public Office UpdateById(@PathVariable("id") Integer officeId,@RequestBody Office office){
			return officeservice.updateOfficeById(officeId,office);
			  
			
		}
		
		@PostMapping("/office")
		public Office add(@RequestBody Office office)
		{
			return officeservice.saveOffice(office);
			
		 
			//return ResponseEntity.created(location).build();
		}
		
		@GetMapping("/office/city/id")
		public List<Office> get(@RequestHeader(value="id") City cityId)
		{
			return officeservice.getOfficeByCityId(cityId);
		}

}
