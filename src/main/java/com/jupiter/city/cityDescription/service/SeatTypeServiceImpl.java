package com.jupiter.city.cityDescription.service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jupiter.city.cityDescription.Entity.Seat;
import com.jupiter.city.cityDescription.Entity.SeatType;
import com.jupiter.city.cityDescription.controller.SeatNotFoundException;
import com.jupiter.city.cityDescription.repository.SeatTypeRepository;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {

	@Autowired
	private SeatTypeRepository SeatTyperepo;
	
	@Override
	public SeatType saveSeatType(SeatType SeatType) {
		// TODO Auto-generated method stub
		return SeatTyperepo.save(SeatType);
	}

	@Override
	public List<SeatType> findAllSeatType() {
		// TODO Auto-generated method stub
		return SeatTyperepo.findAll();
	}

	@Override
	public SeatType findSeatTypeById(Integer id) {
		// TODO Auto-generated method stub
		Optional<SeatType> seatType =SeatTyperepo.findById(id);
		if(!seatType.isPresent())
			throw new SeatNotFoundException("SeatType not available");
		return SeatTyperepo.findById(id).get();
		
	}

	@Override
	public void deleteSeatTypeById(Integer id) {
		// TODO Auto-generated method stub
		Optional<SeatType> seatType =SeatTyperepo.findById(id);
		if(!seatType.isPresent())
			throw new SeatNotFoundException("SeatType not available");
		SeatTyperepo.deleteById(id);
	}

	@Override
	public SeatType updateSeatTypeById(Integer SeatTypeId, SeatType SeatType) {
		// TODO Auto-generated method stub
		Optional<SeatType> seatType =SeatTyperepo.findById(SeatTypeId);
		if(!seatType.isPresent())
			throw new SeatNotFoundException("SeatType not available");
		SeatType SeatTypeRecord = SeatTyperepo.findById(SeatTypeId).get();
		
		if(Objects.nonNull(SeatTypeRecord.getSeatType())) {
			SeatTypeRecord.setSeatType(SeatType.getSeatType());
		}
		
		if(Objects.nonNull(SeatTypeRecord.getSeatTypeId())) {
			SeatTypeRecord.setSeatTypeId(SeatType.getSeatTypeId());
		}
		
		if(Objects.nonNull(SeatTypeRecord.getSeatName())) {
			SeatTypeRecord.setSeatName(SeatType.getSeatName());
		}
		
		if(Objects.nonNull(SeatTypeRecord.getSeatCode())) {
			SeatTypeRecord.setSeatCode(SeatType.getSeatCode());
		}
		
		
		return SeatTyperepo.save(SeatTypeRecord);
	}
	
}
