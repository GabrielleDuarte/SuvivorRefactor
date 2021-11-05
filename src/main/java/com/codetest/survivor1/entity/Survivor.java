package com.codetest.survivor1.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class Survivor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "name", length = 300)
	private String name;
	
    @NotNull
	@Column
	@Min(value = 0)
	@Max(value = 130)
	private int age;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Location lastLocation;
	
	@Column
	private int countInfectedFlag; 
	
	@Column
	private Boolean infectedFlag=false;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Inventory inventory;

	

	public Long getId() {
		return id;
	}

	public Location getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(Location lastLocation) {
		this.lastLocation = lastLocation;
	}
	
	
	private int getCountInfectedFlag() {
		return countInfectedFlag;
	}

	private void setCountInfectedFlag(int countInfectedFlag) {
		this.countInfectedFlag = countInfectedFlag;
	}

	public Boolean getInfectedFlag() {
		return infectedFlag;
	}

	private void setInfectedFlag(Boolean infectedFlag) {
		this.infectedFlag = infectedFlag;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void warnedInfection() {
		countInfectedFlag++;
		setCountInfectedFlag(countInfectedFlag++);
	}
	
	public void testInfected() {
		if(countInfectedFlag==5) {
			setInfectedFlag(true);
		}
	}
	
}
