package com.jupiter.city.cityDescription.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.city.cityDescription.Entity.Building;
import com.jupiter.city.cityDescription.Entity.Floor;
import com.jupiter.city.cityDescription.controller.BuildingNotFoundException;
import com.jupiter.city.cityDescription.controller.FloorNotFoundException;
import com.jupiter.city.cityDescription.repository.FloorRepository;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	private FloorRepository Floorrepo;
	
	@Override
	public Floor saveFloor(Floor floor) {
		// TODO Auto-generated method stub
		return Floorrepo.save(floor);
	}

	@Override
	public List<Floor> findAllFloor() {
		// TODO Auto-generated method stub
		return Floorrepo.findAll();
	}

	@Override
	public Floor findFloorById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Floor> floor =Floorrepo.findById(id);
		if(!floor.isPresent())
			throw new FloorNotFoundException("Floor not available");
		return Floorrepo.findById(id).get();
		
	}

	@Override
	public void deleteFloorById(Integer FloorId) {
		// TODO Auto-generated method stub
		Optional<Floor> floor =Floorrepo.findById(FloorId);
		if(!floor.isPresent())
			throw new FloorNotFoundException("Floor not available");
		Floorrepo.deleteById(FloorId);
	}

	@Override
	public Floor updateFloorById(Integer floorId, Floor floor) {
		// TODO Auto-generated method stub
		Optional<Floor> floorTemp =Floorrepo.findById(floorId);
		if(!floorTemp.isPresent())
			throw new FloorNotFoundException("Floor not available");
		Floor FloorRecord = Floorrepo.findById(floorId).get();
		
		if(Objects.nonNull(FloorRecord.getFloorName())) {
			FloorRecord.setFloorName(floor.getFloorName());
		}
		
		if(Objects.nonNull(FloorRecord.getFloorPlan())) {
			FloorRecord.setFloorPlan(floor.getFloorPlan());
		}
		
		if(Objects.nonNull(FloorRecord.getIsActive())) {
			FloorRecord.setIsActive(floor.getIsActive());
		}
		
		if(Objects.nonNull(FloorRecord.getBuildingId())) {
			FloorRecord.setBuildingId(floor.getBuildingId());
		}
		
		
		
		return Floorrepo.save(FloorRecord);
	}

	@Override
	public List<Floor> getFloorByBuildingId(Building id) {
		// TODO Auto-generated method stub
		return Floorrepo.findByBuildingId(id);
	}
	
}
