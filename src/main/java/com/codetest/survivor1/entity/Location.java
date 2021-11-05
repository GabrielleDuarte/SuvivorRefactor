package com.codetest.survivor1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull
	@Min(value = -90)
	@Max(value = +90)
	@Column(name = "latitude")
	private Long latitude;
	
	@NotNull
	@Min(value = -180)
	@Max(value = +180)
	@Column(name = "longitude")
	private Long longitude;

	public Location() {
	}

	public Location( @NotNull @Min(-90) @Max(90) Long latitude, @NotNull @Min(-180) @Max(180) Long longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	
}
