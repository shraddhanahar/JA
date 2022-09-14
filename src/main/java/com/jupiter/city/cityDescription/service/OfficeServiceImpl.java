package com.jupiter.city.cityDescription.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.city.cityDescription.Entity.City;
import com.jupiter.city.cityDescription.Entity.Office;
import com.jupiter.city.cityDescription.controller.CityNotFoundException;
import com.jupiter.city.cityDescription.controller.OfficeNotFoundException;
import com.jupiter.city.cityDescription.repository.OfficeRepository;

@Service
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	private OfficeRepository officerepo;
	
	@Override
	public Office saveOffice(Office office) {
		// TODO Auto-generated method stub
		return officerepo.save(office);
	}

	@Override
	public List<Office> findAllOffice() {
		// TODO Auto-generated method stub
		return officerepo.findAll();
	}

	@Override
	public Office findOfficeById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Office> office =officerepo.findById(id);
		if(!office.isPresent())
			throw new OfficeNotFoundException("Office not available");
		return office.get();
		
		
	}

	@Override
	public void deleteOfficeById(Integer officeId) {
		// TODO Auto-generated method stub
		Optional<Office> office =officerepo.findById(officeId);
		if(!office.isPresent())
			throw new OfficeNotFoundException("Office not available");
		
		officerepo.deleteById(officeId);
	}

	@Override
	public Office updateOfficeById(Integer officeId, Office office) {
		// TODO Auto-generated method stub
		Optional<Office> officeTemp =officerepo.findById(officeId);
		if(!officeTemp.isPresent())
			throw new OfficeNotFoundException("Office not available");
		
		Office OfficeRecord = officerepo.findById(officeId).get();
		
		if(Objects.nonNull(OfficeRecord.getOfficeName())) {
			OfficeRecord.setOfficeName(office.getOfficeName());
		}
		
		if(Objects.nonNull(OfficeRecord.getCityId())) {
			OfficeRecord.setCityId(office.getCityId());
		}
		
		if(Objects.nonNull(OfficeRecord.getIsActive())) {
			OfficeRecord.setIsActive(office.getIsActive());
		}		
	
		return officerepo.save(OfficeRecord);
	}

	@Override
	public List<Office> getOfficeByCityId(City cityId) {		
		return officerepo.findByCityId(cityId);
	}

	/*@Override
	public Office getOfficeByCityId(City cityId) {
		// TODO Auto-generated method stub
		
		Office office = officerepo.findByCityId(cityId);
		return office;
	}
	*/
	
}
