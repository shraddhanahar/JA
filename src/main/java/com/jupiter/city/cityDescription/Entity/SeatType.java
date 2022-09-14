package com.jupiter.city.cityDescription.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
@Entity
@Table(name="seatType")
//@SecondaryTables({@SecondaryTable(name="seat")})
public class SeatType {
	
	public SeatType() {}

	public SeatType(int seatTypeId, int seatCode, String seatType, String seatName) {
		super();
		this.seatTypeId = seatTypeId;
		this.seatCode = seatCode;
		this.seatType = seatType;
		this.seatName = seatName;
	}

	@Override
	public String toString() {
		return "SeatType [seatTypeId=" + seatTypeId + ", seatCode=" + seatCode + ", seatType=" + seatType
				+ ", seatName=" + seatName + "]";
	}

	public int getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public int getSeatCode() {
		return seatCode;
	}

	public void setSeatCode(int seatCode) {
		this.seatCode = seatCode;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	@Id
	@GeneratedValue
	private int seatTypeId;
		
	private int seatCode;
	
	private String seatType;
	
	private String seatName;
}
