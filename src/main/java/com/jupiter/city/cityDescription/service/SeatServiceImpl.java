package com.jupiter.city.cityDescription.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.city.cityDescription.Entity.Floor;
import com.jupiter.city.cityDescription.Entity.Seat;
import com.jupiter.city.cityDescription.controller.FloorNotFoundException;
import com.jupiter.city.cityDescription.controller.SeatNotFoundException;
import com.jupiter.city.cityDescription.repository.FloorRepository;
import com.jupiter.city.cityDescription.repository.SeatRepository;



@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatRepository seatrepo;
	
	@Autowired
	private FloorRepository floorrepo;
	
	@Override
	public Seat saveSeat(Seat seat) {
		// TODO Auto-generated method stub
		return seatrepo.save(seat);
	}

	@Override
	public List<Seat> findAllSeat() {
		// TODO Auto-generated method stub
		return seatrepo.findAll();
	}

	@Override
	public Seat findSeatById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Seat> seat =seatrepo.findById(id);
		if(!seat.isPresent())
			throw new SeatNotFoundException("Seat not available");
		return seatrepo.findById(id).get();
		
	}

	@Override
	public void deleteSeatById(Integer seatId) {
		// TODO Auto-generated method stub
		Optional<Seat> seat =seatrepo.findById(seatId);
		if(!seat.isPresent())
			throw new SeatNotFoundException("Seat not available");
		seatrepo.deleteById(seatId);
	}

	@Override
	public Seat updateSeatById(Integer SeatId, Seat seat) {
		// TODO Auto-generated method stub
		Optional<Seat> seatTemp =seatrepo.findById(SeatId);
		if(!seatTemp.isPresent())
			throw new SeatNotFoundException("Seat not available");
		Seat SeatRecord = seatrepo.findById(SeatId).get();
		
		if(Objects.nonNull(SeatRecord.getSeatNumber())) {
			SeatRecord.setSeatNumber(seat.getSeatNumber());
		}
		
		if(Objects.nonNull(SeatRecord.getSeatType())) {
			SeatRecord.setSeatType(seat.getSeatType());
		}
		
		if(Objects.nonNull(SeatRecord.getIsActive())) {
			SeatRecord.setIsActive(seat.getIsActive());
		}
		
		if(Objects.nonNull(SeatRecord.getSeatTypeId())) {
			SeatRecord.setSeatTypeId(seat.getSeatTypeId());
		}
		
		if(Objects.nonNull(SeatRecord.getQrNumber())) {
			SeatRecord.setQrNumber(seat.getQrNumber());
		}
		
		if(Objects.nonNull(SeatRecord.getFloorId())) {
			SeatRecord.setFloorId(seat.getFloorId());
		}
		
		if(Objects.nonNull(SeatRecord.getCubicleDeposition())) {
			SeatRecord.setCubicleDeposition(seat.getCubicleDeposition());
		}
		
		return seatrepo.save(SeatRecord);
	}

	@Override
	public List<Seat> getOfficeByFloorId(Floor id) {
		// TODO Auto-generated method stub
		List<Seat> seatRecord = seatrepo.findByFloorId(id);
		
		//if(!floorrepo.findById(id.getFloorId()).isPresent())
			//throw new FloorNotFoundException("Floor not present");
		
		
		
		//if(seatRecord.isEmpty())
			//throw new SeatNotFoundException("Seat not available");
		
		return seatRecord;
	}
	
}
