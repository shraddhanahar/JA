package com.jupiter.city.cityDescription.Entity;

import javax.persistence.Column;
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
@Table(name="floor")
//@SecondaryTables({@SecondaryTable(name="seat")})
public class Floor {

	public Floor() {}
	
	public Floor(int floorId, byte isActive, String floorName, String floorPlan, Building buildingId) {
		super();
		this.floorId = floorId;
		this.isActive = isActive;
		this.floorName = floorName;
		this.floorPlan = floorPlan;
		this.buildingId = buildingId;
	}

	@Override
	public String toString() {
		return "Floor [floorId=" + floorId + ", isActive=" + isActive + ", floorName=" + floorName + ", floorPlan="
				+ floorPlan + ", buildingId=" + buildingId + "]";
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getFloorPlan() {
		return floorPlan;
	}

	public void setFloorPlan(String floorPlan) {
		this.floorPlan = floorPlan;
	}

	public Building getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Building buildingId) {
		this.buildingId = buildingId;
	}

	@Id
	@GeneratedValue
	@Column(name="floorId")
	private int floorId;
	
	private byte isActive;	

	private String floorName;
	
	private String floorPlan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Building buildingId;
	
	
}
