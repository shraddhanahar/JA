package com.jupiter.city.cityDescription.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
@Entity
@Table(name="seat")

public class Seat {
	
	public Seat() {}

	public Seat(int seatId, byte isActive, int cubicleDeposition, String qrNumber, int seatNumber, String seatType,
			Floor floorId, SeatType seatTypeId) {
		super();
		this.seatId = seatId;
		this.isActive = isActive;
		this.cubicleDeposition = cubicleDeposition;
		this.qrNumber = qrNumber;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
		this.floorId = floorId;
		this.seatTypeId = seatTypeId;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", isActive=" + isActive + ", cubicleDeposition=" + cubicleDeposition
				+ ", qrNumber=" + qrNumber + ", seatNumber=" + seatNumber + ", seatType=" + seatType + ", floorId="
				+ floorId + ", seatTypeId=" + seatTypeId + "]";
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public int getCubicleDeposition() {
		return cubicleDeposition;
	}

	public void setCubicleDeposition(int cubicleDeposition) {
		this.cubicleDeposition = cubicleDeposition;
	}

	public String getQrNumber() {
		return qrNumber;
	}

	public void setQrNumber(String qrNumber) {
		this.qrNumber = qrNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public Floor getFloorId() {
		return floorId;
	}

	public void setFloorId(Floor floorId) {
		this.floorId = floorId;
	}

	public SeatType getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(SeatType seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	@Id
	@GeneratedValue
	private int seatId;
	
	private byte isActive;	

	private int cubicleDeposition;
	
	private String qrNumber;
	
	private int seatNumber;
	
	private String seatType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Floor floorId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	private SeatType seatTypeId;
	
	
}
