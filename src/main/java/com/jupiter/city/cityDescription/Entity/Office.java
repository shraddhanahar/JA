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

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
@Entity(name="office")
@Table(name="office")

//@SecondaryTables({@SecondaryTable(name="building")})
public class Office {

	public Office() {}
	
	public Office(int officeId, byte isActive, String officeName, City cityId) {
		super();
		this.officeId = officeId;
		this.isActive = isActive;
		this.officeName = officeName;
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "Office [officeId=" + officeId + ", isActive=" + isActive + ", officeName=" + officeName + ", cityId="
				+ cityId + "]";
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	@Id
	@GeneratedValue
	@Column(name="officeId")
	private int officeId;
	
	@Column(name="isActive")
	private byte isActive;
	
	@Column(name="officeName")
	private String officeName;	
	
	@ManyToOne(optional = false)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonIgnore
	@JoinColumn
	//@Column(name="cityId")
	private City cityId;
	
	
}
