package com.jupiter.city.cityDescription.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.city.cityDescription.Entity.City;
import com.jupiter.city.cityDescription.controller.CityNotFoundException;
import com.jupiter.city.cityDescription.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityrepo;
	
	@Override
	public City saveCity(City city) {
		// TODO Auto-generated method stub
		return cityrepo.save(city);
	}

	@Override
	public List<City> findAllCity() {
		// TODO Auto-generated method stub
		return cityrepo.findAll();
	}

	@Override
	public City findCityById(Integer id) {
		// TODO Auto-generated method stub
		 Optional<City> city =cityrepo.findById(id);
		if(!city.isPresent())
			throw new CityNotFoundException("City not available");
		return city.get();
		
	}

	@Override
	public void deleteCityById(Integer cityId) {
		// TODO Auto-generated method stub
		Optional<City> city =cityrepo.findById(cityId);
		if(!city.isPresent())
			throw new CityNotFoundException("City not available");
		cityrepo.deleteById(cityId);
	}

	@Override
	public City updateCityById(Integer cityId, City city) {
		// TODO Auto-generated method stub
		Optional<City> cityTemp =cityrepo.findById(cityId);
		if(!cityTemp.isPresent())
			throw new CityNotFoundException("City not available");
		City cityRecord = cityrepo.findById(cityId).get();
		
		if(Objects.nonNull(cityRecord.getCityName())) {
			cityRecord.setCityName(city.getCityName());
		}
		
		if(Objects.nonNull(cityRecord.getCountry())) {
			cityRecord.setCountry(city.getCountry());
		}
		
		if(Objects.nonNull(cityRecord.getIsActive())) {
			cityRecord.setIsActive(city.getIsActive());
		}
		
		if(Objects.nonNull(cityRecord.getPincode())) {
			cityRecord.setPincode(city.getPincode());
		}
		
		if(Objects.nonNull(cityRecord.getStateName())) {
			cityRecord.setStateName(city.getStateName());
		}
		
		return cityrepo.save(cityRecord);
	}
	
}
