package com.jupiter.city.cityDescription.service;
import java.util.List;

import com.jupiter.city.cityDescription.Entity.Floor;
import com.jupiter.city.cityDescription.Entity.Seat;


public interface SeatService {

//	public Seat saveSeat(Seat seat);

	//public List<Seat> findAllSeat();

	public Seat findSeatById(Integer id);

	public void deleteSeatById(Integer SeatId);

	public Seat updateSeatById(Integer SeatId, Seat seat);

	public Seat saveSeat(Seat seat);

	public List<Seat> findAllSeat();

	public List<Seat> getOfficeByFloorId(Floor id);

}
