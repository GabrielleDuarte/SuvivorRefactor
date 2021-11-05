package com.codetest.survivor1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
	private List<ItemInventory> itens;
	
	
	public Inventory() {
		super();
	}

	public Inventory(List<ItemInventory> itens) {
		super();
		this.itens = itens;
	}

	public List<ItemInventory> getItens() {
		return itens;
	}

	public void setItens(List<ItemInventory> itens) {
		this.itens = itens;
	}
	
	
	
}
