package com.jupiter.city.cityDescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jupiter.city.cityDescription.Entity.City;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

}
