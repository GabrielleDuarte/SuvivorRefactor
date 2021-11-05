package com.codetest.survivor1.service;

import com.codetest.survivor1.entity.ItemInventory;
import com.codetest.survivor1.entity.Location;
import com.codetest.survivor1.entity.Survivor;

public interface SurvivorService {
	
	public void addSurvivor(Survivor survivor);
	
	public void warnInfectedSurvivor(Long id);
	
	public void updateLastLocation(Location newLastLocation, Long id);
	
	public void trade (Long id1, Long id2, Long id3, Long id4);
	
}
