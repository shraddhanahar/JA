package com.jupiter.city.cityDescription.service;

import java.util.List;

import com.jupiter.city.cityDescription.Entity.City;
import com.jupiter.city.cityDescription.controller.CityNotFoundException;

public interface CityService {

	public City saveCity(City city);

	public List<City> findAllCity();

	public City findCityById(Integer id);

	public void deleteCityById(Integer cityId);

	public City updateCityById(Integer cityId, City city);

}
