package com.jupiter.city.cityDescription.service;

import java.util.List;

import com.jupiter.city.cityDescription.Entity.SeatType;



public interface SeatTypeService {

	public SeatType saveSeatType(SeatType seatType);

	public List<SeatType> findAllSeatType();

	public SeatType findSeatTypeById(Integer id);

	public void deleteSeatTypeById(Integer seatTypeId);

	public SeatType updateSeatTypeById(Integer seatTypeId, SeatType seatType);

}
