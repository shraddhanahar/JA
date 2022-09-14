package com.jupiter.city.cityDescription.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jupiter.city.cityDescription.Entity.Floor;
import com.jupiter.city.cityDescription.Entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {

	public List<Seat> findByFloorId(Floor id);
}
