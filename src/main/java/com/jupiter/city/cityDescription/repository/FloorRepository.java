package com.jupiter.city.cityDescription.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jupiter.city.cityDescription.Entity.Building;
import com.jupiter.city.cityDescription.Entity.Floor;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Integer> {

	public List<Floor> findByBuildingId(Building id);

	
}

