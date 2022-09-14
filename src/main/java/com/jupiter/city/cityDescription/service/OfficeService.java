package com.jupiter.city.cityDescription.service;

import java.util.List;

import com.jupiter.city.cityDescription.Entity.City;
import com.jupiter.city.cityDescription.Entity.Office;

public interface OfficeService {

	public Office saveOffice(Office office);

	public List<Office> findAllOffice();

	public Office findOfficeById(Integer id);

	public void deleteOfficeById(Integer officeId);

	public Office updateOfficeById(Integer officeId, Office office);

	public List<Office> getOfficeByCityId(City cityId);
	
	//public Office getOfficeByCityId(City cityId);

}
