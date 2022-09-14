package com.jupiter.city.cityDescription.Entity;

import javax.persistence.Column;
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
@Entity(name="city")
@Table(name="city")
//@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
//@SecondaryTables({@SecondaryTable(name="office")})
public class City {

	public City() {}
	public City(Integer cityId, int isActive, String cityName, String country, String pincode, String stateName) {
		super();
		this.cityId = cityId;
		this.isActive = isActive;
		this.cityName = cityName;
		this.country = country;
		this.pincode = pincode;
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", isActive=" + isActive + ", cityName=" + cityName + ", country=" + country
				+ ", pincode=" + pincode + ", stateName=" + stateName + "]";
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Id
	@GeneratedValue
	//@Column(name="cityId")
	private Integer cityId;
	
	private int isActive;
	
	private String cityName;
	
	private String country;
	
	private String pincode;
	
	private String stateName;
}
