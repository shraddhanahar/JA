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
@Table(name="building")
//@SecondaryTables({@SecondaryTable(Name="floor")})
public class Building {

	public Building() {}
	
	@Id
	@GeneratedValue
	private int buildingId;
	
	private byte isActive;
	
	private String buildingName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Office officeId;

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Office getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Office officeId) {
		this.officeId = officeId;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", isActive=" + isActive + ", buildingName=" + buildingName
				+ ", officeId=" + officeId + "]";
	}

	public Building(int buildingId, byte isActive, String buildingName, Office officeId) {
		super();
		this.buildingId = buildingId;
		this.isActive = isActive;
		this.buildingName = buildingName;
		this.officeId = officeId;
	}
	
	
	
	
}
