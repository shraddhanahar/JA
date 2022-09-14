package com.jupiter.city.cityDescription.service;

import java.util.List;

import com.jupiter.city.cityDescription.Entity.Building;
import com.jupiter.city.cityDescription.Entity.City;
import com.jupiter.city.cityDescription.Entity.Office;

public interface BuildingService {

	public Building saveBuilding(Building building);

	public List<Building> findAllBuilding();

	public Building findBuildingById(Integer id);

	public void deleteBuildingById(Integer buildingId);

	public Building updateBuildingById(Integer buildingId, Building building);

	public List<Building> getBuildingByOfficeId(Office officeId);

}
