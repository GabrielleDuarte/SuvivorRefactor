package com.codetest.survivor1.VO;


import com.codetest.survivor1.entity.Gender;
import com.codetest.survivor1.entity.Inventory;

public class SurvivorVO {

	private String name;
	
	private int age;
	
	private Long latitude;
	
	private Long longitude;
	
	private Gender gender;
	
	private Inventory inventory;
	

	public SurvivorVO() {
		gender = Gender.NON_BINARY;
		inventory = new Inventory();
	}

	public SurvivorVO(String name, int age, Long latitude, Long longitude, Gender gender, Inventory inventory) {
		this.name = name;
		this.age = age;
		this.latitude = latitude;
		this.longitude = longitude;
		this.gender = gender;
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
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
