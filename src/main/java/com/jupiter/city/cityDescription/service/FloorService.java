package com.jupiter.city.cityDescription.service;

import java.util.List;

import com.jupiter.city.cityDescription.Entity.Building;
import com.jupiter.city.cityDescription.Entity.Floor;

public interface FloorService {

	public Floor saveFloor(Floor floor);

	public List<Floor> findAllFloor();

	public Floor findFloorById(Integer id);

	public void deleteFloorById(Integer floorId);

	public Floor updateFloorById(Integer FloorId, Floor floor);

	public List<Floor> getFloorByBuildingId(Building id);

}
