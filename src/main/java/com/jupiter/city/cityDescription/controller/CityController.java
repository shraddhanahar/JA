package com.jupiter.city.cityDescription.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jupiter.city.cityDescription.Entity.City;
//import com.jupiter.city.cityDescription.controller.Exception.CityNotFoundException;
import com.jupiter.city.cityDescription.repository.CityRepository;
import com.jupiter.city.cityDescription.service.CityService;

@RestController
public class CityController {

	@Autowired	
	private CityService cityservice;	
		
		@GetMapping("/city")
		public java.util.List<City> find(){
			return cityservice.findAllCity();
			
		}
		
		@GetMapping("/city/id")
		public City findById(@RequestHeader(value="id") int id){
			return cityservice.findCityById(id);			
		}
		
		@DeleteMapping("/city/{id}")
		public String deleteById(@PathVariable("id") Integer cityId){
			 cityservice.deleteCityById(cityId);
			 return "City record deleted successfully";
			
		}
		
		@PutMapping("/city/{id}")
		public City UpdateById(@PathVariable("id") Integer cityId,@RequestBody City city){
			return cityservice.updateCityById(cityId,city);
			  
			
		}
		
		@PostMapping("/city")
		public ResponseEntity<Object> add(@RequestBody City city)
		{
			City cityRecord = cityservice.saveCity(city);
		            URI location = ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}")
					.buildAndExpand(cityRecord.getCityId())
					.toUri();
			return ResponseEntity.created(location).build();
			
		 
			//return ResponseEntity.created(location).build();
		}

}
