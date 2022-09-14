package com.jupiter.city.cityDescription.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jupiter.city.cityDescription.Entity.Building;
import com.jupiter.city.cityDescription.Entity.Office;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Integer> {

	public List<Building> findBuildingByOfficeId(Office id);
}
