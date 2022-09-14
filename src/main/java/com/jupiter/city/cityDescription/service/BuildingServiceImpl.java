package com.jupiter.city.cityDescription.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.city.cityDescription.Entity.Building;
import com.jupiter.city.cityDescription.Entity.City;
import com.jupiter.city.cityDescription.Entity.Office;
import com.jupiter.city.cityDescription.controller.BuildingNotFoundException;
import com.jupiter.city.cityDescription.controller.CityNotFoundException;
import com.jupiter.city.cityDescription.repository.BuildingRepository;
import com.jupiter.city.cityDescription.repository.CityRepository;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingrepo;
	
	@Override
	public Building saveBuilding(Building building) {
		// TODO Auto-generated method stub
		return buildingrepo.save(building);
	}

	@Override
	public List<Building> findAllBuilding() {
		// TODO Auto-generated method stub
		return buildingrepo.findAll();
	}

	@Override
	public Building findBuildingById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Building> building =buildingrepo.findById(id);
		if(!building.isPresent())
			throw new BuildingNotFoundException("Building not available");
		return buildingrepo.findById(id).get();
		
	}

	@Override
	public void deleteBuildingById(Integer buildingId) {
		// TODO Auto-generated method stub
		Optional<Building> building =buildingrepo.findById(buildingId);
		if(!building.isPresent())
			throw new BuildingNotFoundException("Building not available");
		buildingrepo.deleteById(buildingId);
	}

	@Override
	public Building updateBuildingById(Integer buildingId, Building building) {
		// TODO Auto-generated method stub
		Optional<Building> buildingTemp =buildingrepo.findById(buildingId);
		if(!buildingTemp.isPresent())
			throw new BuildingNotFoundException("Building not available");
		Building buildingrecord = buildingrepo.findById(buildingId).get();
		
		if(Objects.nonNull(buildingrecord.getBuildingName())) {
			buildingrecord.setBuildingName(building.getBuildingName());
		}
		
		if(Objects.nonNull(buildingrecord.getIsActive())) {
			buildingrecord.setIsActive(building.getIsActive());
		}
		
		if(Objects.nonNull(buildingrecord.getOfficeId())) {
			buildingrecord.setOfficeId(building.getOfficeId());
		}
		
		return buildingrepo.save(buildingrecord);
	}

	@Override
	public List<Building> getBuildingByOfficeId(Office officeId) {
		// TODO Auto-generated method stub
		
		return buildingrepo.findBuildingByOfficeId(officeId);
	}
	
}
