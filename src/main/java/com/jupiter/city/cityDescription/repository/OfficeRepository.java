package com.jupiter.city.cityDescription.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jupiter.city.cityDescription.Entity.City;
import com.jupiter.city.cityDescription.Entity.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office,Integer> {

	//@Query(value="SELECT officeId,isActive,officeName FROM office where cityId = ?1",nativeQuery=true)
	public List<Office> findByCityId(City city_id);

}
